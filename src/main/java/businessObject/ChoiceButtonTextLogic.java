package businessObject;

import entity.Game;
import entity.Quiz;

public class ChoiceButtonTextLogic {

	public static String execute(Game game, String input) {
//		//もしnullなら帰る
//		if(game == null || input == null || input.isEmpty()) {
//			System.err.println("ChoiceButtonTextLogic."
//					+ "execute(Game, String):渡された引数がnullです。");
//			return null;
//		}
		
		//今、何問目？を取得
		int section = game.getQuizCount();
		
		//現在のクイズインスタンスを取得
		Quiz quiz = game.getQuizzes().get(section);
		
		//入力したボタンの番号を取得
		//なければ帰る
		if(!quiz.getButtons().containsValue(input)) {
			return null;
		}
		
		//for文回して合致する回答を探す
		String buttonText = null;
		
		for(int key : quiz.getButtons().keySet()) {
			String button = quiz.getButtons().get(key);
			
			//合致するなら代入してbreak;
			if(button.equals(input)) {
				buttonText = quiz.getButtonTexts().get(key);
				break;
			}
			
		}
		
//		//ちなみにこの３行でも終わるけど読みづらいのでダメ
//		for(int key : game.getQuizzes().get(game.getQuizCount()).getButtons().keySet()) {
//			if(game.getQuizzes().get(game.getQuizCount()).getButtons().get(key).equals(input))
//				return game.getQuizzes().get(game.getQuizCount()).getButtonTexts().get(key);
//		}
		
		return buttonText;
	}
}
