package model.test;

import model.User;
import model.logic.LoginLogic;

public class LoginDAOTest {

	public static void main(String[] args) {
		testExecuteOK(); // ログイン成功のテスト
		testExecuteNG(); // ログイン失敗のテスト
	}

	public static void testExecuteOK() {
		String name = "湊 雄輔";
		String pass = "1234";
		User result = LoginLogic.execute(name, pass);
		if (result != null) {
			System.out.println("testExecuteOK：成功しました");
		} else {
			System.out.println("testExecuteOK：失敗しました");
		}
	}

	public static void testExecuteNG() {
		String name = "湊 雄輔";
		String pass = "12345";
		User result = LoginLogic.execute(name, pass);
		if (result == null) {
			System.out.println("testExecuteNG：成功しました");
		} else {
			System.out.println("testExecuteNG：失敗しました");
		}	
	}

}
