package model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game implements Serializable {
	private int quizCount;
	private GameMode mode;
	private Map<Integer, Quiz> quizzes;
	private Map<Integer, Boolean> isCorrects;

	public Game(GameMode mode) {
		//問題数の初期値は０
		this.quizCount = 0;
		this.mode = mode;
		this.quizzes = new LinkedHashMap<>();
		this.isCorrects = new LinkedHashMap<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(""
				+ "Game [quizCount=" + quizCount + ", mode=" + mode + "\n"
				+ "quizzes and isCorrects \n");
		for(int key : quizzes.keySet()) {
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
