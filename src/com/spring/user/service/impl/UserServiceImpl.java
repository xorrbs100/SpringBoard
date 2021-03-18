package com.spring.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.service.UserService;
import com.spring.user.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public int userInsert(UserVo userVo) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userInsert(userVo);
	}
	@Override
	public int userIdChk(UserVo userVo) throws Exception {
		// TODO Auto-generated method stub
		int result=userDao.userIdChk(userVo);
		return result;
	}
	public List<String> comPhone(String comPhone) throws Exception {
		// TODO Auto-generated method stub
		return userDao.comPhone(comPhone);
	}
	@Override
	public int userPwChk(UserVo userVo) throws Exception {
		// TODO Auto-generated method stub
		int result = userDao.userPwChk(userVo);
		return result;
	}
	
	
}
