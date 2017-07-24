package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.PageData;
import com.ssm.entity.TutorDetailInfo;
import com.ssm.entity.TutorQuery;

public interface TutorDetailInfoMapper {
	int AddTutorDetailInfo(TutorDetailInfo tutorDetailInfo);
	List<Map<String, String>> SelectTutorDetailInfoList(PageData pageData);
	List<Map<String, String>> SelectFourTutorDetailInfo();
	Map<String, String> SelectSingleTutorDetailInfo(int userId);
	int getTotalNumber();
	int updateDetail(TutorDetailInfo tutorDetailInfo);
	List<Map<String, String>>queryTutorInfoList(TutorQuery tutorQuery);
	int queryTotalNumber(TutorQuery tutorQuery);
}

