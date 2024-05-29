package entity;


import java.io.Serializable;

// 列挙型でゲームの難易度・テーブル・回答の選択肢の数を持つ
public enum GameMode implements Serializable {
	EASY("かんたん", "quiz_easy_view", "journal_view", 4, 10), 
	NORMAL("普通", "quiz_normal_view", "journal_view", 4, 10), 
	HARD("むずかしい", "quiz_hard_view", "journal_view", 4, 10),
	CHALLENGE("チャレンジ", "quiz_challenge_view", "ranking_challenge", 4, 100),
	TEST("テスト", "quiz_test_view", "journal_view", 4, 10);

	private String strLevel; // 難易度
	private String quizTable; // データベースのテーブル名
	private String rankingTable; //履歴表示の際のテーブル名
	private int buttonSize;	// 選択肢の数
	private int quizNum; // 問題の数
	
	// コンストラクタ
	private GameMode(String strLevel, String quizTable, String rankingTable, int buttonSize, int quizNum) {
		this.strLevel = strLevel;
		this.quizTable = quizTable;
		this.rankingTable = rankingTable;
		this.buttonSize = buttonSize;
		this.quizNum = quizNum;
	}
	// getValueで引数の難易度を取得
	public String getStrLevel() {
		return this.strLevel;
	}
	// getTableで引数のデータベースのテーブルを取得
	public String getQuizTable() {
		return this.quizTable;
	}
	// getButtonSizeで引数の回答の選択肢を取得
	public int getButtonSize() {
		return this.buttonSize;
	}
	// getQuizNumで問題数を取得
	public int getQuizNum() {
		return this.quizNum;
	}

	public String getRankingTable() {
		return this.rankingTable;
	}
}
