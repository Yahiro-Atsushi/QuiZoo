package businessObject;

import database.AccountsDAO;
import entity.User;

 // ユーザー登録に関する処理を行うクラス
public class RegisterLogic {
	
	public static User execute(String inputName, String inputPass) {
		// データベースのAccountsテーブルの処理をまとめたクラス のインスタンスを生成
		AccountsDAO aDao = new AccountsDAO();
		
		// 入力されたユーザー名を検索しuserNameに代入する
		String userName = aDao.findUserName(inputName);
		
		//すでにログインしている場合はエラーのためnullを返す
		if(userName != null) {
			return null;
		}
		
		//アカウント登録したらユーザーアカウントを返す
		// 入力されたユーザー名・パスワードをAccountsテーブルに追加する
		aDao.userInsert(inputName, inputPass);
		// 入力されたユーザー名・パスワードをUserに代入
		User user = aDao.findAccountFromInput(inputName, inputPass);
		// 追加したを返すユーザー(inputName,inputoPass)を返す
		return user;
	}

}
