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
 * @time 2018��6��26��20:01:24
 * @version 1.0
 * ���Թ��ܵ�Controller
 */
@Controller
public class TestController {
	@Resource(name="testService")
    private TestServiceImpl testService;
	
	@RequestMapping(value="/readyTest")
	public String readyTest(HttpServletRequest request,Model model) {
		String userID = request.getParameter("userID");          //��ȡҪ���Ե�ѧ��
		model.addAttribute("userID",userID);
		return "choice";
	}
	
	
	@RequestMapping(value="/testInterface")
	public String testInterface(HttpServletRequest request,Model model,HttpServletResponse response) {
		String tpNo = request.getParameter("tpNo");     //��ȡ�Ծ���  
		String userID = request.getParameter("userID");
		if(testService.checkTestAgain(userID, tpNo)) {//�ж��Ƿ��Ѿ����Թ�����û�У��򷵻ز��Խ��棬���Ѿ������ˣ��򷵻���ʾ����
			ArrayList<testQuestion> tlist = testService.getQuestions(tpNo);    //��ȡ��ѡ�Ծ��������Ŀ
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
	
	//�ٴβ���ѡ���
	@RequestMapping(value="/dealTestAgain")
	public void cannotTestAgain(HttpServletResponse response,Model model,HttpServletRequest request) {  
		String tpNo = request.getParameter("tpNo");     //��ȡ�Ծ���  
		String userID = request.getParameter("userID");
		model.addAttribute("tpNo",tpNo);
		model.addAttribute("userID",userID);
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<html><body><script type='text/javascript'>"
					+ "alert('�޷��ٴβ��ԣ�');"
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
		ArrayList<testQuestion> tlist = testService.getQuestions(tpNo);    //��ȡ��ѡ�Ծ��������Ŀ
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
