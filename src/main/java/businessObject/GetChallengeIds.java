package businessObject;

import java.util.List;

import database.QuizDao;
import entity.GameMode;

public class GetChallengeIds {

	public static List<String> execute() {
		GameMode mode = GameMode.CHALLENGE;

		QuizDao qDao = new QuizDao();

		return qDao.selectAllChallengeQuizIds(mode);
	}

}
