package model;

import java.io.Serializable;
import java.util.Map;

public class Game implements Serializable {
	private int quizCount;
	private GameMode mode;
	private Map<Integer, Quiz> quiz;
	private Map<Integer, Boolean> isCorrects;

	public int getQuizCount() {
		return quizCount;
	}
	
	public void setQuizCount(int count) {
		this.quizCount = count;
	}
	
	public GameMode getMode() {
		return mode;
	}

	public Map<Integer, Quiz> getQuiz() {
		return quiz;
	}

	public Map<Integer, Boolean> getIsCorrects() {
		return isCorrects;
	}
	
}
