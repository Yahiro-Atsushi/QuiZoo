package businessObject;

import entity.LoginUserErrorMessage;
import entity.User;

// ログイン時のエラーメッセージを設定するクラス
public class LoginErrorCheckLogic {

	public static LoginUserErrorMessage execute(User user, String userId, String pass) {
		String notUser = null;
		String userIdError = null;
		String passError = null;

		//どちらも未入力の場合は何も表示しない
		if (userId == null && pass == null)
			return null;

		if (user == null)
			notUser = "ユーザー名とパスワードが一致しませんでした。";

		if (userId == null || userId.isEmpty())
			userIdError = "ユーザー名が入力されていません。";

		if (pass == null || pass.isEmpty())
			passError = "パスワードが入力されていません。";

		return new LoginUserErrorMessage(notUser, userIdError, passError);
	}

}
