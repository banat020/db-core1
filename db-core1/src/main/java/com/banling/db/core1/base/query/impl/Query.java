package com.banling.db.core1.base.query.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import com.banling.db.core1.base.query.QueryObj;
import com.banling.db.core1.base.query.IQuery;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**IBatis数据访问通用工具实现。
 * @author Ban
 *
 */
@Service
public class Query implements IQuery {

	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;


	@Override
	public int queryForCount(String statementName, Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		Object result = this.queryForObject(statementName, paramsMap);
		return result == null ? 0 : (Integer) result;
	}


	@Override
	public boolean isExists(String statementName, Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return this.queryForCount(statementName, paramsMap) > 0;
	}


	@Override
	public List<Map<String, Object>> queryForList(String statementName,
			Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlMapClientTemplate.queryForList(statementName, paramsMap);
	}


	@Override
	public List<Map<String, Object>> queryForPage(String statementName,
			Map<String, Object> paramsMap, int skip, int size) {
		// TODO Auto-generated method stub
		return sqlMapClientTemplate.queryForList(statementName, paramsMap, skip, size);
	}


	@Override
	public Object queryForObject(String statementName,Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlMapClientTemplate.queryForObject(statementName, paramsMap);
	}


	@Override
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
		return sqlMapClientTemplate;
	}

	@Override
	public boolean updateOneTable(final String statementName,
			final Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		boolean result=false;
		try{
			result= sqlMapClientTemplate.execute(new SqlMapClientCallback(){
	
				@Override
				public Object doInSqlMapClient(SqlMapExecutor sqlmapexecutor)
						throws SQLException {
					// TODO Auto-generated method stub
					sqlMapClientTemplate.getSqlMapClient().startTransaction();
					sqlmapexecutor.update(statementName, paramsMap);
					sqlMapClientTemplate.getSqlMapClient().commitTransaction();
					return true;
				}});
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(result==false){
				try {
					sqlMapClientTemplate.getSqlMapClient().endTransaction();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		return result;
	}


	@Override
	public boolean updateByBatch(final QueryObj... queryObjs) {
		// TODO Auto-generated method stub
		boolean result=false;
		try{
			result=sqlMapClientTemplate.execute(new SqlMapClientCallback(){
	
				@Override
				public Object doInSqlMapClient(SqlMapExecutor sqlmapexecutor)
						throws SQLException {
					// TODO Auto-generated method stub
					if(queryObjs.length>0){
						sqlMapClientTemplate.getSqlMapClient().startTransaction();
						sqlmapexecutor.startBatch();
						for(int i=0,count=queryObjs.length;i<count;i++){
							String statementName=queryObjs[i].getStatementName();
							Map<String,Object> paramsMap=queryObjs[i].getParamsMap();					
							sqlmapexecutor.update(statementName, paramsMap);							
						}
						sqlmapexecutor.executeBatch();
					}
					
					sqlMapClientTemplate.getSqlMapClient().commitTransaction();
					return true;
				}});
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(result==false){
				try {
					sqlMapClientTemplate.getSqlMapClient().endTransaction();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
