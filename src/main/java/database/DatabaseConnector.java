package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static DatabaseConnector instance;
	private Connection con;

	//Databaseへの接続情報
	final String DATABASE = "quizoo";
	final String USER = "postgres";
	final String PASSWORD = "root";
	final String URL = "jdbc:postgresql://localhost:5432/" + DATABASE;

	private DatabaseConnector() {
		// JDBCのドライバーのロード
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("【失敗】 JDBCのドライバーが読み込めません");
			e.printStackTrace();
		}

		try {
			this.con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("【情報】 データベースに接続しました");
		} catch (SQLException e) {
			System.out.println("【失敗】 データベースの接続に失敗しました");
			e.printStackTrace();
		}
	}

	public static synchronized DatabaseConnector getInstance() {
		if (instance == null) {
			instance = new DatabaseConnector();
		}
		return instance;
	}

	public Connection getConnection() {
		return con;
	}

	public void dbClose() {
		if (this.con != null) {
			try {
				this.con.close();
				instance = null;
				System.out.println("【情報】　データベースをクローズしました");
			} catch (SQLException e) {
				System.out.println("【失敗】　データベースをクローズできませんでした");
				e.printStackTrace();
			}
		}
	}
}
