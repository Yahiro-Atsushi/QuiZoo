package entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

	// ゲームの情報を所持するクラス
public class Game implements Serializable {
	private int quizCount; // 問題数
	private GameMode mode; // ゲームの難易度・テーブル名・解答の選択肢の数(列挙型)
	private Map<Integer, Quiz> quizzes; // key:現在の問題数・value:現在のクイズ
	private Map<Integer, Boolean> isCorrects; // key:選択肢の番号・value:正解(true)or不正解(false)の判定

	// Gameコンストラクタ
	public Game(GameMode mode) {
		//問題数の初期値は1にする。これはゲームの始まりが１問目であり、Mapのkeyも1以上10以下で作成するから。
		this.quizCount = 1;
		this.mode = mode;
		this.quizzes = new LinkedHashMap<>();
		this.isCorrects = new LinkedHashMap<>();
	}
	// 所持内容を返す
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(""
				+ "Game [quizCount=" + quizCount + ", mode=" + mode + "\n"
				+ "quizzes and isCorrects \n");
		for (int key : quizzes.keySet()) {
			sb.append(""
					+ "[" + key + ":" + quizzes.get(key).getAnswer()
					+ "/" + isCorrects.get(key) + "]\n");
		}
		return sb.toString();
	}

	public int getQuizCount() {
		return quizCount;
	}

	public void setQuizCount(int count) {
		this.quizCount = count;
	}

	public GameMode getMode() {
		return mode;
	}

	public Map<Integer, Quiz> getQuizzes() {
		return quizzes;
	}

	public Map<Integer, Boolean> getIsCorrects() {
		return isCorrects;
	}
}
