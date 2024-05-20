package businessObject;

import database.AccountsDAO;
import entity.User;
 // ログインに関する処理をするクラス
public class LoginLogic {
	
	public static User execute(String inputName, String inputPass) {
		// データベースのAccountsテーブルの処理をまとめたクラス のインスタンスを生成
		AccountsDAO aDao = new AccountsDAO();
		
		// 名前・パスワードを検索しUserに代入
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}
	
}
