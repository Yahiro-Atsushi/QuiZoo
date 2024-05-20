package businessObject;

import database.AccountsDAO;
import entity.RegisterErrorMessage;

// ユーザー登録時のエラーメッセージを保持するクラス
public class RegisterErrorCheckLogic {

	public static RegisterErrorMessage execute(String inputName, String inputPass) {
		String userDoubleError = null;
		String nameError = null;
		String passError = null;
		
		AccountsDAO aDao = new AccountsDAO();
		String userName = aDao.findUserName(inputName);
		
		if (inputName == null || inputName.isEmpty())
			nameError = "ユーザー名が入力されていません。";
		
		if (inputPass == null || inputPass.isEmpty())
			passError = "パスワードが入力されていません。";
		
		if(userName != null) 
			userDoubleError = "ユーザー名が重複しています。";

		return new RegisterErrorMessage(userDoubleError, nameError, passError);
		
	}

}
