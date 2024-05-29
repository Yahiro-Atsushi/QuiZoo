package businessObject;

public class GameErrorMsgLogic {

	public static String execute(boolean gameIsABone) {

		if (gameIsABone) {
			return "プレイ中のデータが破損しました。はじめから遊んでください。";
		}

		return null;
	}

}
