package rotationChecker;

public class Rotation_Checker {

	static boolean isRotation(String str1, String str2) {
		
		if (str1 == null || str2 == null) {
			return false;
		} 
		
		if (str1.length() != str2.length()) {
			return false;
		}
		String str1str1 = str1 + str1;
		
		return str1str1.contains(str2);
	}
	
	public static void main(String[] args) {
		String NULL = null;
		String empty = "";
		
		String test1a = "calebkumar";
		String test1b = "lebkumarca";
		
		String test2a = "mynameisryan";
		String test2b = "ryanisnamemy";
		
		System.out.println(isRotation(NULL, NULL));
		System.out.println(isRotation(empty, empty));
		System.out.println(isRotation(test1a, test1b));
		System.out.println(isRotation(test2a, test2b));
		
	}
}
