package model.logic;

import database.AccountsDAO;
import database.AccountsDTO;
import model.User;

public class LoginLogic {
	public boolean execute(User user) {
		AccountsDAO accountDAO = new AccountsDAO();
		AccountsDTO account = accountDAO.findByLogin(user);
		return account != null;
	}
	
	public boolean executeInsert(User user) {
		return false;
		
	}

}
