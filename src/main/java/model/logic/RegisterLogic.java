package model.logic;

import database.AccountsDAO;
import model.User;

public class RegisterLogic {
	
	public static User execute(String inputName, String inputPass) {
		//エラークラスに変更
		User user = null;
		
		AccountsDAO aDao = new AccountsDAO();
		user = aDao.findAccountFromInput(inputName, inputPass);
		
		//すでにログインしている
		if(user != null) {
			return user;
		}
		
		return user;
	}

}
