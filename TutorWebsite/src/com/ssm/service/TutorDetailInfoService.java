package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.PageData;
import com.ssm.entity.TutorDetailInfo;
import com.ssm.entity.TutorQuery;

public interface TutorDetailInfoService {
	public abstract int AddTutorDetailInfo(TutorDetailInfo tutorDetailInfo);
	public abstract List<Map<String, String>> SelectTutorDetailInfoList(PageData pageData);
	public abstract List<Map<String, String>> SelectFourTutorDetailInfo();
	public abstract int GetTotalNumber();
	public abstract Map<String, String> SelectSingleTutorDetailInfo(int userId);
	public abstract int UpdateTutorDetailInfo(TutorDetailInfo tutorDetailInfo);
	public abstract List<Map<String, String>>QueryTutorInfoList(TutorQuery tutorQuery);
	public abstract int QueryTotalNumber(TutorQuery tutorQuery);
}
