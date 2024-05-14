package model;

public class JudgeLogic {

	public static Game execute(Game game, String input) {
		
		//未入力ならカウントだけして返す
		if(input == null || input.isEmpty()) {
			game.setQuizCount(game.getQuizCount() + 1);
			return game;
		}
		
<<<<<<< HEAD
		//今何問目かを取得
=======
		//今何問めかを取得
>>>>>>> 93d018eed76abe3cc38baf00a432bf1e9e1a2ae3
		int section = game.getQuizCount();
		
		//現在のクイズを取得
		Quiz quiz = game.getQuizzes().get(section);
		
		//正誤判定
		if(quiz.getAnswer().equals(input)) {
			game.getIsCorrects().put(section, true);
		}
		
<<<<<<< HEAD
		//次の問題へカウントを増加
=======
		//次の問題へ
>>>>>>> 93d018eed76abe3cc38baf00a432bf1e9e1a2ae3
		game.setQuizCount(section + 1);
		return game;
	}
}
