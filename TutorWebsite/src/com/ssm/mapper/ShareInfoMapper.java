package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.ShareInfo;
import com.ssm.entity.ShareInfoQuery;

public interface ShareInfoMapper {
	int insertShareInfo(ShareInfo shareInfo);
	List<Map<String, String>> selectShareInfoList(ShareInfoQuery shareInfoQuery);
	Map<String, String> selectSingleShareInfo(int shareId);
	int getShareInfoTotal();
}
