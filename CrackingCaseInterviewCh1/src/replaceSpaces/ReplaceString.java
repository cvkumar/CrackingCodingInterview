package replaceSpaces;

public class ReplaceString {

	//replaces ' ' with '%20'
	static void replace (char[] str, int length) {
		
		char [] new_str = new char[length];
		int j = 0;
		
		for (int i = 0; i < str.length; i++) {
			
			if (str[i] == ' ') {
				new_str[i + j] = '%';
				new_str[i + j + 1] = '2';
				new_str[i + j + 2] = '0';
				j += 2;
			}
			else
				new_str[i + j] = str[i];
		}
		System.out.println(new_str);
		str = new_str;
	}
	
	//length is the "true" length of the string "caleb " = 6
	static void replaceSpaces (char[] str, int length) {
		
		if (str.length == 0) {
			return;
		}
		
		int spaces = 0, new_length;
		
		for (int i = 0; i < length; i++) {
			
			if (str[i] == ' ') 
				spaces++;
		}
		
		if (spaces == 0) 
			return;
		//System.out.println(spaces);
		new_length = spaces * 2 + length;
		//System.out.println(new_length);
		str[new_length] = '\0';
		
		for (int j = length - 1; j >= 0; j--) {
			if (str[j] == ' ') {
				//System.out.println("Space Found");
				str[j - 2 + spaces * 2] = '%';
				str[j - 1 + spaces * 2] = '2';
				str[j + spaces * 2] = '0';
				spaces--;
			}
			else
				//System.out.println("No Space");
				str[j + spaces * 2] = str[j];
		}
		
	}
	
	public static void main (String[] args) {
		char[] test1 = "Cal eb   ".toCharArray();
		char[] test2 = "A cat is     ".toCharArray();
		char[] empty = "".toCharArray();
		char[] no_spaces = "Tyler".toCharArray();
		
		replaceSpaces(test1, 6);
		replaceSpaces(test2, 8);
		replaceSpaces(empty, 0);
		replaceSpaces(no_spaces, 5);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(empty);
		System.out.println(no_spaces);
	}
}
