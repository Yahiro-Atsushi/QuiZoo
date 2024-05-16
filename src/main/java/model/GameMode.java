package model;

public enum GameMode {
	EASY("チンパンジー", " quiz_easy ", 4), 
	NORMAL("人間", " quiz_normal ", 4), 
	HARD("オランウータン", " quiz_hard ", 4),
	CHALLENGE("キメラ", " quiz_challenge ", 4),
	TUTORIAL("テスト", " quiz_test ", 4);

	private String animal;
	private String table;
	private int buttonSize;

	private GameMode(String animal, String table, int buttonSize) {
		this.animal = animal;
		this.table = table;
		this.buttonSize = buttonSize;
	}

	public String getValue() {
		return this.animal;
	}
	
	public String getTable() {
		return this.table;
	}

	public int getButtonSize() {
		return this.buttonSize;
	}
}
