package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.PageData;
import com.ssm.entity.RecruitInfo;
import com.ssm.entity.RecruitQuery;

public interface RecruitInfoService {
	public abstract int InsertRecruitInfo(RecruitInfo recruitInfo);
	public abstract List<Map<String, String>> SelectRecruitInfoList(PageData pageData);
	public abstract List<Map<String, String>> SelectThreeRecruitInfo();
	public abstract List<Map<String, String>> SelectTenRecruitInfo();
	public abstract Map<String, String> SelectSingleRecruitInfo(int recruitId);
	public abstract int GetTotalNumber();
	public abstract List<Map<String, String>> SelectInfoList(PageData pageData);
	public abstract int DeleteRecruitInfo(int recruitId);
	public abstract List<Map<String, String>> SelectClassTypeAnalyse();
	public abstract List<Map<String, String>> SelectMarkAnalyse();
	public abstract List<Map<String, String>> QueryRecruitInfoList(RecruitQuery recruitQuery);
	public abstract int QueryRecruitNumber(RecruitQuery recruitQuery);
	public abstract List<Map<String, String>>SelectRecruiSample(int userId);
}
