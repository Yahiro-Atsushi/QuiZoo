package entity;

	// 列挙型でゲームの難易度・テーブル・回答の選択肢を持つ
public enum GameMode {
	EASY("チンパンジー", " quiz_easy ", 4), 
	NORMAL("人間", " quiz_normal ", 4), 
	HARD("オランウータン", " quiz_hard ", 4),
	CHALLENGE("キメラ", " quiz_challenge ", 4),
	TUTORIAL("テスト", " quiz_test ", 4);
	// 引数の難易度
	private String animal;
	// 引数のデータベースのテーブル名
	private String table;
	// 引数の回答の選択肢の数
	private int buttonSize;
	
	// コンストラクタ
	private GameMode(String animal, String table, int buttonSize) {
		this.animal = animal;
		this.table = table;
		this.buttonSize = buttonSize;
	}
	// getValueで引数の難易度を取得
	public String getValue() {
		return this.animal;
	}
	// getTableで引数のデータベースのテーブルを取得
	public String getTable() {
		return this.table;
	}
	// getButtonSizeで引数の回答の選択肢を取得
	public int getButtonSize() {
		return this.buttonSize;
	}
}
