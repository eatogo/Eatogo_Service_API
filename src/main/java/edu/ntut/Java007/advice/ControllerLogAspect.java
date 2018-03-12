package edu.ntut.Java007.advice;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ControllerLogAspect {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(ControllerLogAspect.class);
	
	@Pointcut("execution(* edu.ntut.Java007.web.controllers.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		String url = request.getRequestURL().toString();
		String ip = request.getRemoteAddr();
		Signature signature = joinPoint.getSignature();
		String classMethod = signature.getDeclaringTypeName() + "." + signature.getName() + "()";
		Object[] args = joinPoint.getArgs();
		
		RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
		
		LOG.info("Request {}", requestLog);
	}
	
	@After("log()")
	public void doAfter() {
		// do after pointcut was executed
	}
	
	@AfterThrowing(throwing = "e", pointcut = "log()")
	public void doAfterThrowing(Exception e) {
		// do after pointcut throws exception
	}
	
	@AfterReturning(returning = "result", pointcut = "log()")
	public void doAfterReturning(Object result) {
		LOG.info("Result : {}", result);
	}
	
	private class RequestLog {

		private String url;
		private String ip;
		private String classMethod;
		private Object[] args;

		public RequestLog(String url, String ip, String classMethod, Object[] args) {
			super();
			this.url = url;
			this.ip = ip;
			this.classMethod = classMethod;
			this.args = args;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("RequestLog [")
				.append("url=").append(url)
				.append(", ip=").append(ip)
				.append(", classMethod=").append(classMethod)
				.append(", args=").append(Arrays.toString(args))
				.append("]");
			return builder.toString();
		}
	}
	
}