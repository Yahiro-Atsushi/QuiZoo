package entity;

import java.io.Serializable;
import java.util.Objects;

public class JournalPort implements Serializable {
	private String journalId;
	private String playDate;
	private String userName;
	private String mode;
	private int correctCount;

	@Override
	public String toString() {
		return "JournalPort [journalId=" + journalId + ", playDate=" + playDate + ", userName=" + userName + ", mode="
				+ mode + ", correctCount=" + correctCount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(journalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JournalPort other = (JournalPort) obj;
		return Objects.equals(journalId, other.journalId);
	}

	public JournalPort(String journalId, String playDate, String userName, String mode, int correctCount) {
		this.journalId = journalId;
		this.playDate = playDate;
		this.userName = userName;
		this.mode = mode;
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

	public int getCorrectCount() {
		return correctCount;
	}

	public String getMode() {
		return mode;
	}

}
