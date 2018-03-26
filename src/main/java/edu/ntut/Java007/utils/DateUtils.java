package edu.ntut.Java007.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 將日期字串轉為java.util.Date類別物件，字串格式為"yyyy-MM-dd"
	 * @param date 日期字串
	 * @return java.util.Date類別物件
	 * @throws ParseException
	 */
	public static Date formatDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}
}
