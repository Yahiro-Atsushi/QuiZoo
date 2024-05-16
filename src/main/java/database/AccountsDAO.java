package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountsDAO {
	private Connection con;
	private DatabaseConnector connector;

	// コンストラクタでデータベースに接続
	public AccountsDAO() {
		connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	// データベースをクローズ
	public void dbClose() {
		connector.dbClose();
	}

	public User findAccountFromInput(String inputName, String inputPass) {
		User user = null;

		String sql = "SELECT name, pass " +
				"FROM accounts " +
				"WHERE " +
				"name = ? AND pass = ? ";

		try (PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, inputName);
			ps.setString(2, inputPass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				user = new User(name, pass);

			}
		} catch (SQLException e) {
			System.out.println("AccountsDao.findAccountFromInput（String, String）: SELECT文実行エラー");
			e.printStackTrace();
		}
		return user;
	}

	public void userInsert(String inputName, String inputPass) {

		String query = "INSERT INTO " +
				"accounts(name, pass) " +
				"VALUES (?, ?); ";
		try (PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, inputName);
			ps.setString(2, inputPass);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("AccountsDao.userInsert（String, String）：INSERT文実行エラー");
			e.printStackTrace();
		}

		return;

	}

	public String findUserName(String inputName) {
		String userName = null;

		String query = ""
				+ "SELECT "
				+ " name "
				+ "FROM "
				+ " accounts "
				+ "WHERE "
				+ " name = ? ";

		try (PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, inputName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userName = rs.getString(ColumnNames.name.name());

			}
		} catch (SQLException e) {
			System.out.println("AccountsDao.findUserName（String）: SELECT文実行エラー");
			e.printStackTrace();
		}
		return userName;
	}
}
