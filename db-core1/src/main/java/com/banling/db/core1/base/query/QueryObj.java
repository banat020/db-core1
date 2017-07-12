package com.banling.db.core1.base.query;

import java.io.Serializable;
import java.util.Map;

/**封装进行IBatis查询、更新、删除操作的SQL命名与入参。<br>
 * PS：<br>
 * 不影响之前的实现，也不打算应用这个类去重构之前的实现。
 * 
 * @author Ban
 *
 */
public class QueryObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7492964757145536183L;
	
	private String statementName;
	
	private Map<String,Object> paramsMap;

	public String getStatementName() {
		return statementName;
	}

	public void setStatementName(String statementName) {
		this.statementName = statementName;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

}
