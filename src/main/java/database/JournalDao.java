package database;

import java.sql.Connection;
import java.util.Map;

public class JournalDao {

	private DatabaseConnector connector;
	private Connection con;

	public JournalDao() {
		this.connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	public void insertGameResult(Map<String, String> journalMap) {
	}

	
}
