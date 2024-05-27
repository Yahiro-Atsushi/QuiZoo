package businessObject;

import java.util.HashMap;
import java.util.Map;

import entity.Game;

// 解答結果に関する処理をするクラス
public class ResultLogic {
	
	public static Map<Integer, String>  execute(Game game) {
		//問題数を取得
		int quizCount = game.getQuizzes().size();
				
		// Mapに正解・不正解を格納する
		Map<Boolean, String> correct = new HashMap<>();
		correct.put(true, "正解");
		correct.put(false, "不正解");
		
		// 解答結果を判定する
		Map<Integer, String> result = new HashMap<>();
		for (int i = 1; i <= quizCount; i++) {
			result.put(i, correct.get(game.getIsCorrects().get(i)));
		}
		return result;
	}
}
