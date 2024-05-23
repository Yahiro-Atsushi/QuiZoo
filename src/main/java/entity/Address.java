package entity;

 // 列挙型でjspファイルを所持するクラス
public enum Address {
	INDEX("index.jsp"),
	REGISTER("WEB-INF/jsp/register.jsp"),
	MAIN("WEB-INF/jsp/main.jsp"),
	TUTORIAL("WEB-INF/jsp/tutorial.jsp"),
	QUIZ("WEB-INF/jsp/quiz.jsp"),
	ANSWER("WEB-INF/jsp/answer.jsp"),
	RESULT("WEB-INF/jsp/result.jsp"), 
	CORRECT("WEB-INF/jsp/correct.jsp"),
	NOT_CORRECT("WEB-INF/jsp/notCorrect.jsp"),
	TIMEOUT("WEB-INF/jsp/timeOut.jsp"), 
	JOURNAL_LIST("WEB-INF/jsp/journalList.jsp"),
	EMPTY_JOURNAL_LIST("WEB-INF/jsp/emptyJournalList.jsp"), 
	JOURNAL("WEB-INF/jsp/journal.jsp"),
	CHALLENGE_CLEAR("WEB-INF/jsp/challengeClear.jsp"),
	CHALLENGE_FAULT("WEB-INF/jsp/challengeFault.jsp"),
	CHALLENGE_RANKING("WEB-INF/jsp/challengeRanking.jsp"), 
	LOGOUT("WEB-INF/jsp/logout.jsp");
	
	private String address;

	private Address(String address) {
		this.address = address;
	}
 // getAddressで上記のアドレスを返す
	public String getAddress() {
		return address;
	}
	
}
