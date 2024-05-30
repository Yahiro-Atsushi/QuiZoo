package businessObject;

import database.AccountsDao;
import entity.RegisterErrorMessage;

// ユーザー登録時のエラーメッセージを保持するクラス
public class RegisterErrorCheckLogic {

	public static RegisterErrorMessage execute(String inputName, String inputPass) {
		String userDoubleError = null;
		String nameError = null;
		String passError = null;

		AccountsDao aDao = new AccountsDao();
		String userName = aDao.findUserName(inputName);

		if (inputName == null || inputName.isEmpty())
			nameError = "ユーザー名が入力されていません。";

		if (!DataCheck.isValidName(inputName)) {
			passError = "ユーザー名は12文字までの文字列にしてください。";
		}

		if (inputPass == null || inputPass.isEmpty())
			passError = "パスワードが入力されていません。";

		if (!DataCheck.isValidPass(inputPass)) {
			passError = "4文字以上12文字以下の英数字を入力してください。";
		}

		if (userName != null)
			userDoubleError = "ユーザー名が重複しています。";

		return new RegisterErrorMessage(userDoubleError, nameError, passError);

	}

}
