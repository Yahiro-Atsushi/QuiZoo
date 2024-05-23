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
		int section = game.getQuizCount(); //問題数カウント
		String randomId = randomIdList.get(0); //すでにemptyは弾いている。
		QuizDao qDao = new QuizDao();
		Quiz nextQuiz = qDao.selectQuizById(mode, randomId);
		
		//2問目以降の処理の場合はカウントを進める。
		if(section > 1) {
			game.setQuizCount(section + 1);
		}
		
		//ゲームインスタンスに格納
		game.getQuizzes().put(section, nextQuiz);
		//後の処理で正解判定を格納するが、時間切れ処理の兼ね合いもありここでfalseとおく。
		game.getIsCorrects().put(section, false);
		
		//同じクイズを呼び出さないようにする処理
		randomIdList.remove(randomId);
		
		return game;
	}

}
