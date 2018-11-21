package web.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import web.dto.Login;

public interface LoginService {
	public void loginChk(Login login, HttpServletRequest req);
	public void logout(HttpServletRequest req);
	public void mypage(Model model, HttpServletRequest req);
}
