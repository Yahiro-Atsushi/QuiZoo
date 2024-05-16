package businessObject;

import database.AccountsDAO;
import entity.User;

public class LoginLogic {
	
	public static User execute(String inputName, String inputPass) {
		AccountsDAO aDao = new AccountsDAO();
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}
	
}
