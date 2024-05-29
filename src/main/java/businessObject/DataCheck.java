package businessObject;

public class DataCheck {

	public static boolean isInputName(String data) {
		if (!isInput(data)) {
			return false;
		}

		int length = data.length();
		final int MIN = 1;
		final int MAX = 12;

		if (!(MIN <= length && length <= MAX)) {
			return false;
		}

		return true;
	}

	public static boolean isValidPass(String data) {
		if (!isInput(data)) {
			return false;
		}

		int length = data.length();
		final int MIN = 4;
		final int MAX = 12;

		if (!(MIN <= length && length <= MAX)) {
			return false;
		}

		if (!isAlphanumericChars(data)) {
			return false;
		}

		return true;
	}

	private static boolean isAlphanumericChars(String data) {
		for (char c : data.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isInput(String data) {
		if (data != null && data.length() != 0) {
			return true;
		}
		return false;
	}
}
