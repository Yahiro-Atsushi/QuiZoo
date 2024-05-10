package model;

public enum Address {
	INDEX("index.jsp"),
	REGISTER("WEB-INF/jsp/register.jsp"),
	MAIN("WEB-INF/jsp/main.jsp"),
	TUTORIAL("WEB-INF/jsp/tutorial.jsp"),
	QUESTION("WEB-INF/jsp/question.jsp"),
	ANSWER("WEB-INF/jsp/answer.jsp"),
	RESULT("WEB-INF/jsp/.jsp");
	
	private String address;

	private Address(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
}
