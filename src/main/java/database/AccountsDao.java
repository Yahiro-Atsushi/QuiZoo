package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class AccountsDao {
	private Connection con;
	private DatabaseConnector connector;

	// コンストラクタでデータベースに接続
	public AccountsDao() {
		connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	// データベースをクローズ
	public void dbClose() {
		connector.dbClose();
	}

	// テーブルから名前・パスワードを検索
	public User findAccountFromInput(String inputName, String inputPass) {
		User user = null;

	// SELECT文を実行
		String sql = "SELECT name, pass " +
				"FROM accounts_view " +
				"WHERE " +
				"name = ? AND pass = ? ";

		try (PreparedStatement ps = con.prepareStatement(sql);) {
		    //name・passを取得
			ps.setString(1, inputName);
			ps.setString(2, inputPass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
			// 取得した値を格納
				String name = rs.getString("name");
				String pass = rs.getString("pass");
			// name・passをUserに格納
				user = new User(name, pass);

			}
		} catch (SQLException e) {
			System.out.println("AccountsDao.findAccountFromInput（String, String）: SELECT文実行エラー");
			e.printStackTrace();
		}
	// userを返す
		return user;
	}

	// ユーザーを追加する
	public void userInsert(String inputName, String inputPass) {
		// INSERT文を実行
		String query = "INSERT INTO " +
				"accounts(name, pass) " +
				"VALUES (?, ?); ";
		
		try (PreparedStatement ps = con.prepareStatement(query);) {
			 //name・passに値を指定 
			ps.setString(1, inputName);
			ps.setString(2, inputPass);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("AccountsDao.userInsert（String, String）：INSERT文実行エラー");
			e.printStackTrace();
		}

		return;

	}

	// ユーザー名を検索する
	public String findUserName(String inputName) {
		String userName = null;
		// SELECT文を実行
		String query = ""
				+ "SELECT "
				+ " name "
				+ "FROM "
				+ " accounts_view "
				+ "WHERE "
				+ " name = ? ";

		try (PreparedStatement ps = con.prepareStatement(query);) {
			// nameに値を指定
			ps.setString(1, inputName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
			// userNameに取得した値を格納
				userName = rs.getString(ColumnNames.name.name());

			}
		} catch (SQLException e) {
			System.out.println("AccountsDao.findUserName（String）: SELECT文実行エラー");
			e.printStackTrace();
		}
		// userNameを返す
		return userName;
	}
}
