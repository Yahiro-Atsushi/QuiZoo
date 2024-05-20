package entity;


import java.io.Serializable;

// 列挙型でゲームの難易度・テーブル・回答の選択肢の数を持つ
public enum GameMode implements Serializable {
	EASY("チンパンジー", " quiz_easy ", " journal_easy ", 4), 
	NORMAL("人間", " quiz_normal ", " journal_normal ", 4), 
	HARD("オランウータン", " quiz_hard ", " journal_hard ", 4),
	CHALLENGE("キメラ", " quiz_challenge ", " journal_challenge ", 4),
	TUTORIAL("テスト", " quiz_test ", " journal_test ", 4), ;

	private String animal; // 難易度
	private String quizTable; // データベースのテーブル名
	private String rankingTable; //履歴表示の際のテーブル名
	private int buttonSize;	// 回答の選択肢の数
	// コンストラクタ
	private GameMode(String animal, String quizTable, String rankingTable, int buttonSize) {
		this.animal = animal;
		this.quizTable = quizTable;
		this.rankingTable = rankingTable;
		this.buttonSize = buttonSize;
	}
	// getValueで引数の難易度を取得
	public String getValue() {
		return this.animal;
	}
	// getTableで引数のデータベースのテーブルを取得
	public String getQuizTable() {
		return this.quizTable;
	}
	// getButtonSizeで引数の回答の選択肢を取得
	public int getButtonSize() {
		return this.buttonSize;
	}

	public String getRankingTable() {
		return this.rankingTable;
	}
}
