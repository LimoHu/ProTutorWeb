package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.ShareInfo;
import com.ssm.entity.ShareInfoQuery;

public interface ShareInfoService {
	public abstract int InsertShareInfo(ShareInfo shareInfo);
	public abstract List<Map<String, String>> SelectShareInfoList(ShareInfoQuery shareInfoQuery);
	public abstract Map<String, String> SelectSingleShareInfo(int shareId);
	public abstract int GetShareInfoTotal();
}
