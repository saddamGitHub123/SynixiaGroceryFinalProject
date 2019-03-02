package com.backend.restbackend.dao;

import java.util.List;

import com.backend.restbackend.order.dto.Order;
import com.backend.restbackend.order.model.DispatchRequest;
import com.backend.restbackend.order.model.OrderRequest;
import com.backend.restbackend.order.model.OrderRequestAdd;
import com.backend.restbackend.order.model.OrderSizeModel;
import com.backend.restbackend.order.model.OrderSizeRequest;
import com.backend.restbackend.order.model.Ordered_List;
import com.backend.restbackend.user.dto.User;



/**
 * 
 * @author saddam
 *
 */
public interface OrderDAO {

	// Add the order list using shopID and userID

	boolean addOrder(OrderRequest orderRequest);
	
	
	// Add the order list using shopID and userID

		String addOrderAndOrderID(OrderRequestAdd orderRequest);

	// order list and user details by shopID
	List<Ordered_List> userOrderListByShopId(String Shop_ID,String User_ID,boolean Dispatch);
	
	
  // Order Dispatch method
	
	boolean orderDispatchOrderID(DispatchRequest dispatchRequest);
	
	
	
	//getting order size and orderid list 
	
	List<OrderSizeModel> orderSizeList(OrderSizeRequest orderSizeRequest);
	
	
	//orderList for mobile app using orderid
	
	List<Order> orderList(OrderSizeRequest orderSizeReques);
	
	
	//getting phone number for dispatch controller sms intrgation 
	
	List<User> userPhoneNumber(DispatchRequest dispatchRequest);
	

	
	//List of Order
	List<Order> listOfOrder();
}
