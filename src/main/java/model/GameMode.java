package model;

public enum GameMode {
	EASY("チンパンジー", " quiz_easy "), 
	NORMAL("人間", " quiz_normal "), 
	HARD("オランウータン", " quiz_hard "),
	CHALLENGE("キメラ", "quiz_challenge");

	private String animal;
	private String table;

	private GameMode(String animal, String table) {
		this.animal = animal;
		this.table = table;
	}

	public String getValue() {
		return this.animal;
	}
	
	public String getTable() {
		return this.table;
	}
}
