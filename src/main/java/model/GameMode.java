package model;

public enum GameMode {
	EASY("チンパンジー"), 
	NORMAL("人間"), 
	HARD("オランウータン");

	private String mode;

	private GameMode(String mode) {
		this.mode = mode;
	}

	public String getValue() {
		return this.mode;
	}
}
