package businessObject;

import entity.Game;
import entity.Quiz;
// 入力された値に対しての判定をするクラス
public class JudgeLogic {

	public static Game execute(Game game, String input) {
		
		if(input == null || input.isEmpty())
			return game;
		
		//今何問目かを取得
		int section = game.getQuizCount();
		
		//現在のクイズを取得
		Quiz quiz = game.getQuizzes().get(section);
		
		//正誤判定
		if(quiz.getAnswer().equals(input)) {
			game.getIsCorrects().put(section, true);
		}

		return game;
	}
}
