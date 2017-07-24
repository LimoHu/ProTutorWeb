package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.CollectInfo;
import com.ssm.mapper.CollectInfoMapper;
import com.ssm.service.CollectInfoService;

@Service("CollectInfoService")
public class CollectInfoServiceImpl implements CollectInfoService {
	
	static Logger logging = Logger.getLogger(ApplyInfoImpl.class.getName());
	
	@Autowired
	CollectInfoMapper collectInfoMapper;

	@Override
	public int InsertCollectInfo(CollectInfo collectInfo) {
		// TODO Auto-generated method stub
		return collectInfoMapper.insertCollectInfo(collectInfo);
	}

	@Override
	public Map<String, String> CheckCollectedInfo(CollectInfo collectInfo) {
		// TODO Auto-generated method stub
		return collectInfoMapper.checkCollected(collectInfo);
	}

	@Override
	public List<Map<String, String>> SelectCollectList(int userId) {
		// TODO Auto-generated method stub
		return collectInfoMapper.selectCollectList(userId);
	}

}
