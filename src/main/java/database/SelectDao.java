package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.GameMode;
import model.Quiz;

public class SelectDao {
	private DatabaseConnector connector;
	private Connection con;
	
	public SelectDao() {
		this.connector = DatabaseConnector.getInstance();
		this.con = connector.getConnection();
	}
	
	public Quiz selectQuizById(GameMode mode, String randomId) {
		
		Quiz quiz = null;

		String sql = ""
				+ "SELECT "
				+ " * "
				+ "FROM " + mode.getTable() + " "
				+ "WHERE "
				+ " id = " + randomId + " ;";

		try (PreparedStatement ps = this.con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(ColumnNames.id.name());
				String qMsg = rs.getString(ColumnNames.question.name());
				String answer = rs.getString(ColumnNames.answer.name());
				Map<Integer, String> buttons = new TreeMap<>();
				Map<Integer, String> buttonTexts = new TreeMap<>();
				for (int i = 1; i < mode.getButtonSize(); i++) {
					//button1, button2, button3, button4
					String button = "button" + i;
					buttons.put(i, rs.getString(button));

					//button_text1, button_text2...
					String button_text = "button_text" + i;
					buttonTexts.put(i, rs.getString(button_text));
				}

				quiz = new Quiz(id, qMsg, answer, buttons, buttonTexts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("selectAllQuiz() エラー ： sql文が正しく実行されませんでした。");
		}

		return quiz;
	}

	public List<Quiz> selectAllQuiz(GameMode mode) {

		List<Quiz> allQuiz = new ArrayList<>();

		String sql = ""
				+ "SELECT "
				+ " * "
				+ "FROM " + mode.getTable();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
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
				+ "FROM " + mode.getTable();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
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
}
