package string;

public class FirstNonRepeatingCharacter {

	static int count[] = new int[26];

	static void characterCount(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i) - 'a']++;
	}

	static char findCharacter(String str) {
		characterCount(str);
		for (int i = 0; i < str.length(); i++)
			if (count[str.charAt(i) - 'a'] == 1)
				return str.charAt(i);
		return '-';
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		System.out.println(findCharacter(str));
//OR
		int arr[] = new int[26];
		for (char ch : str.toCharArray())
			arr[ch - 'a']++;

		for (char ch : str.toCharArray()) 
			if (arr[ch - 'a'] == 1) {
				System.out.println(ch);
				break;
			}
	}

}
