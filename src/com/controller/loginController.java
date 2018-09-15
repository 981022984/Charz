package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


import com.model.Student;
import com.service.loginService;
import com.service.loginServiceImpl;

/**
 * @author zuo
 * @time 2018��6��26��19:51:31
 * @version 1.0
 * ��¼��һϵ�е������Controller
 */
@Controller
public class loginController {
	
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;  								 //����ע�룿(����)
	
	private static final Log logger = LogFactory.getLog(loginController.class);
	
	
	//���ʻ�����ѡ��
	@RequestMapping(value="/language")       //��������
	public String setLanguage(HttpServletRequest request,Model model) {
		String request_locale = request.getParameter("request_locale");
		System.out.println("language--"+request_locale);
		Locale locale1 = new Locale("zh", "CN");
		Locale locale2 = new Locale("en", "US");
		if(request_locale.equals("zh_CN")){  
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);   
        }  
        else if(request_locale.equals("en_US")){     
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale2);  
        }
        else{  
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);  
        } 
		model.addAttribute("user_S",new Student());
		return "login";
	}
	
	//Ϊ��ʼ������׼��
	@RequestMapping(value = "/firstLogin") 								//��¼����
	public String login(Model model) {
		logger.info("login"); 											//��־��ӡ��
		model.addAttribute("user_S",new Student());
		return "/login";
	}
	
	@RequestMapping(value = "/firstLogin_V")          					   //��¼��֤
	public String login_V(@ModelAttribute("user_S") Student student,
			HttpSession session,Model model) { //��ȡ�ѵ�¼�û������������model�У���ֵΪuser_S
		logger.info("login_V"); 									   //��־��ӡ��
		if(loginservice.login_SV(student.getId(), student.getPassword())) {     			//�ж�������˺������Ƿ�ƥ��
			Student stu = loginservice.getStudent(student.getId());    //��ȡ��¼�ɹ���ѧ������
			session.setAttribute(stu.getId(), stu);                    //�����¼�ɹ���ѧ������
			model.addAttribute("userID",stu.getId());                  //����¼�ɹ���ѧ����ID����ǰ�ˣ�����ȡ����ȡ��ͨ��ID��õ�¼�ɹ��Ķ���
			model.addAttribute("user_S",stu);
			return "redirect:loginSuccese";   						   //ת��¼�ɹ�����
		}
		else {
			session.setAttribute(student.getId(), student);            //����¼ʧ�ܵ��û�����
			student.setPassword("");                                   //����������
			model.addAttribute("userID",student.getId());        	   //��ʧ�ܵ�ID����ǰ��
			return "redirect:loginFail";           					   //ת��¼ʧ�ܽ���
		}	
	}
	
	@RequestMapping(value = "/loginSuccese")       //��¼�ɹ�
	public String login_seccse(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) { //@ModelAttribute��ȡҳ����userID
		logger.info("login_succese"); //��־��ӡ��
		Student stu = (Student)session.getAttribute(userID);     //ͨ��userID��õ�¼�ɹ���ѧ������
		model.addAttribute("user_S",stu);                        //����¼�ɹ���ѧ������ǰ��
		return "login_succese";
	}
	
	@RequestMapping(value = "/loginFail")         //��¼ʧ��
	public String login_fail(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) {
		logger.info("login_fail"); //��־��ӡ��
		Student stu = (Student)session.getAttribute(userID);
		model.addAttribute("user_S",stu);
		return "login_fail";
	}
	
	@RequestMapping(value = "/show_information")      //�鿴��Ϣ
	public String show_information(@ModelAttribute("userID")String userID,
			Model model) {//�����ӷ�ʽ��ͨ��URLռ��λ��ȡ��¼�û���ID���Ӷ���ȡ��¼���û�
		logger.info("show_information"); 				   //��־��ӡ��
		Student student = loginservice.getStudent(userID);
		model.addAttribute("user_S",student);                       		//����¼�ɹ���ѧ������ǰ��
		model.addAttribute("userID",userID);
		return "myInformation";
	}
	
	@RequestMapping(value = "/backLoginSuccese/{id}")   //���ص�¼�ɹ�����
	public ModelAndView backLoginSuccese(@PathVariable("id")String userID,
			HttpSession session,Model model,HttpServletRequest request) {
		Student stu = (Student)session.getAttribute(userID);     //ͨ��userID��õ�¼�ɹ���ѧ������
		model.addAttribute("user_S",stu);                        //����¼�ɹ���ѧ������ǰ��
		model.addAttribute("userID",userID);
		return new ModelAndView("redirect:/loginSuccese");
	}
	
	
	@RequestMapping(value = "/modify_password")     //�޸�����
	public String modifyPassword(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) {//�����ӷ�ʽ��ͨ��URLռ��λ��ȡ��¼�û���ID���Ӷ���ȡ��¼���û�
		logger.info("modify_password"); 				//��־��ӡ��
		Student student = loginservice.getStudent(userID);
		model.addAttribute("user",student); 			//����¼�ɹ���ѧ������ǰ��
		model.addAttribute("userID",userID);
		return "modifyPassword";                     	//�޸��������
	}
	
	@RequestMapping(value = "/confirm")         //�޸�����
	public void completeModify(Model model,HttpServletRequest request,
			HttpSession session,HttpServletResponse response) {
		logger.info("confirm"); //��־��ӡ��
		String userID = request.getParameter("userID");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String news = loginservice.modifyPassword(userID, oldPassword, newPassword1, newPassword2);
		response.setContentType("text/html;charset=UTF-8");
		if(news.equals("�޸�����ɹ���")){   //�޸ĳɹ������ص�¼�ɹ�����
			try { 
				PrintWriter out = response.getWriter();
				out.print("<html><body><script type='text/javascript'>"
						+ "alert('"+news+"');"
						+ "window.history.back();"
						+ "window.history.back();"
						+ "</script></body></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {   //�޸����벻�ɹ�����ʾ������Ϣ�������޸Ľ���
			try {
				PrintWriter out = response.getWriter();
				out.print("<html><body><script type='text/javascript'>"
						+ "alert('"+news+"');"
						+ "window.history.back();"
						+ "</script></body></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Student stu = loginservice.getStudent(userID);    //��ȡ�޸��������û�
		session.setAttribute(userID, stu);
		model.addAttribute("userID",userID);
	}
	
	@RequestMapping(value = "/exit")
	public String exit(@ModelAttribute("userID")String userID,
			Model model,HttpSession session){
		logger.info("exit"); //��־��ӡ��
		System.out.println("exit-"+userID);
		session.setAttribute(userID,"");
		return "redirect:firstLogin";
	}
}












