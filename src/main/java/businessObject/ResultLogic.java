package businessObject;

import java.util.HashMap;
import java.util.Map;

import entity.Game;

// 解答結果に関する処理をするクラス
public class ResultLogic {
	
	public static Map<Integer, String>  execute(Game game) {
		
		// Mapに正解・不正解を格納する
		Map<Boolean, String> correct = new HashMap<>();
		correct.put(true, "正解");
		correct.put(false, "不正解");
		
		// 
		Map<Integer, String> result = new HashMap<>();
		// for文で10回ループ(問題数)
		for (int i = 1; i < 11; i++) {
			result.put(i, correct.get(game.getIsCorrects().get(i)));
		}
		return result;
	}
}
