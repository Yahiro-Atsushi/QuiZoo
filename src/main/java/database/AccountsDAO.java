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
		
		try(PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, inputName);
			ps.setString(2, inputPass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				user = new User(name, pass);
				
			}
		} catch (SQLException e) {
			System.out.println("SELECT文実行エラー");
			e.printStackTrace();
		}
		return user;	
	}
	
	public User userInsert(String inputName, String inputPass) {
		User user = null;
		
		String query = "INSERT INTO" +
					"account(name, pass) " +
					"VALUES (?, ?); ";
		try(PreparedStatement ps = con.prepareStatement(query);) {
			
			ps.setString(1, inputName);
			ps.setString(2, inputPass);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		return user;
		
		
	}
}
