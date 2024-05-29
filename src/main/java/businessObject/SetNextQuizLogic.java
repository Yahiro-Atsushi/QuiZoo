package businessObject;

import java.util.List;

import database.QuizDao;
import entity.Game;
import entity.GameMode;
import entity.Quiz;

public class SetNextQuizLogic {

	public static Game execute(List<String> randomIdList, Game game) {
		//共通の処理
		GameMode mode = game.getMode();
		int nextSection = game.getQuizCount() + 1; //問題数カウント
		String randomId = randomIdList.get(0); //すでにemptyは弾いている。
		System.out.print("     次の問題:" + randomId);
		QuizDao qDao = new QuizDao();
		Quiz nextQuiz = qDao.selectQuizById(mode, randomId);
		System.out.println(" " + nextQuiz);
		//カウントを進める。
		game.setQuizCount(nextSection);

		//ゲームインスタンスに格納
		game.getQuizzes().put(nextSection, nextQuiz);
		//後の処理で正解判定を格納するが、時間切れ処理の兼ね合いもありここでfalseとおく。
		game.getIsCorrects().put(nextSection, false);

		return game;
	}

}
