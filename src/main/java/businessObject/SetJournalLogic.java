package businessObject;

import java.util.LinkedHashMap;
import java.util.Map;

import database.ColumnNames;
import database.JournalDao;
import entity.Game;
import entity.Quiz;

public class SetJournalLogic {

	public static void execute(String userName, Game game, Map<Integer, String> resultMap) {
		//まずデータチェック
		final int QUIZ_SIZE = game.getQuizzes().size(); 
		final int QUIZ_VALUE = 10; 
		
		//クイズ数は10問のはずなので、違ったら処理せず帰る。
		if(QUIZ_SIZE != QUIZ_VALUE) {
			System.out.println("SetJournalLogic.Execute（）：問題数が不正です。");
			return;
		}
		
		/* --------ここから、データベースの列名と値の紐づけ処理開始-------- */
		Map<String, String> inputMap = new LinkedHashMap<>();
		
		//nameにはプレイヤーの名前が入る
		inputMap.put(ColumnNames.name.name(), userName);
		
		//難易度表記を格納
		inputMap.put(ColumnNames.mode.name(), game.getMode().name());
		
		//正解数を初期化、ここからカウントする
		int correctCount = 0;
		
		//10問すべてマップに格納する
		for(int section : game.getQuizzes().keySet()) {
			//列名はq1_idなどになる
			String colQuizId = "q" + section + "_id";
			Quiz quiz = game.getQuizzes().get(section);
			String quizId = quiz.getId();
			inputMap.put(colQuizId, quizId);
			
			//列名はq1_resultなどになる
			String colQuizResult = "q" + section + "_result";
			String result = resultMap.get(section);
			inputMap.put(colQuizResult, result);
			
			//正解数をカウント
			boolean isCorrect = game.getIsCorrects().get(section);
			if(isCorrect) {
				correctCount += 1;
			}
		}
		//正解数を格納
		inputMap.put(ColumnNames.correct_count.name(), String.valueOf(correctCount));
		
		//データベースにアクセス
		JournalDao jDao = new JournalDao();
		jDao.insertGameResult(inputMap);
	}

}
