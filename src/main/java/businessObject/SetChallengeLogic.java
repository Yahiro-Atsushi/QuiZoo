package businessObject;

import entity.Game;
import entity.GameMode;

public class SetChallengeLogic {

	public static Game execute() {
		//チャレンジモード開始時、gameがnullだった場合に発生する処理
		GameMode mode = GameMode.CHALLENGE;
		Game game = new Game(mode);

		return game;
	}

}
