package model.test;

import model.User;
import model.logic.LoginLogic;

public class LoginDAOTest {

	public static void main(String[] args) {
		testExecuteOK(); // ログイン成功のテスト
		testExecuteNG(); // ログイン失敗のテスト
	}

	public static void testExecuteOK() {
		User use = new User("湊 雄輔" , "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(use);
		if (result) {
			System.out.println("testExecuteOK：成功しました");
		} else {
			System.out.println("testExecuteOK：失敗しました");
		}
	}

	public static void testExecuteNG() {
		User user = new User("湊 雄輔" , "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(user);
		if (!result) {
			System.out.println("testExecuteNG：成功しました");
		} else {
			System.out.println("testExecuteNG：失敗しました");
		}	
	}
	public static void testUserInsertOK() {
		
	}

}
