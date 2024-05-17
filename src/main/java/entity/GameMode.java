package entity;

import java.io.Serializable;

public enum GameMode implements Serializable {
	EASY("チンパンジー", " quiz_easy ", " journal_easy ", 4), 
	NORMAL("人間", " quiz_normal ", " journal_normal ", 4), 
	HARD("オランウータン", " quiz_hard ", " journal_hard ", 4),
	CHALLENGE("キメラ", " quiz_challenge ", " journal_challenge ", 4),
	TUTORIAL("テスト", " quiz_test ", " journal_test ", 4), ;

	private String animal;
	private String quizTable;
	private int buttonSize;
	private String rankingTable;

	private GameMode(String animal, String quizTable, String rankingTable, int buttonSize) {
		this.animal = animal;
		this.quizTable = quizTable;
		this.rankingTable = rankingTable;
		this.buttonSize = buttonSize;
	}

	public String getValue() {
		return this.animal;
	}
	
	public String getQuizTable() {
		return this.quizTable;
	}

	public int getButtonSize() {
		return this.buttonSize;
	}

	public String getRankingTable() {
		return this.rankingTable;
	}
}
