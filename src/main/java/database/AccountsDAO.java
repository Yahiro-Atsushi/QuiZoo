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
	
	public AccountsDTO findByLogin(User user) {
		AccountsDTO account = null;
		
		String sql = "SELECT name, pass " +
					"FROM accounts " +
					"WHERE " +
					"name = ? AND pass = ? ";
		
		try(PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				account = new AccountsDTO(name, pass);
				
				System.out.println(name + pass);
			}
		} catch (SQLException e) {
			System.out.println("SELECT文実行エラー");
			e.printStackTrace();
		}
		return account;	
	}
	
	public AccountsDTO  userInsert(User user) {
		AccountsDTO acount = null;
		
		String query = "INSERT INTO" +
					"account(name, pass) " +
					"VALUES (?, ?); ";
		try(PreparedStatement ps = con.prepareStatement(query);) {
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		return acount;
		
		
	}
}
