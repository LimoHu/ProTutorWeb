package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.ShareInfo;
import com.ssm.entity.ShareInfoQuery;
import com.ssm.mapper.ShareInfoMapper;
import com.ssm.service.ShareInfoService;
@Service("ShareInfoService")
public class ShareInfoServiceImpl implements ShareInfoService {
	
static Logger logging = Logger.getLogger(ApplyInfoImpl.class.getName());
	
	@Autowired
	ShareInfoMapper shareInfoMapper;

	@Override
	public int InsertShareInfo(ShareInfo shareInfo) {
		// TODO Auto-generated method stub
		return shareInfoMapper.insertShareInfo(shareInfo);
	}

	@Override
	public List<Map<String, String>> SelectShareInfoList(ShareInfoQuery shareInfoQuery) {
		// TODO Auto-generated method stub
		return shareInfoMapper.selectShareInfoList(shareInfoQuery);
	}

	@Override
	public Map<String, String> SelectSingleShareInfo(int shareId) {
		// TODO Auto-generated method stub
		return shareInfoMapper.selectSingleShareInfo(shareId);
	}

	@Override
	public int GetShareInfoTotal() {
		// TODO Auto-generated method stub
		return shareInfoMapper.getShareInfoTotal();
	} 
}
