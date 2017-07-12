package com.banling.db.core1.sys.dao.impl;

import org.springframework.stereotype.Component;

import com.banling.db.core1.base.dao.impl.GenericDao;
import com.banling.db.core1.module.sys.SysUsers;
import com.banling.db.core1.sys.dao.ISysUsersDao;

@Component("sysUserDao")
public class SysUsersDao extends GenericDao<SysUsers> implements ISysUsersDao {

}
