package businessObject;


import entity.GameMode;

public class SetGameModeLogic {

	public static GameMode execute(String gameMode) {
		if(gameMode == null || gameMode.isEmpty()) {
			return null;
		}
		
		for(GameMode value : GameMode.values()) {
			if(value.name().equals(gameMode)) {
				return value;
			}
		}
		return null;
	}

}
