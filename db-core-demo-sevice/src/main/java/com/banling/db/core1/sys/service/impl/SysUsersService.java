package com.banling.db.core1.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.banling.db.core1.base.dao.IGenericDao;
import com.banling.db.core1.base.service.impl.GenericService;
import com.banling.db.core1.module.sys.SysUsers;
import com.banling.db.core1.sys.dao.ISysUsersDao;
import com.banling.db.core1.sys.service.ISysUsersService;


@Service
public class SysUsersService extends GenericService<SysUsers> implements ISysUsersService {

	@Resource
	private ISysUsersDao sysUserDao;
	
	@Override
	public IGenericDao<SysUsers> getDao() {
		// TODO Auto-generated method stub
		return sysUserDao;
	}

}
