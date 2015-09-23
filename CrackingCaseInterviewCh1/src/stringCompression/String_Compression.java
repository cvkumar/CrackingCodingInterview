package stringCompression;

import java.util.HashMap;

public class String_Compression {

	//This Method doesn't work because string is ordered which makes problem much easier and because hashmaps aren't ordered
	static String compress_string (String str) {
		
		HashMap<Character, Integer> char_occurences = new HashMap<Character, Integer>();
		char current_char;
		int unique_count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			current_char=str.charAt(i);
			if (char_occurences.get(current_char) == null) {
				char_occurences.put(current_char, 1);
				unique_count++;
			}
			else {
				char_occurences.put(current_char, char_occurences.get(current_char) + 1);
			}
		}
		
		if (unique_count * 2 >= str.length()) { // not going to have enough space for new string so return original string
			System.out.println(str.length() * 2 + " " + unique_count);
			return str;
		}
		
		char [] compressed_string = new char [unique_count * 2];
		int i = 0;
		 
		for(char letter: char_occurences.keySet()) {
			 compressed_string[i] = letter;
			 compressed_string[i+1] = (char) ((char_occurences.get(letter)) + '0');
			 i += 2;
		}
		return compressed_string.toString();
	}
	
	static String book_compress_string (String str) {
		
		int size = compressed_string_size(str);
		
		if (size > str.length()) {
			System.out.println("The compressed string would be larger than original String");
			return str;
		}
		
		StringBuffer my_str = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if (last == str.charAt(i)) {
				count++;
			}
			else {
				my_str.append(last);
				my_str.append(String.valueOf(count));
				last = str.charAt(i);
				count = 1;
			}
		}
		my_str.append(last);
		my_str.append(String.valueOf(count));
		return my_str.toString();
	}
	
	//Obtains size of the soon to be compressed string.
	static int compressed_string_size (String str) {
		
		if (str == null || str.isEmpty()) {
			System.out.println("Sorry, the given string is empty or null");
			return 0;
		}
		
		char last = str.charAt(0);
		int count = 1;
		int size = 0;
		
		for (int i = 1; i < str.length(); i++) {
			
			if (str.charAt(i) == last) {
				count++;
			}
			
			else {
				size += 1 + String.valueOf(count).length(); // the length of the digits of the int
				last = str.charAt(i);		
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static void main(String[] args) {
		String test1 = "aabcccccaaa";
		String test2 = "aabbccddee";
		String Null = "a";
		
		System.out.println(book_compress_string(test1));
		System.out.println(book_compress_string(test2));
		System.out.println(book_compress_string(Null));
		
	}
	
}
