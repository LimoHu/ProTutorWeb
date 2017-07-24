package com.ssm.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonMethod {
	public Map<String, Object> HandleData(String statusCode,Map<String, String> data) {
		Map<String, Object> mapData =new HashMap<String, Object>();
		mapData.put("code", statusCode);
		mapData.put("data", data);
		return mapData;
	}
	
	public <T> Map<String, Object> HandleMapData(String statusCode,List<T> data) {
		Map<String, Object> mapData =new HashMap<String, Object>();
		mapData.put("code", statusCode);
		mapData.put("data", data);
		return mapData;
	}
	
	public Map<String, Object> HandleDataList(String statusCode,List<Map<String, String>> data) {
		Map<String, Object> mapData =new HashMap<String, Object>();
		mapData.put("code", statusCode);
		mapData.put("data", data);
		return mapData;
	}
	
	public Map<String, Object> HandlePageData(int totalNum,List<Map<String, String>> data,int pageSize) {
		Map<String, Object> mapData =new HashMap<String, Object>();
		double totalPage = Math.ceil((double)totalNum/pageSize);
		mapData.put("data", data);
		mapData.put("code", "0000");
		mapData.put("totalPage", totalPage);
		mapData.put("totalNumber", totalNum);
		return mapData;
	}
	
	public Map<String, Object> HandleDataObjedt(Map<String, String> data,String objStr,List<HashMap<String, String>> objData) {
		Map<String, Object> mapData =new HashMap<String, Object>();
		Map<String, Object> mapObject =new HashMap<String, Object>();
		for (String str : data.keySet()) {
			mapObject.put(str, data.get(str));
		}
		mapObject.put(objStr, objData);
		mapData.put("data", mapObject);
		mapData.put("code", "0000");
		return mapData;
	}
	
}
