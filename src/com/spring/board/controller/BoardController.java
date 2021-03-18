package com.spring.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.HomeController;
import com.spring.board.dao.impl.BoardDaoImpl;
import com.spring.board.service.boardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import com.spring.common.CommonUtil;

@Controller
public class BoardController {
	
	@Autowired 
	boardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model,PageVo pageVo
			,HttpServletRequest request
			
			)
			throws Exception{
		/*
		 * BoardDaoImpl bd = new BoardDaoImpl(); bd.d();
		 */
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		List<String> comType = boardService.comType(); 
		List<String> comName= boardService.comName();
		 
		int page = 1;
		int totalCnt = 0;
		String [] chk = request.getParameterValues("chk");
		
		pageVo.setChk(chk);
		BoardVo boardVo=new BoardVo();
		boardVo.setChk(chk);
		if(pageVo.getPageNo() == 0){
			pageVo.setPageNo(page);;
		}
		
		boardList = boardService.SelectBoardList(pageVo);
		totalCnt = boardService.selectBoardCnt();
		model.addAttribute("comType", comType);
		model.addAttribute("comName", comName);
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageNo", page);
		
		return "board/boardList";
	}
	//�ۻ�
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardView.do", method = RequestMethod.GET)
	public String boardView(Locale locale, Model model
			,@PathVariable("boardType")String boardType
			,@PathVariable("boardNum")int boardNum) throws Exception{
		
		BoardVo boardVo = new BoardVo();
		boardVo = boardService.selectBoard(boardType,boardNum);
		
		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo);
		System.out.println(boardVo.getModifier());
		return "board/boardView";
	}
	
	@RequestMapping(value = "/board/boardWrite.do", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model, HttpServletRequest req) throws Exception{
		HttpSession session=req.getSession();
		if(session==null) {
			return "user/userLogin";
		}
		List<String> comType = boardService.comType(); 
		List<String> comName= boardService.comName();
		model.addAttribute("comType", comType);
		model.addAttribute("comName", comName);
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/board/boardWriteAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardWriteAction(Locale locale,BoardVo boardVo
			,HttpServletRequest req) throws Exception{
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		System.out.println(boardVo);
		
		int resultCnt = boardService.boardInsert(boardVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}

	  //�Խñ� ����ȭ��
	  @RequestMapping(value = "/board/{boardNum}/{boardType}/boardUpdate.do",
	  method = RequestMethod.GET)
	  
	  public String boardUpdate(Model model, 
	  @PathVariable("boardNum") int boardNum,
	  @PathVariable("boardType") String boardType) throws Exception {
		  BoardVo vo = new BoardVo();
		  vo=boardService.selectBoard(boardType, boardNum);
		  model.addAttribute("boardUpdate", vo); 
		  model.addAttribute("boardType", boardType);
		/* vo.setBoardNum(boardNum); */
		  model.addAttribute("boardNum", boardNum);
		  
		  
		  return "board/boardUpdate";
	  }
	 
	//�Խñ� ����
		@RequestMapping(value = "/board/boardUpdateAction.do", method = RequestMethod.POST)
		@ResponseBody
		public String boardUpdateAction(Locale locale,BoardVo boardVo) throws Exception{
			
			HashMap<String, String> result = new HashMap<String, String>();
			CommonUtil commonUtil = new CommonUtil();
			System.out.println(boardVo);
			
			int resultCnt = boardService.boardUpdate(boardVo);
			
			result.put("success", (resultCnt > 0)?"Y":"N");
			String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
			
			System.out.println("callbackMsg::"+callbackMsg);
			
			return callbackMsg;
		}
	
	//�Խñ� ����
	@RequestMapping(value = "/board/{boardNum}/{boardType}/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete( 
			@PathVariable("boardNum") int boardNum,
			@PathVariable("boardType") String boardType,
			Model model
			) throws Exception {
		 	int delCnt = boardService.boardDelete(boardNum,boardType);
		 	model.addAttribute("delCnt", delCnt); 
			return "board/boardDelete";
		}
}



