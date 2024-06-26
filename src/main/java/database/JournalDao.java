package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.GameMode;
import entity.Journal;
import entity.JournalPort;

public class JournalDao {

	private DatabaseConnector connector;
	private Connection con;

	public JournalDao() {
		this.connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	private String getColNameOfQuizId(int section) {
		String colQuizId = "q" + section + "_id";
		return colQuizId;
	}

	private String getColNameOfQuizResult(int section) {
		String colQuizResult = "q" + section + "_result";
		return colQuizResult;
	}

	public void insertGameResult(Map<String, String> journalMap) {
		// journalMap<"列名", "値">
		//Mapがnullなら処理せず戻る
		if (journalMap.isEmpty()) {
			System.out.println(""
					+ "JournalDao.insertGameResult(Map)エラー:引数がnullです。");
			return;
		}

		String sql = ""
				+ "INSERT INTO "
				+ " journal "
				+ " (name, mode, correct_count, "
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
				+ " (?, ?, ?, "
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

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			/* -------- ?に値を代入する処理 -------- */
			ps.setString(1, journalMap.get("name"));
			ps.setString(2, journalMap.get("mode"));
			ps.setInt(3, Integer.parseInt(journalMap.get("correct_count")));
			//列4～列23までの20列は問題数（=section）のみ列名が違うので、for文で処理をまとめる
			int parameterIndex = 4;
			final int START_SECTION = 1;
			final int MAX_SECTION = 10;

			for (int section = START_SECTION; section <= MAX_SECTION; section++) {
				String colQuizId = getColNameOfQuizId(section);
				String colQuizResult = getColNameOfQuizResult(section);

				ps.setString(parameterIndex, journalMap.get(colQuizId));
				parameterIndex += 1;

				ps.setString(parameterIndex, journalMap.get(colQuizResult));
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

	public void insertChallengeResult(String userName, int correctCount) {
		//gameがnullなら処理せず戻る
		if (userName == null) {
			System.out.println(""
					+ "JournalDao.insertChallengeResult(name, count)エラー:プレイヤーがnullです。");
			return;
		}

		String sql = ""
				+ "INSERT INTO "
				+ " journal_challenge "
				+ " (name, correct_count) "
				+ "VALUES "
				+ " (?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			/* -------- ?に値を代入する処理 -------- */
			ps.setString(1, userName);
			ps.setInt(2, correctCount);
			/* --------処理終了-------- */
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.insertChallengeResult(name, count):INSERT文が不正に終了しました");
		}
		return;
	}

	public Journal findJournalById(String journalId) {
		if (journalId == null || journalId.isEmpty()) {
			System.out.println("journalIdがnullです");
			return null;
		}

		Journal journal = null;

		String query = ""
				+ "SELECT "
				+ " * "
				+ "FROM "
				+ " journal_view "
				+ "WHERE "
				+ " id = ? ;";

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, Integer.parseInt(journalId));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(ColumnNames.id.name());
				String name = rs.getString(ColumnNames.name.name());
				String mode = rs.getString(ColumnNames.mode.name());
				int correctCount = rs.getInt(ColumnNames.correct_count.name());
				String playDate = rs.getString(ColumnNames.play_date.name());

				Map<Integer, String> quizIds = new LinkedHashMap<>();
				Map<Integer, String> quizResults = new LinkedHashMap<>();
				final int START_SECTION = 1;
				final int MAX_SECTION = 10;

				for (int section = START_SECTION; section <= MAX_SECTION; section++) {
					String colQuizId = getColNameOfQuizId(section);
					String colQuizResult = getColNameOfQuizResult(section);
					String quizId = rs.getString(colQuizId);
					String quizResult = rs.getString(colQuizResult);
					quizIds.put(section, quizId);
					quizResults.put(section, quizResult);
				}

				journal = new Journal(id, playDate, name, mode, correctCount,
						quizIds, quizResults);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.findJournalById:SELECT文のエラー");
		}

		return journal;
	}

	public List<JournalPort> selectJournalPortsByUserName(String userName) {
		if (userName == null || userName.isEmpty()) {
			System.out.println(" [JournalDao] userName is null.");
			return null;
		}

		List<JournalPort> list = new ArrayList<>();

		String query = ""
				+ "SELECT "
				+ " id, "
				+ " name, "
				+ " mode, "
				+ " correct_count, "
				+ " play_date "
				+ "FROM "
				+ " journal_view "
				+ "WHERE "
				+ " name = ? "
				+ "ORDER BY "
				+ " id DESC;";

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String journalId = rs.getString(ColumnNames.id.name());
				String name = rs.getString(ColumnNames.name.name());
				String mode = rs.getString(ColumnNames.mode.name());
				int correctCount = rs.getInt(ColumnNames.correct_count.name());
				String playDate = rs.getString(ColumnNames.play_date.name());

				JournalPort jp = new JournalPort(journalId, playDate, name, mode, correctCount);
				list.add(jp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.selectJournalPortByUserName:SELECT文のエラー");
		}

		return list;
	}

	public List<JournalPort> selectRankingByGameMode(GameMode mode) {
		if (mode == null) {
			System.out.println(" [JournalDao] mode is null.");
			return null;
		}

		List<JournalPort> list = new ArrayList<>();

		String query = ""
				+ "SELECT "
				+ " rank, "
				+ " name, "
				+ " mode, "
				+ " correct_count, "
				+ " play_date, "
				+ " id "
				+ "FROM "
				+ " ranking "
				+ "WHERE "
				+ " mode = ? "
				+ "LIMIT 10 ;";

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, mode.name());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String journalId = rs.getString(ColumnNames.id.name());
				String name = rs.getString(ColumnNames.name.name());
				String gameMode = rs.getString(ColumnNames.mode.name());
				int correctCount = rs.getInt(ColumnNames.correct_count.name());
				String playDate = rs.getString(ColumnNames.play_date.name());

				JournalPort jp = new JournalPort(journalId, playDate, name, gameMode, correctCount);
				list.add(jp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.selectJournalPortByUserName:SELECT文のエラー");
		}

		return list;
	}

	public List<JournalPort> selectChallengeRanking() {
		List<JournalPort> list = new ArrayList<>();

		String query = ""
				+ "SELECT "
				+ " rank, "
				+ " name, "
				+ " correct_count, "
				+ " play_date, "
				+ " id "
				+ "FROM "
				+ " ranking_challenge "
				+ "LIMIT 10 ;";

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String journalId = rs.getString(ColumnNames.id.name());
				String name = rs.getString(ColumnNames.name.name());
				String gameMode = GameMode.CHALLENGE.name();
				int correctCount = rs.getInt(ColumnNames.correct_count.name());
				String playDate = rs.getString(ColumnNames.play_date.name());

				JournalPort jp = new JournalPort(journalId, playDate, name, gameMode, correctCount);
				list.add(jp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JournalDao.selectChallengeRanking:SELECT文のエラー");
		}

		return list;
	}

}
