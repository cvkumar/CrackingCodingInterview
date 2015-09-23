package unique_string;

public class Unique_string {

	
	static boolean checkUnique(String str) {
		if (str.length() > 128)
			return false;
		
		
		boolean all_chars[] = new boolean[128];
		int temp;
			for (int i = 0; i < str.length(); i++) {
				temp = str.charAt(i);
				
				if (all_chars[temp])
					return false;
				else
					all_chars[temp] = true;
				}
			return true;
		}
	
	public static void main (String[] args)
	{
		String test1 = "Aelo";
		/*String test2 = "abcdefghijklmnopa";
		String test3 = "";
		String test4 = "a";
		*/
		System.out.println(checkUnique(test1));
		System.out.println((int) test1.charAt(0));
		/*System.out.println(checkUnique(test2));
		System.out.println(checkUnique(test3));
		System.out.println(checkUnique(test4));*/
		
		
		
	}
}

