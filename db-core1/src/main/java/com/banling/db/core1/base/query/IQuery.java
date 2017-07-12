package com.banling.db.core1.base.query;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**IBatis数据访问通用工具接口。
 * @author Ban
 *
 */
public interface IQuery {
	
	/** 获取记录总数
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return
	 */
	int queryForCount(String statementName, Map<String,Object> paramsMap);

	
	/** 是否已有记录
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return
	 */
	boolean isExists(String statementName, Map<String,Object> paramsMap);
	
	
	/** 获取记录列表，不分页
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return
	 */
	List<Map<String, Object>> queryForList(String statementName, Map<String,Object> paramsMap);
	
	
	/** （根据跳过记录与每页记录数）获取分页列表（自动拼装物理分页语句，无需在xml里编写）
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @param skip int 起始记录
	 * @param size int 返回记录数
	 * @return
	 */
	List<Map<String, Object>> queryForPage(String statementName, Map<String,Object> paramsMap,int skip, int size);
	
	
	/** 获取单个对象
	 * @param statementName	查询语句名称
	 * @param paramsMap		查询条件,Map键值对
	 * @return
	 */
	Object queryForObject(String statementName, Map<String,Object> paramsMap);
	
	SqlMapClientTemplate getSqlMapClientTemplate();
	
	/**对单表进行条件更新操作。<br>
	 * 不用系统的声明式事务，用编程式事务。<br>
	 * <b>慎用</b>
	 * 
	 * @param statementName 查询语句名称
	 * @param paramsMap 查询条件,Map键值对
	 * @return boolean
	 */
	boolean updateOneTable(String statementName, Map<String,Object> paramsMap);
	
	/**对单表或者多表进行条件更新操作。<br>
	 * 不用系统的声明式事务，用编程式事务。<br>
	 * <b>慎用</b>
	 * 
	 * @param queryObjs
	 * @return boolean
	 */
	boolean updateByBatch(QueryObj...queryObjs);
		
}
