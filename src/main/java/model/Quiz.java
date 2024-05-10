package model;

import java.io.Serializable;

public class Quiz implements Serializable {
	private String quistionMsg;
	private String answer;
	private String correct;
	private String[] choices;

	public Quiz(String quistionMsg, String answer, String correct, String[] choices) {
		this.quistionMsg = quistionMsg;
		this.answer = answer;
		this.correct = correct;
		this.choices = choices;
	}

	public String getQuistionMsg() {
		return quistionMsg;
	}

	public String getAnswer() {
		return answer;
	}

	public String getCorrect() {
		return correct;
	}

	public String[] getChoices() {
		return choices;
	}

}
