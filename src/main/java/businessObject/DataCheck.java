package businessObject;

public class DataCheck{

	public static boolean isInputName(String data) {
		if(isInput(data)) {
			data.trim();
			return true;
		}
		
		return false;
	}
	
	public static boolean isValidPass(String data) {
		if(!isInput(data)) {
			return false;
		}
		data.trim();
		
		int length = data.length();
		final int MIN = 4;
		final int MAX = 12;
		
		if(!(MIN <= length && length <= MAX)) {
			return false;
		}
		
		for (char c : data.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
		
		return true;
	}

	private static boolean isMatchedExpression(String data) {
		String expression = "[]{4,8}";
		
		
		return false;
	}

	private static boolean isInput(String data) {
		if(data != null&& data.length() != 0) {
			return true;
		}
		return false;
	}
}
