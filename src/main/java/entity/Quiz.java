package entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

	// クイズに関する情報を所持するクラス
public class Quiz implements Serializable {
	private String id; // クイズID(ユニークな値)
	private String quistionMsg; // 問題文
	private String answer; // 回答
	private Map<Integer, String> buttons; // key: ・value:選択肢文(ボタンの番号)
	private Map<Integer, String> buttonTexts; // key: ・ value:答えの解説

	// コンストラクタ
	public Quiz(String id, String quistionMsg, String answer,
			Map<Integer, String> buttons, Map<Integer, String> buttonTexts) {
		this.id = id;
		this.quistionMsg = quistionMsg;
		this.answer = answer;
		this.buttons = buttons;
		this.buttonTexts = buttonTexts;
		
		System.out.println("Quiz Constructor: " + buttons.toString());
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

	public String getId() {
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
