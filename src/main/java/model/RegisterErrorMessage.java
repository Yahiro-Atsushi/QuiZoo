package model;

public class RegisterErrorMessage {
	private String userDoubleError;
	private String nameError;
	private String passError;

	public RegisterErrorMessage(String userDoubleError, String nameError, String passError) {
		this.userDoubleError = userDoubleError;
		this.nameError = nameError;
		this.passError = passError;
	}

	@Override
	public String toString() {
		return "RegisterErrorMessage [userDoubleError=" + userDoubleError + ", nameError=" + nameError + ", passError="
				+ passError + "]";
	}

	public String getUserDoubleError() {
		return userDoubleError;
	}

	public String getNameError() {
		return nameError;
	}

	public String getPassError() {
		return passError;
	}

}
