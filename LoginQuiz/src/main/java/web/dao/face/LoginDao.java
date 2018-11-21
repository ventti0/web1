package web.dao.face;

import web.dto.Login;

public interface LoginDao {
	public int selectCntLogin(Login login);
	public void insertUser(Login login);
	public Login selectLoginById(Login login);
}
