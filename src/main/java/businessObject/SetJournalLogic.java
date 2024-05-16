package businessObject;

import java.util.LinkedHashMap;
import java.util.Map;

import database.ColumnNames;
import database.JournalDao;
import entity.Game;

public class SetJournalLogic {

	public static void execute(String userName, Game game, Map<Integer, String> result) {
		final int QUIZ_SIZE = game.getQuizzes().size();
		final int START_SECTION = 1;
		final int QUIZ_VALUE = 10;
		
		if(QUIZ_SIZE != QUIZ_VALUE) {
			System.out.println("SetJournalLogic.Execute（）：問題数が不正です。");
			return;
		}
		
		Map<String, String> journalMap = new LinkedHashMap<>();
		
		journalMap.put(ColumnNames.name.name(), userName);
		for(int section = START_SECTION; section <= QUIZ_SIZE; section++) {
			
			
		}
		

		JournalDao jDao = new JournalDao();
		jDao.insertGameResult(journalMap);
	}

}
