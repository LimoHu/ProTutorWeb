package com.ssm.service;

import com.ssm.entity.Items;

import java.util.List;


public interface ItemsService {
	//查询商品列表
	List<Items> queryItemList();

	List<Items> queryItem(Items id);
	
	
}
