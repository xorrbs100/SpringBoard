package com.spring.user.controller;

import java.lang.annotation.Annotation;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialRef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.vo.BoardVo;
import com.spring.user.dao.impl.UserDaoImpl;
import com.spring.user.service.UserService;
import com.spring.user.service.impl.UserServiceImpl;
import com.spring.user.vo.UserVo;
import com.sun.xml.internal.ws.developer.Serialization;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/userJoin.do", method=RequestMethod.GET)
	public String userJoin(Locale locale, Model model) throws Exception{
		
		List<String> list = userService.comPhone("phone");
		model.addAttribute("list", list);

		return "user/userJoin";
	}
	@RequestMapping(value="/user/userJoinAction.do", method=RequestMethod.POST)
	
	public String userJoinAction(Locale locale, Model model, 
			UserVo userVo, HttpServletRequest req) throws Exception{
		int resultCnt;
		req.setCharacterEncoding("UTF-8");
		int result = userService.userIdChk(userVo);
		if(result==1) {
			return "user/userJoinAction";
		}
		
		System.out.println(userVo.getUserName());
		resultCnt = userService.userInsert(userVo);
		model.addAttribute("alert",result);
		model.addAttribute("resultCnt",resultCnt);	
		model.addAttribute("alert",result);
		return "user/userLogin";
		
	}
	@ResponseBody
	@RequestMapping(value="/user/idChk.do", method = RequestMethod.POST)
	public int idChk(UserVo userVo,HttpServletRequest req) throws Exception {
		int result = userService.userIdChk(userVo);
		System.out.println(req.getAttribute("uesrId"));
		return result;
	}
	@RequestMapping(value="/user/userLogin.do", method=RequestMethod.GET)
	public String userLogin(Locale locale, Model model) throws Exception{
		
		return "user/userLogin";
	}
	@RequestMapping(value="/user/userLoginAction.do", method=RequestMethod.POST)
		
		public String userLoginAction(Locale locale, Model model,
				HttpServletRequest req,
				UserVo userVo) throws Exception{
			System.out.println("userVo");
			String userId=userVo.getUserId();
			String userName=userVo.getUserName();
			int resultId = userService.userIdChk(userVo);
			int resultPw = userService.userPwChk(userVo);
			model.addAttribute("resultId",resultId);
			model.addAttribute("resultPw",resultPw);
			model.addAttribute("userId", userId);
			HttpSession session = req.getSession();
			if(resultId==1&&resultPw==1) {
				session.setAttribute("ses", userVo.getUserId());
				session.setAttribute("name", userVo.getUserName());
			}
			return "user/userLogin";
			
		}
	@RequestMapping(value="/user/userLogout.do", method=RequestMethod.GET)
	public String userLogout(HttpSession session
			)throws Exception{
		session.invalidate();
		return "user/userLogin";
	}
	
}
