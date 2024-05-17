package businessObject;

import java.util.Map;

import database.JournalDao;
import entity.JournalPort;

public class SetJournalMapLogic {

	public static Map<Integer, JournalPort> execute(String userName) {
		
		JournalDao jDao = new JournalDao();
		Map<Integer, JournalPort> journalMap = 
				jDao.selectJournalIdsByUserName(userName);
		
		
		return null;
		
		
		
	}
}
