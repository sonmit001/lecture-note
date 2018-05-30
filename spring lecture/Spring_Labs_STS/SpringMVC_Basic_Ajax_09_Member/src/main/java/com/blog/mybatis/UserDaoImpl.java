package com.blog.mybatis;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.dao.UserDao;
import com.blog.vo.UserVo;
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int getLoginResult(Map<String, String> map) {
		return (Integer) getSqlSession().selectOne("userDao.getLoginResult",map);
	}

	@Override
	public UserVo getUserInfo(String id) {
		return (UserVo) getSqlSession().selectOne("userDao.getUserInfo",id);
	}

	@Override
	public int getUserIdCheck(String id) {
		return (Integer) getSqlSession().selectOne("userDao.getUserIdCheck",id);
	}

	@Override
	public int insertUser(UserVo userVo) {
		
		System.out.println("insert");
		return getSqlSession().update("userDao.insertUser",userVo);
	}
	
}
