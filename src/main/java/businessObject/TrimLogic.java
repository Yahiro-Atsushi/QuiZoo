package businessObject;

public class TrimLogic {

	public static String execute(String str) {
		if (str != null && str.length() != 0) {
			str.trim();
		}

		return str;
	}

}
