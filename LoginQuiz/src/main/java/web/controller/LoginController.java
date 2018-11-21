package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dao.face.LoginDao;
import web.dto.Login;
import web.service.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController { 
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired LoginDao loginDao;
	
	@Autowired LoginService loginServ;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public void main() {
		
	}
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public void join() {
		logger.info("join");
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinProc(Login login) {
		
		loginDao.insertUser(login);
		
		System.out.println("joinProc");
		return "redirect:/login/main";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginProc(Login login, HttpServletRequest req) {
		
		loginServ.loginChk(login, req);
		
		return "redirect:/login/main";
	}
	
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public void mypage(Model model, HttpServletRequest req) {
		loginServ.mypage(model, req);
		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		loginServ.logout(req);
		
		return "redirect:/login/main";
	}
	
	
}
