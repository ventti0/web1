package web.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dao.face.LoginDao;
import web.dto.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public void loginChk(Login login, HttpServletRequest req) {
		
		int loginChk = loginDao.selectCntLogin(login);

		if (loginChk == 1) {
			req.getSession().setAttribute("login", true);
			req.getSession().setAttribute("id", login.getId());
		} else {
			req.getSession().setAttribute("login", false);
		}
		
		System.out.println("");
	}

	@Override
	public void logout(HttpServletRequest req) {
		// TODO Auto-generated method stub
		req.getSession().invalidate();
	}

	@Override
	public void mypage(Model model, HttpServletRequest req) {
		
		Login login = new Login();
		login.setId(req.getSession().getAttribute("id").toString());
		
		login = loginDao.selectLoginById(login);
		
		System.out.println(login.toString());
		
		System.out.println("mypage");
		model.addAttribute("login", login);
	}

}
