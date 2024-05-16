package businessObject;

import java.util.HashMap;
import java.util.Map;

import entity.Game;

public class ResultLogic {
	public static Map<Integer, String>  execute(Game game) {
		Map<Boolean, String> correct = new HashMap<>();
		correct.put(true, "正解");
		correct.put(false, "不正解");
		Map<Integer, String> result = new HashMap<>();
		for (int i = 1; i < 11; i++) {
			result.put(i, correct.get(game.getIsCorrects().get(i)));
		}
		return result;
	}
}
