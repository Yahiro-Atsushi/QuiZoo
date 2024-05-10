package model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Quiz implements Serializable {
	private int id;
	private String quistionMsg;
	private String answer;
	private Map<Integer, String> buttons;
	private Map<Integer, String> buttonTexts;

	public Quiz(int id, String quistionMsg, String answer,
			Map<Integer, String> buttons, Map<Integer, String> buttonTexts) {
		this.id = id;
		this.quistionMsg = quistionMsg;
		this.answer = answer;
		this.buttons = buttons;
		this.buttonTexts = buttonTexts;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public int getId() {
		return this.id;
	}

	public String getQuistionMsg() {
		return quistionMsg;
	}

	public String getAnswer() {
		return answer;
	}

	public Map<Integer, String> getButtons() {
		return buttons;
	}

	public Map<Integer, String> getButtonTexts() {
		return buttonTexts;
	}

}
