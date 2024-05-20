package businessObject;

import java.util.List;

import database.JournalDao;
import entity.JournalPort;

public class GetJournalPortLogic {

	public static List<JournalPort> execute(String userName) {
		
		JournalDao jDao = new JournalDao();
		List<JournalPort> journalPorts = 
				jDao.selectJournalPortsByUserName(userName);
		
		return journalPorts;
		
	}
}
