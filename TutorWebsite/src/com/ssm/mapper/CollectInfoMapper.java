package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.CollectInfo;

public interface CollectInfoMapper {
	int insertCollectInfo(CollectInfo collectInfo);
	Map<String, String> checkCollected(CollectInfo collectInfo);
	List<Map<String, String>> selectCollectList(int userId);
}
