package entity;

import java.io.Serializable;

public enum GameMode implements Serializable {
	EASY("チンパンジー", " quiz_easy_view ", " journal_view ", 4), 
	NORMAL("人間", " quiz_normal_view ", " journal_view ", 4), 
	HARD("オランウータン", " quiz_hard_view ", " journal_view ", 4),
	CHALLENGE("キメラ", " challenge ", " journal_view ", 4),
	TUTORIAL("テスト", " quiz_test_view ", " journal_view ", 4), ;

	private String animal;
	private String quizTable;
	private String rankingTable;
	private int buttonSize;

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
