package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.ApplyInfo;

public interface ApplyInfoService {
	public abstract int InsertApplyInfo(ApplyInfo applyInfo);
	public abstract List<Map<String, String>> SelectApplyInfoList(int recruitId);
	public abstract int ChooseApplicant(int applyId);
	public abstract int CheckApplyed(ApplyInfo applyInfo);
	public abstract List<Map<String, String>> SelectApplyList(int userId);
	
}
