package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class JournalDao {

	private DatabaseConnector connector;
	private Connection con;

	public JournalDao() {
		this.connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}
	
	public void insertGameResult(Map<String, String> journalMap) {
		// journalMap<"列名", "値">
		//Mapがnullなら処理せず戻る
		if(journalMap.isEmpty()) {
			System.out.println(""
					+ "JournalDao.insertGameResult(Map)エラー:引数がnullです。");
			return;
		}
		
		String sql = ""
				+ "INSERT INTO "
				+ " journal "
				+ " (name, correct_count, "
				+ "  q1_id, q1_result, "
				+ "  q2_id, q2_result, "
				+ "  q3_id, q3_result, "
				+ "  q4_id, q4_result, "
				+ "  q5_id, q5_result, "
				+ "  q6_id, q6_result, "
				+ "  q7_id, q7_result, "
				+ "  q8_id, q8_result, "
				+ "  q9_id, q9_result, "
				+ "  q10_id, q10_result) "
				+ "VALUES "
				+ " (?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?, "
				+ " ?, ?)";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			
			/* -------- ?に値を代入する処理 -------- */
			ps.setString(1, journalMap.get("name"));
			ps.setString(2, journalMap.get("correct_count"));
			//列3～列22までの20列は問題数（=section）のみ列名が違うので、for文で処理をまとめる
			int parameterIndex = 3;
			final int START_QUIZ_SECTION = 1;
			final int MAX_QUIZ_SECTION = 10;
			
			for(int section = START_QUIZ_SECTION; section <= MAX_QUIZ_SECTION; section++) {
				String colQuizId = "q" + section + "_id";
				String colQuizResult = "q" + section + "_result";
				
				ps.setString(parameterIndex, journalMap.get(colQuizId));
				parameterIndex += 1;
				
				ps.setString(section, journalMap.get(colQuizResult));
				parameterIndex += 1;
			}
			/* --------処理終了-------- */
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.insertGameResult(Map):INSERT文が不正に終了しました");
		}
		
		return;
	}

	
}
