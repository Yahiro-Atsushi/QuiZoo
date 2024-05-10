package model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Game implements Serializable {
	private int quizCount;
	private GameMode mode;
	private Map<Integer, Quiz> quiz;
	private Map<Integer, Boolean> isCorrects;

	public Game(GameMode mode) {
		//問題数の初期値は０
		this.quizCount = 0;
		this.mode = mode;
		this.quiz = new TreeMap<>();
		this.isCorrects = new TreeMap<>();
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

	public Map<Integer, Quiz> getQuiz() {
		return quiz;
	}

	public Map<Integer, Boolean> getIsCorrects() {
		return isCorrects;
	}
	
}