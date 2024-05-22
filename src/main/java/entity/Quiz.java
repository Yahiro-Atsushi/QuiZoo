package entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

	// クイズに関する情報を所持するクラス
public class Quiz implements Serializable {
	private String id; // クイズID
	private String questionMsg; // 問題文
	private String answer; // 回答
	private Map<Integer, String> buttons; // key:選択肢の番号(ボタンの番号) ・value:選択肢文
	private Map<Integer, String> buttonTexts; // key: ・ value:答えの解説

	// コンストラクタ
	public Quiz(String id, String questionMsg, String answer,
			Map<Integer, String> buttons, Map<Integer, String> buttonTexts) {
		
		this.id = nullCheck(id);
		this.questionMsg = nullCheck(questionMsg);
		this.answer = nullCheck(answer);
		this.buttons = nullCheck(buttons);
		this.buttonTexts = nullCheck(buttonTexts);
		
	}

	private Map<Integer, String> nullCheck(Map<Integer, String> map) {
		if(map == null || map.isEmpty()) {
			map = new LinkedHashMap<>();
			for(int i = 1; i <= 10; i++) {
				map.put(i, "存在しません");
			}
			return map;
		}
		
		return map;
	}

	private String nullCheck(String str) {
		if(str == null || str.isEmpty())	
			return "問題がありません";
		
		return str;
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

	public String getQuestionMsg() {
		return questionMsg;
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
