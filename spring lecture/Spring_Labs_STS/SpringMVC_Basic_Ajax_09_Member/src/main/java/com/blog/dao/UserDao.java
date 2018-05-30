package com.blog.dao;

import java.util.Map;

import com.blog.vo.UserVo;

public interface UserDao {
	public int getLoginResult(Map<String, String> map);
	public UserVo getUserInfo(String id);
	public int getUserIdCheck(String id);
	public int insertUser(UserVo userVo);
}
