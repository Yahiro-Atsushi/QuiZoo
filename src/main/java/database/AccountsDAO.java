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
		
		String sql = "SELECT * " +
					"FROM accounts " +
					"WHERE " +
					"name = ? " +
					"pass = ? ";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				account = new AccountsDTO(id, name, pass, pass);
			}
		} catch (SQLException e) {
			System.out.println("SELECT文実行エラー");
			e.printStackTrace();
			return null;
		}
		return account;		
		
	}
}
