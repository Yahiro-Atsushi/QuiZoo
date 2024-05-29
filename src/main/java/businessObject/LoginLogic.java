package businessObject;

import database.AccountsDao;
import entity.User;
 // ログインに関する処理をするクラス
public class LoginLogic {
	
	public static User execute(String inputName, String inputPass) {
		
		//ここでは未入力かどうかだけ判定し、入力されていればデータベースと照合する。
		if(!DataCheck.isInput(inputName)) {
			return null;
		}
		
		if(!DataCheck.isInput(inputPass)) {
			return null;
		}
		
		// データベースのAccountsテーブルの処理をまとめたクラス のインスタンスを生成
		AccountsDao aDao = new AccountsDao();
		
		// 名前・パスワードを検索しUserに代入
		User user = aDao.findAccountFromInput(inputName, inputPass);
		
		return user;
	}
	
}
