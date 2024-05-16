package model;

public class LoginErrorCheckLogic {

	public static LoginUserErrorMessage execute(User user, String userId, String pass) {
		String notUser = null;
		String userIdError = null;
		String passError = null;

		if (userId == null && pass == null)
			return null;

		if (user == null)
			notUser = "IDとパスワードが一致しませんでした。";

		if (userId == null || userId.isEmpty())
			userIdError = "名前が入力されていません。";

		if (pass == null || pass.isEmpty())
			passError = "パスワードが入力されていません。";

		return new LoginUserErrorMessage(notUser, userIdError, passError);
	}
	
}
