package businessObject;

public class DataCheck{

	public static boolean isInputName(String data) {
		if(isInput(data)) {
			data.trim();
			
			return true;
		}
		
		return false;
	}

	private static boolean isInput(String data) {
		if(data != null&& data.length() != 0) {
			return true;
		}
		return false;
	}
}
