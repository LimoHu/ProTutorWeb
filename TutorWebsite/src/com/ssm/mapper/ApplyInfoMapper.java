package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.ApplyInfo;

public interface ApplyInfoMapper {
	int insertApplyInfo(ApplyInfo applyInfo);
	List<Map<String, String>> selectApplyInfoList(int recruitId);
	int chooseApplicant(int applyId);
	int checkApplyed(ApplyInfo applyInfo);
	List<Map<String, String>> selectApplyList(int userId);
	
}
