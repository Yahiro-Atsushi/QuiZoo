package businessObject;

import java.util.Map;

import database.JournalDao;
import entity.Game;

public class SetChallengeJournalLogic {

	public static void execute(String userName, Game game) {

		int correctCount = 0;

		//現在は1度でも不正解の場合にこの処理を行うため、正解数＝問題数である。
		//しかし、今後チャレンジモードが3問失敗まで続行などに仕様変更する場合に備え、
		//isCorrectsフィールドから数えることにする。

		Map<Integer, Boolean> isCorrects = game.getIsCorrects();
		for (Integer key : isCorrects.keySet()) {
			if (isCorrects.get(key)) {
				correctCount++;
			}
		}
		
		JournalDao jDao = new JournalDao();
		jDao.insertChallengeResult(userName, correctCount);
	}

}
