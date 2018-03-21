package com.backend.restbackend.order.model;

import java.util.List;

import com.backend.restbackend.common.SuccResponse;

public class OrderSizeResponse extends SuccResponse{
	
	List<OrderSizeModel> orderList;
	
	

	public OrderSizeResponse(List<OrderSizeModel> orderList) {
		super();
		this.orderList = orderList;
	}

	public List<OrderSizeModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderSizeModel> orderList) {
		this.orderList = orderList;
	}
	
	
	

}
