package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.CollectInfo;

public interface CollectInfoService {
	public abstract int InsertCollectInfo(CollectInfo collectInfo);
	public abstract Map<String, String> CheckCollectedInfo(CollectInfo collectInfo);
	public abstract List<Map<String, String>> SelectCollectList(int userId);
}
