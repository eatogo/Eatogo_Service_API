package edu.ntut.Java007.web.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.persistence.po.Order;
import edu.ntut.Java007.backend.persistence.po.OrderDetail;
import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.backend.service.FoodService;
import edu.ntut.Java007.backend.service.OrderService;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.utils.DateUtils;
import edu.ntut.Java007.utils.OrderUtils;
import edu.ntut.Java007.web.vo.OrderDetailPayload;
import edu.ntut.Java007.web.vo.OrderPayload;

@RestController
@RequestMapping("/store/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private Map<String, Object> returnJson;
	
	Date beginTime, endTime;

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/{storeId}")
	public Map<String, Object> getOrders(@PathVariable Integer storeId) throws ParseException, JsonProcessingException {
		returnJson = new HashMap<>();
		beginTime = DateUtils.formatDate("2000-01-01");
		endTime = DateUtils.formatDate("2018-12-31");
		// 確認期間內是否有訂單存在
		Order isOrderExist = orderService.isOrderExistsBetweenOrderTime(storeId, beginTime, endTime);
		if (isOrderExist != null) {
			Map<String, Object> returnMap = new HashMap<>();
			// 分別取出各種狀態訂單，分成三類後，存進returnMap
			returnMap = getOrdersByOrderStatus(storeId, returnMap, "ordered", "ordered");
			returnMap = getOrdersByOrderStatus(storeId, returnMap, "unfinished", "unfinished", "unconfirmd_store");
			returnMap = getOrdersByOrderStatus(storeId, returnMap, "finished", "unconfirmd_user", "finished", "abandoned");
			// 將returnMap序列化後再存到returnJson
			String jsonInString = mapper.writeValueAsString(returnMap);
			returnJson.put("orderPayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 200);
			returnJson.put("orderPayload", "null");
		}
		return returnJson;
	}
	
	// 分別對每種orderStatus做查詢，存成List<OrderPayload>，再存進orderMap
	// key為其orderStatus，value為該List<OrderPayload>
	// 將orderMap存add進orderList
	// 再put進returnMap，key為keyName，value為orderMap
	// 回傳returnMap
	/**
	 * 
	 * @param storeId 為查詢訂單的店家Id
	 * @param returnMap 將查詢到的店家資訊存入後回傳
	 * @param keyName 將查詢到的店家資訊存入returnMap的key值
	 * @param orderStatuses 要查詢的幾種訂單狀態，不定數量，為陣列
	 * @return returnMap
	 * @throws JsonProcessingException
	 */
	private Map<String, Object> getOrdersByOrderStatus(Integer storeId, Map<String, Object> returnMap, String keyName , String... orderStatuses) throws JsonProcessingException {
		// 此List為儲存各種訂單狀態的訂單列表陣列，每個元素都是一種訂單狀態列表的Map
		List<Map<String, Object>> orderList = new ArrayList<>();
		for (String orderStatus : orderStatuses) {
			// 此Map儲存一種訂單狀態的訂單列表，key為該"訂單狀態+Orders"
			Map<String, Object> orderMap = new HashMap<>();
			List<OrderPayload> payloads = new ArrayList<>();
			
			// 依照店家Id、訂單狀態及時間區段來取訂單列表，並按照訂購時間由近到遠排序
			List<Order> orders = orderService.findOrdersByOrderStoreAndOrderStatusAndOrderTimeBetweenOrderByOrderTimeDesc(storeId, orderStatus, beginTime, endTime);
			for (Order order : orders) {
				List<OrderDetailPayload> detailPayloads = new ArrayList<>();
				
				List<OrderDetail> orderDetails = orderService.findOrderDetailsByOrderId(order.getOrderId());
				for (OrderDetail orderDetail : orderDetails) {
					Food food = foodService.findFoodByFoodId(orderDetail.getOrderFood());
					OrderDetailPayload detailPayload = OrderUtils.fromDomainOrderDetailToWebOrderDetailPayload(orderDetail, food);
					detailPayloads.add(detailPayload);
				}
				User orderUser = userService.findByUserId(order.getOrderUser());
				User confirmOrderUser = userService.findByUserId(order.getOrderConfirmUser());
				OrderPayload payload = new OrderPayload();
				if (orderStatus == "finished" || orderStatus == "unconfirmd_user" || orderStatus == "abandoned") {
					payload = OrderUtils.fromDomainOrderToWebFinishedOrderPayload(order, orderUser, confirmOrderUser, detailPayloads);
				} else if (orderStatus == "unfinished" || orderStatus == "unconfirmd_store") {
					payload = OrderUtils.fromDomainOrderToWebUnfinishedOrderPayload(order, orderUser, confirmOrderUser, detailPayloads);
				} else if (orderStatus == "ordered") {
					payload = OrderUtils.fromDomainOrderToWebOrderedOrderPayload(order, orderUser, detailPayloads);
				}
				payloads.add(payload);
			}
			orderMap.put(orderStatus + "_orders", payloads);
			orderList.add(orderMap);
		}
		returnMap.put(keyName, orderList);
		return returnMap;
	}
}