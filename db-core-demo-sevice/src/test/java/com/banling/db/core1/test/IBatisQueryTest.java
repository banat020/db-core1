package com.banling.db.core1.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banling.db.core1.base.query.IQuery;


public class IBatisQueryTest {
	private static Logger logger=Logger.getLogger(IBatisQueryTest.class);
	private static BeanFactory beanFactory = null;
	
	private static IQuery query;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext(
				"config/db/applicationContext-db.xml");
		query=(IQuery)beanFactory.getBean("query");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByWhere(){
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put("userName", "%user%");
		List<Map<String, Object>> list=query.queryForPage("SysUsers.findByWhere", paramsMap, 2, 5);
		for(Map<String,Object> user:list){
			logger.info("USER_NAME:"+user.get("user_name")+",   USER_AGE:"+user.get("user_age"));
		}
	}
	
	@Test
	public void testUpdateUser() {		
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put("userName", "admin");
		paramsMap.put("userId", "id_1");		
		System.out.println("SysUser.testUpdateWithCondition:"+query.updateOneTable("SysUsers.testUpdateWithCondition", paramsMap));
	}

}
