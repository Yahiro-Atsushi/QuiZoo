package businessObject;

import java.util.List;
import java.util.Map;

import entity.Game;
import entity.Quiz;

public class RemoveQuizId {

	public static List<String> execute(Game game, List<String> randomIdList) {
		//チャレンジモードで、IDリストからすでに出題した問題のIDを削除するロジック
		Map<Integer, Quiz> quizzes = game.getQuizzes();

		//そもそも何もなければ帰る
		if (quizzes.isEmpty()) {
			return randomIdList;
		}
		
		//IDリストから次の問題を探す際、問題の重複を回避するための処理
		for (Integer key : quizzes.keySet()) {
			String id = quizzes.get(key).getId();
			if (!randomIdList.contains(id)) {
				continue;
			}
			randomIdList.remove(id);
		}

		return randomIdList;
	}

}
