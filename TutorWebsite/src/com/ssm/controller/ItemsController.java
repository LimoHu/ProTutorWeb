package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.Items;
import com.ssm.service.ItemsService;

@Controller
@RequestMapping("/Items")
public class ItemsController {

	//查询商品列表
	@Autowired
	ItemsService itemsService;
	
	@RequestMapping(value="/queryItemList", method = RequestMethod.GET) 
	@ResponseBody
	public List<Items> queryItemList() {
		List<Items> itemsList = itemsService.queryItemList();
		//request.setAttribute("itemsList", itemsList);
		return itemsList;
	}
	
	
	@RequestMapping(value="/queryItem",method = RequestMethod.POST)
	@ResponseBody
	public List<Items> queryItem(@RequestBody Items str){
		System.out.println(str.getId());
		List<Items> items = itemsService.queryItem(str);
		return items;
	}
}
