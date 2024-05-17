package entity;

import java.io.Serializable;

	
public class LoginUserErrorMessage implements Serializable {
	private String notUser;
	private String nameError;
	private String passError;

	@Override
	public String toString() {
		return "LoginUserErrorMessage [notUser=" + notUser + ", nameError=" + nameError + ", passError=" + passError
				+ "]";
	}

	public LoginUserErrorMessage(String notUser, String nameError, String passError) {
		this.notUser = notUser;
		this.nameError = nameError;
		this.passError = passError;
	}

	public String getNotUser() {
		return notUser;
	}

	public String getNameError() {
		return nameError;
	}

	public String getPassError() {
		return passError;
	}

}
