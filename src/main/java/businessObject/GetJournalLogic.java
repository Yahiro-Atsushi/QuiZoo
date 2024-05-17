package businessObject;

import database.JournalDao;
import entity.Journal;

public class GetJournalLogic {

	public static Journal execute(String journalId) {
		JournalDao jDao = new JournalDao();
		Journal journal = jDao.findJournalById(journalId);
		return journal;
	}

}
