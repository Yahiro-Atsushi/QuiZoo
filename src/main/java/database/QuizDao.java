package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.GameMode;
import entity.Quiz;

public class QuizDao {
	private DatabaseConnector connector;
	private Connection con;

	// コンストラクタでデータベースに接続
	public QuizDao() {
		this.connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}

	// IDを指定しクイズを検索する
	public Quiz selectQuizById(GameMode mode, String randomId) {
		if (mode == null || randomId == null || randomId.isEmpty()) {
			System.out.println(" [QuizDao] args is null.");
			return null;
		}

		Quiz quiz = null;
		// SELECT文を実行
		String sql = ""
				+ "SELECT "
				+ " * "
				+ "FROM ? "
				+ "WHERE "
				+ " id = ? ;";

		try (PreparedStatement ps = this.con.prepareStatement(sql)) {
			ps.setString(1, mode.getQuizTable());
			ps.setString(2, randomId);
			
			ResultSet rs = ps.executeQuery();

			final int BUTTON_START_INDEX = 1;
			final int BUTTON_MAX_INDEX = mode.getButtonSize();

			while (rs.next()) {
				// レコードを取得
				String id = rs.getString(ColumnNames.id.name());
				String qMsg = rs.getString(ColumnNames.question.name());
				String answer = rs.getString(ColumnNames.answer.name());
				Map<Integer, String> buttons = new TreeMap<>();
				Map<Integer, String> buttonTexts = new TreeMap<>();

				for (int i = BUTTON_START_INDEX; i <= BUTTON_MAX_INDEX; i++) {
					// 選択肢分ループ
					//button1, button2, button3, button4
					String button = "button" + i;
					// buttonsに格納
					buttons.put(i, rs.getString(button));

					//button_text1, button_text2...
					String button_text = "button_text" + i;
					buttonTexts.put(i, rs.getString(button_text));
				}
				// quizに取得した値を格納
				quiz = new Quiz(id, qMsg, answer, buttons, buttonTexts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("selectAllQuiz() エラー ： sql文が正しく実行されませんでした。");
		}
		// quizを返す
		return quiz;
	}

	public List<Quiz> selectAllQuiz(GameMode mode) {
		if (mode == null) {
			System.out.println(" [QuizDao] args is null.");
			return null;
		}
		
		List<Quiz> allQuiz = new ArrayList<>();

		String sql = ""
				+ "SELECT "
				+ " * "
				+ "FROM ? ;" ;

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mode.getQuizTable());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(ColumnNames.id.name());
				String qMsg = rs.getString(ColumnNames.question.name());
				String answer = rs.getString(ColumnNames.answer.name());
				Map<Integer, String> buttons = new TreeMap<>();
				Map<Integer, String> buttonTexts = new TreeMap<>();

				buttons.put(1, rs.getString(ColumnNames.button1.name()));
				buttons.put(2, rs.getString(ColumnNames.button2.name()));
				buttons.put(3, rs.getString(ColumnNames.button3.name()));
				buttons.put(4, rs.getString(ColumnNames.button4.name()));

				buttonTexts.put(1, rs.getString(ColumnNames.button_text1.name()));
				buttonTexts.put(2, rs.getString(ColumnNames.button_text2.name()));
				buttonTexts.put(3, rs.getString(ColumnNames.button_text3.name()));
				buttonTexts.put(4, rs.getString(ColumnNames.button_text4.name()));

				Quiz q = new Quiz(id, qMsg, answer, buttons, buttonTexts);
				allQuiz.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("selectAllQuiz() エラー ： sql文が正しく実行されませんでした。");
		}

		return allQuiz;
	}

	public List<String> selectAllQuizId(GameMode mode) {

		List<String> allQuizId = new ArrayList<>();

		String sql = ""
				+ "SELECT "
				+ " id "
				+ "FROM ? ;";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mode.getQuizTable());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(ColumnNames.id.name());
				allQuizId.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("selectAllQuizId() エラー ： sql文が正しく実行されませんでした。");
		}

		return allQuizId;
	}

	public List<String> selectAllChallengeQuizIds(GameMode mode) {
		if(mode == null) {
			System.out.println(" [QuizDao] args is null.");
			return null;
		}
		List<String> list = new ArrayList<>();

		String sql = ""
				+ "SELECT "
				+ " id "
				+ "FROM "
				+ " ? "
				+ "ORDER BY "
				+ " RANDOM();";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mode.getQuizTable());
			ResultSet rs = ps.executeQuery();
			System.out.print("     randomId[");
			while (rs.next()) {
				String id = rs.getString(ColumnNames.id.name());
				list.add(id);
				System.out.print(id + ", ");
			}
			System.out.println("]");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("selectAllChallengeQuizIds() エラー ： sql文が正しく実行されませんでした。");
		}

		return list;
	}
}
