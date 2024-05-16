package model;

import database.AccountsDAO;

public class RegisterErrorCheckLogic {

	public static RegisterErrorMessage execute(User user, String inputName, String inputPass) {
		String userDoubleError = null;
		String nameError = null;
		String passError = null;
		
		AccountsDAO aDao = new AccountsDAO();
		user = aDao.findAccountFromInput(inputName, inputPass);
		
		if (inputName == null || inputName.isEmpty())
			nameError = "ユーザー名が入力されていません。";

		if (inputPass == null || inputPass.isEmpty())
			passError = "パスワードが入力されていません。";
		
		if(user != null) 
			userDoubleError = "ユーザーは既に登録されています。";

		return new RegisterErrorMessage(userDoubleError, nameError, passError);
		
	}

}
