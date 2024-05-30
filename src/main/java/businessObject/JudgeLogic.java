package businessObject;

import entity.Game;
import entity.Quiz;

// 入力された値に対しての判定をするクラス
public class JudgeLogic {

	public static Game execute(Game game, String input) {
		//元から不正解が入っているので、未入力なら即時リターンでOK
		if (input == null || input.isEmpty())
			return game;

		//今何問目かを取得
		int section = game.getQuizCount();
		Quiz quiz = game.getQuizzes().get(section);

		//ボタンで選択するので正誤判定は常に文字の一致判定でよい。
		if (quiz.getAnswer().equals(input)) {
			game.getIsCorrects().put(section, true);
		}

		return game;
	}
}
