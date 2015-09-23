package permutationStrings;

import java.util.Arrays;

public class String_Permutation_Checker {

	//Doesn't work
	static boolean check_if_permutations(String str1, String str2) {
		
		char temp;
		boolean found_char;
		if (str1 == null || str2 == null) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			
			temp = str1.charAt(i);
			found_char = false;
			for (int j = 0; j < str2.length(); j++)
			{
				if (temp == str2.charAt(j)) {
					found_char = true;
				}
			}
			if (!found_char)
				return false;
		}
		return true;
	}
	
	static String sort_string(String str) {
		
		char[] strarray= str.toCharArray();
		java.util.Arrays.sort(strarray);
		return new String(strarray);
	}
	
	static boolean permutation_checker (String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		else if (str1 == null & str2 == null) 
			return true;
		else if (str1.length() != str2.length()) {
			return false;
		}
		else
			return sort_string(str1).equals(sort_string(str2));
	}
	
	static boolean permutation_checker2 (String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		else if (str1 == null && str2 == null)
			return true;
		
		else if (str1.length() != str2.length())
			return false;
		
		int char_counts[] = new int[128]; //Assumes ASCII
		char []contents = str1.toCharArray();
		
		for (char c: contents) {
			char_counts[(int) c]++;
		}
		char a;
		for (int i = 0; i < str2.length(); i++) {
			a = str2.charAt(i);
			char_counts[(int) a]--;
			if (char_counts[(int) a] < 0) {
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		String empty = "";
		String empty2 = null;
		
		String permutation1 = "ccaleb";
		String permutation2 = "balecc";
		
		String not_permutation1 = "taaurt";
		String not_permutation2 = "taaurt";
		
		System.out.println(permutation_checker(empty, empty2));
		System.out.println(permutation_checker(permutation1, permutation2));
		System.out.println(permutation_checker(not_permutation1, not_permutation2));
		
	}
}
