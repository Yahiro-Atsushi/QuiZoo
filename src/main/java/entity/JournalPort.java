package entity;

import java.io.Serializable;

public class JournalPort implements Serializable {
	private String journalId;
	private String playDate;
	private String userName;
	private String correctCount;

	@Override
	public String toString() {
		return "JournalPort [playDate=" + playDate + ", userName=" + userName + ", correctCount=" + correctCount
				+ ", journalId=" + journalId + "]";
	}

	public JournalPort(String journalId, String playDate, String userName, String correctCount) {
		this.journalId = journalId;
		this.playDate = playDate;
		this.userName = userName;
		this.correctCount = correctCount;
	}

	public String getJournalId() {
		return journalId;
	}

	public String getPlayDate() {
		return playDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getCorrectCount() {
		return correctCount;
	}

}
