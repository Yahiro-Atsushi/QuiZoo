package entity;

import java.io.Serializable;
import java.util.Map;

public class Journal extends JournalPort implements Serializable {
	private Map<Integer, String> quizIds;
	private Map<Integer, String> quizResults;
	
	public Journal(String journalId, String playDate, 
			String userName, String mode, int correctCount,
			Map<Integer, String> quizIds, Map<Integer, String> quizResults) {
		
		super(journalId, playDate, userName, mode, correctCount);
		this.quizIds = quizIds;
		this.quizResults = quizResults;
	}

	public Map<Integer, String> getQuizIds() {
		return quizIds;
	}

	public Map<Integer, String> getQuizResults() {
		return quizResults;
	}
	
}
