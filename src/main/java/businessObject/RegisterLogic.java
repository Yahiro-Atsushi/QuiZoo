package businessObject;

import database.AccountsDao;
import entity.User;

public class RegisterLogic {
	
	public static User execute(String inputName, String inputPass) {
		
		AccountsDao aDao = new AccountsDao();
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
