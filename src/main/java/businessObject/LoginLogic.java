package businessObject;

import database.AccountsDao;
import entity.User;

public class LoginLogic {
	
	public static User execute(String inputName, String inputPass) {
		AccountsDao aDao = new AccountsDao();
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}
	
}
