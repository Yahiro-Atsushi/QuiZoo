package businessObject;

import entity.Game;
import entity.GameMode;

public class SetChallengeLogic {

	public static Game execute() {
		//宣言
		GameMode mode = GameMode.CHALLENGE;
		Game game = new Game(mode);
		
//		下記の処理をChallengeServletの呼び出す処理に移譲
//		int section = game.getQuizCount(); // 1
//		
//		//クイズテーブルの全Idを取得
//		QuizDao dao = new QuizDao();
//		List<Map<String, String>> allQuizMap = dao.selectAllChallengeQuiz(mode);
//
//		//最大の要素数までの数字をランダムに取得する
//		int randomIterator = new java.util.Random().nextInt(allQuizIds.size());
//		System.out.println("イテレータ：" + randomIterator);
//		//id取得し、ランダムなIDを引数にクイズを取得する
//		String randomId = allQuizIds.get(randomIterator);
//		System.out.println("randomID:" + randomId);
//		Quiz quiz = dao.selectQuizById(mode, randomId);
//		//取得したクイズを格納する。
//		game.getQuizzes().put(count, quiz);
//		//クイズの結果は一旦falseで置く
//		game.getIsCorrects().put(count, false);

		return game;
	}

}
