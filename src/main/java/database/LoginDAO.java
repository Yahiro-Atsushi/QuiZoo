package database;

import java.sql.Connection;

public class LoginDAO {
	private Connection con;
	private DatabaseConnector connector;

	// コンストラクタでデータベースに接続
	LoginDAO() {
		connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	// データベースをクローズ
	public void dbClose() {
		connector.dbClose();
	}
}
