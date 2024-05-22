package businessObject;

import database.AccountsDAO;
import entity.User;

public class RegisterLogic {
	
	public static User execute(String inputName, String inputPass) {
		
		AccountsDAO aDao = new AccountsDAO();
		String userName = aDao.findUserName(inputName);
		
		//すでにログインしている場合はエラーのためnullを返す
		if(userName != null) {
			return null;
		}
		
		//アカウント登録したらユーザーアカウントを返す
		aDao.userInsert(inputName, inputPass);
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}

}
