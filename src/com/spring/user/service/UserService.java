package com.spring.user.service;


import java.util.List;

import com.spring.user.vo.UserVo;

public interface UserService {

	public int userInsert(UserVo userVo) throws Exception;
	
	public int userIdChk(UserVo userVo) throws Exception;
	
	public List<String> comPhone(String comPhone) throws Exception;
	
	public int userPwChk(UserVo userVo) throws Exception;
}
