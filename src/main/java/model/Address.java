package model;

public enum Address {
	INDEX("index.jsp"),
	REGISTER("WEB-INF/jsp/register.jsp"),
	MAIN("WEB-INF/jsp/main.jsp"),
	TUTORIAL("WEB-INF/jsp/tutorial.jsp"),
	QUIZ("WEB-INF/jsp/quiz.jsp"),
	ANSWER("WEB-INF/jsp/answer.jsp"),
	RESULT("WEB-INF/jsp/result.jsp"), 
	CORRECT("WEB-INF/jsp/correct.jsp"),
	NOT_CORRECT("WEB-INF/jsp/notCorrect.jsp");
	
	private String address;

	private Address(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
}
