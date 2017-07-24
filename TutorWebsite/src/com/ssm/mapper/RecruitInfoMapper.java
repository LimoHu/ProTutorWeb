package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.RecruitQuery;
import com.ssm.entity.PageData;
import com.ssm.entity.RecruitInfo;

public interface RecruitInfoMapper {
	int InsertRecruitInfo(RecruitInfo recruitInfo);
	List<Map<String, String>> SelectRecruitInfoList(PageData pageData);
	List<Map<String, String>> SelectThreeRecruitInfo();
	List<Map<String, String>> SelectTenRecruitInfo();
	Map<String, String> SelectSingleRecruitInfo(int recruitId);
	int getTotalNumber();
	List<Map<String, String>> SelectInfoList(PageData pageData);
	int deleteRecruitInfo(int recruitId);
	List<Map<String, String>> selectClassTypeAnalyse();
	List<Map<String, String>> selectMarkAnalyse();
	List<Map<String, String>> queryRecruitInfoList(RecruitQuery recruitQuery);
	int queryRecruitNumber(RecruitQuery recruitQuery);
	List<Map<String, String>>selectRecruiSample(int userId);
	
}

