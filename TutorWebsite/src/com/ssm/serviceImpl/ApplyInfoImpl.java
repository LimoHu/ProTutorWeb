package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.ApplyInfo;
import com.ssm.mapper.ApplyInfoMapper;
import com.ssm.service.ApplyInfoService;

@Service("ApplyInfoService")
public class ApplyInfoImpl implements ApplyInfoService {
	static Logger logging = Logger.getLogger(ApplyInfoImpl.class.getName());
	
	@Autowired
	ApplyInfoMapper applyInfoMapper; 
	
	public int InsertApplyInfo(ApplyInfo applyInfo) {
		// TODO Auto-generated method stub
		return applyInfoMapper.insertApplyInfo(applyInfo);
	}

	@Override
	public List<Map<String, String>> SelectApplyInfoList(int recruitId) {
		// TODO Auto-generated method stub
		return applyInfoMapper.selectApplyInfoList(recruitId);
	}

	@Override
	public int ChooseApplicant(int applyId) {
		// TODO Auto-generated method stub
		return applyInfoMapper.chooseApplicant(applyId);
	}

	@Override
	public int CheckApplyed(ApplyInfo applyInfo) {
		// TODO Auto-generated method stub
		return applyInfoMapper.checkApplyed(applyInfo);
	}

	@Override
	public List<Map<String, String>> SelectApplyList(int userId) {
		// TODO Auto-generated method stub
		return applyInfoMapper.selectApplyList(userId);
	}
	
	

}
