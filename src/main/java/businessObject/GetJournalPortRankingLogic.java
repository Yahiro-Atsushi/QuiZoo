package businessObject;

import java.util.List;

import database.JournalDao;
import entity.GameMode;
import entity.JournalPort;

public class GetJournalPortRankingLogic {

	public static List<JournalPort> execute(GameMode mode) {
		
		JournalDao jDao = new JournalDao();
		List<JournalPort> journalPorts = 
				jDao.selectRankingByGameMode(mode);
		
		return journalPorts;
		
	}

}
