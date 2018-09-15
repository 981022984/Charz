package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.testQuestion;
import com.service.TestService;
import com.service.TestServiceImpl;
import com.service.loginServiceImpl;


/**
 * @author Administrator
 * @time 2018年6月26日20:01:24
 * @version 1.0
 * 测试功能的Controller
 */
@Controller
public class TestController {
	@Resource(name="testService")
    private TestServiceImpl testService;
	
	@RequestMapping(value="/readyTest")
	public String readyTest(HttpServletRequest request,Model model) {
		String userID = request.getParameter("userID");          //获取要考试的学生
		model.addAttribute("userID",userID);
		return "choice";
	}
	
	
	@RequestMapping(value="/testInterface")
	public String testInterface(HttpServletRequest request,Model model,HttpServletResponse response) {
		String tpNo = request.getParameter("tpNo");     //获取试卷名  
		String userID = request.getParameter("userID");
		if(testService.checkTestAgain(userID, tpNo)) {//判断是否已经测试过，若没有，则返回测试界面，若已经测试了，则返回提示界面
			ArrayList<testQuestion> tlist = testService.getQuestions(tpNo);    //获取所选试卷的所有题目
			model.addAttribute("tpNo",tpNo);
			model.addAttribute("userID",userID);
			model.addAttribute("tqQuestions",tlist);
			return "testInterface";
		}
		else {
			model.addAttribute("tpNo",tpNo);
			model.addAttribute("userID",userID);
			return "forward:dealTestAgain";
		}
	}
	
	//再次测试选项处理
	@RequestMapping(value="/dealTestAgain")
	public void cannotTestAgain(HttpServletResponse response,Model model,HttpServletRequest request) {  
		String tpNo = request.getParameter("tpNo");     //获取试卷名  
		String userID = request.getParameter("userID");
		model.addAttribute("tpNo",tpNo);
		model.addAttribute("userID",userID);
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<html><body><script type='text/javascript'>"
					+ "alert('无法再次测试！');"
					+ "window.history.back();"
					+ "</script></body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getScore")
	public String getTestScore(HttpServletRequest request,Model model) {
		int Score = 0;
		String tpNo = request.getParameter("tpNo");
		String userID = request.getParameter("userID");
		System.out.println("Sno---"+userID+"tpNo---"+tpNo);
		ArrayList<testQuestion> tlist = testService.getQuestions(tpNo);    //获取所选试卷的所有题目
		for(testQuestion tq:tlist) {
			Score = Score +Integer.parseInt(request.getParameter(tq.getTqNo()));
		}
		testService.saveTestScore(userID, tpNo, Score);
		String analysis = testService.getAnalysis(tpNo);
		model.addAttribute("analysis",analysis);
		model.addAttribute("userID",userID);
		return "testResult";
	}
}
