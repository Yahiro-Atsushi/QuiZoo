package businessObject;


import entity.GameMode;

public class SetGameModeLogic {

	public static GameMode execute(String gameMode) {
		
		for(GameMode value : GameMode.values()) {
			if(value.getValue().equals(gameMode)) {
				return value;
			}
		}
		return GameMode.TEST;
	}

}
