package businessObject;

import java.util.List;
import java.util.Map;

import entity.Game;
import entity.Quiz;

public class RemoveQuizId {

	public static List<String> execute(Game game, List<String> randomIdList) {
		
		Map<Integer, Quiz> quizzes = game.getQuizzes();
		
		if(quizzes.isEmpty()) {
			return randomIdList;
		}
		
		for(Integer key : quizzes.keySet()) {
			String id = quizzes.get(key).getId();
			if(!randomIdList.contains(id)) {
				continue;
			}
			randomIdList.remove(id);
		}
		
		return randomIdList;
	}

}
