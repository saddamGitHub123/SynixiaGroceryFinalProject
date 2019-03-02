package com.backend.restbackend.order.model;

import java.util.List;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.order.dto.Order;



public class OrderListResponse extends SuccResponse{
	
	List<Order> orderList;

	public OrderListResponse(List<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	

}
