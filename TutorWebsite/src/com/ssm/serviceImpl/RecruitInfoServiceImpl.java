package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.PageData;
import com.ssm.entity.RecruitInfo;
import com.ssm.entity.RecruitQuery;
import com.ssm.mapper.RecruitInfoMapper;
import com.ssm.service.RecruitInfoService;
@Service("RecruitInfoService")

public class RecruitInfoServiceImpl implements RecruitInfoService {
	static Logger logging = Logger.getLogger(ItemsServiceImpl.class.getName());

	@Autowired
	RecruitInfoMapper recruitInfoMapper;
	@Override
	public int InsertRecruitInfo(RecruitInfo recruitInfo) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.InsertRecruitInfo(recruitInfo);
	}
	
	@Override
	public List<Map<String, String>> SelectRecruitInfoList(PageData pageData) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.SelectRecruitInfoList(pageData);
	}

	@Override
	public List<Map<String, String>> SelectThreeRecruitInfo() {
		// TODO Auto-generated method stub
		return recruitInfoMapper.SelectThreeRecruitInfo();
	}

	@Override
	public List<Map<String, String>> SelectTenRecruitInfo() {
		// TODO Auto-generated method stub
		return recruitInfoMapper.SelectTenRecruitInfo();
	}

	@Override
	public Map<String, String> SelectSingleRecruitInfo(int recruitId) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.SelectSingleRecruitInfo(recruitId);
	}

	@Override
	public int GetTotalNumber() {
		// TODO Auto-generated method stub
		return recruitInfoMapper.getTotalNumber();
	}

	@Override
	public List<Map<String, String>> SelectInfoList(PageData pageData) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.SelectInfoList(pageData);
	}

	@Override
	public int DeleteRecruitInfo(int recruitId) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.deleteRecruitInfo(recruitId);
	}

	@Override
	public List<Map<String, String>> SelectClassTypeAnalyse() {
		// TODO Auto-generated method stub
		return recruitInfoMapper.selectClassTypeAnalyse();
	}

	@Override
	public List<Map<String, String>> SelectMarkAnalyse() {
		// TODO Auto-generated method stub
		return recruitInfoMapper.selectMarkAnalyse();
	}

	@Override
	public List<Map<String, String>> QueryRecruitInfoList(
			RecruitQuery recruitQuery) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.queryRecruitInfoList(recruitQuery);
	}

	@Override
	public int QueryRecruitNumber(RecruitQuery recruitQuery) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.queryRecruitNumber(recruitQuery);
	}

	@Override
	public List<Map<String, String>> SelectRecruiSample(int userId) {
		// TODO Auto-generated method stub
		return recruitInfoMapper.selectRecruiSample(userId);
	}
}
