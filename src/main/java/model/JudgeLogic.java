package model;

public class JudgeLogic {

	public static Game execute(Game game, String input) {
		
		//未入力ならカウントだけして返す
		if(input == null || input.isEmpty()) {
			game.setQuizCount(game.getQuizCount() + 1);
			return game;
		}
		
		//今何問目かを取得
		int section = game.getQuizCount();
		
		//現在のクイズを取得
		Quiz quiz = game.getQuizzes().get(section);
		
		//正誤判定
		if(quiz.getAnswer().equals(input)) {
			game.getIsCorrects().put(section, true);
		}
		
		//次の問題へカウントを増加
		game.setQuizCount(section + 1);
		return game;
	}
}
