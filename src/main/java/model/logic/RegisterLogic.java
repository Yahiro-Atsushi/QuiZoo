package model.logic;

import database.AccountsDAO;
import model.User;

public class RegisterLogic {
	
	public static User execute(String inputName, String inputPass) {
		
		AccountsDAO aDao = new AccountsDAO();
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		//すでにログインしている場合はエラーのためnullを返す
		if(user != null) {
			return null;
		}
		
		//アカウント登録したらユーザーアカウントを返す
		aDao.userInsert(inputName, inputPass);
		user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}

}
