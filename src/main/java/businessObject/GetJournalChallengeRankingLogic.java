package businessObject;

import java.util.List;

import database.JournalDao;
import entity.JournalPort;

public class GetJournalChallengeRankingLogic {

	public static List<JournalPort> execute() {
		
		
		JournalDao jDao = new JournalDao();
		List<JournalPort> list = jDao.selectChallengeRanking();
		
		return list;
	}

}
