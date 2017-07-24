package com.ssm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.Items;
import com.ssm.entity.ItemsExample;
import com.ssm.mapper.ItemsMapper;
import com.ssm.service.ItemsService;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	static Logger logging = Logger.getLogger(ItemsServiceImpl.class.getName());
	@Autowired
	ItemsMapper itemsMapper;

	@Override
	public List<Items> queryItemList() {
		logging.debug("进入了查询方法...");
		ItemsExample example = new ItemsExample();
		List<Integer> list  = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		example.createCriteria().andIdIn(list);
		logging.debug("结束了查询方法...");
		return itemsMapper.selectByExample(example);
	}
	
	public List<Items> queryItem(Items str) {
		int id=str.getId();
		logging.debug("进入了查询方法...");
		return itemsMapper.selectByPrimaryKey(id);
	}
	

}
