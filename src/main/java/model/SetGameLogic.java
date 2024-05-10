package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import database.ColumnNames;
import database.DatabaseConnector;

public class SetGameLogic {

	public static Game execute(GameMode mode) {
		//ゲームインスタンス生成
		Game game = new Game(mode);
		
		//クイズテーブルの全レコードを取得
		List<Quiz> allQuiz = selectAllQuiz(mode);
		
		//全レコードからランダムに一つクイズインスタンスを取得
		Quiz quiz = null;
		
		//取得したらリストからは消去
		
		//ゲームインスタンスに格納
		
		
		//10回終わったらOK
		return game;
	}

	private static List<Quiz> selectAllQuiz(GameMode mode) {
		
		Connection con = DatabaseConnector.getInstance().getConnection();
		
		List<Quiz> allQuiz = new ArrayList<>();
		
		String sql = ""
				+ "SELECT "
				+ " * "
				+ "FROM " + mode.getTable();
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(ColumnNames.id.name());
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
		
		return null;
	}
}
