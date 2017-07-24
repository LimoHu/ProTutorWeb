package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.PageData;
import com.ssm.entity.TutorDetailInfo;
import com.ssm.entity.TutorQuery;
import com.ssm.mapper.TutorDetailInfoMapper;
import com.ssm.service.TutorDetailInfoService;

@Service("TutorDetailInfoService")
public class TutorDetailInfoImpl implements TutorDetailInfoService {

static Logger logging = Logger.getLogger(ItemsServiceImpl.class.getName());
	
	@Autowired
	TutorDetailInfoMapper tutorDetailInfoMapper;
	@Override
	public int AddTutorDetailInfo(TutorDetailInfo tutorDetailInfo) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.AddTutorDetailInfo(tutorDetailInfo);
	}
	
	@Override
	public List<Map<String, String>> SelectTutorDetailInfoList(PageData pageData) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.SelectTutorDetailInfoList(pageData);
	}

	@Override
	public List<Map<String, String>> SelectFourTutorDetailInfo() {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.SelectFourTutorDetailInfo();
	}

	@Override
	public int GetTotalNumber() {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.getTotalNumber();
	}

	@Override
	public Map<String, String> SelectSingleTutorDetailInfo(int userId) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.SelectSingleTutorDetailInfo(userId);
	}

	@Override
	public int UpdateTutorDetailInfo(TutorDetailInfo tutorDetailInfo) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.updateDetail(tutorDetailInfo);
	}

	@Override
	public List<Map<String, String>> QueryTutorInfoList(TutorQuery tutorQuery) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.queryTutorInfoList(tutorQuery);
	}

	@Override
	public int QueryTotalNumber(TutorQuery tutorQuery) {
		// TODO Auto-generated method stub
		return tutorDetailInfoMapper.queryTotalNumber(tutorQuery);
	}

}
