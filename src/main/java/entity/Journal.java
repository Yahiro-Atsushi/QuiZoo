package entity;

import java.io.Serializable;
import java.util.Map;

public class Journal extends JournalPort implements Serializable {
	private Map<Integer, String> quizIds;
	private Map<Integer, String> quizResults;
	
	public Journal(String journalId, String playDate, 
			String userName, String correctCount,
			Map<Integer, String> quizIds, Map<Integer, String> quizResults) {
		
		super(journalId, playDate, userName, correctCount);
		this.quizIds = quizIds;
		this.quizResults = quizResults;
	}
	
}
