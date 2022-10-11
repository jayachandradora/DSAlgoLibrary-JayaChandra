package intv.str_arr;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitions {

	public static void main(String[] args) {
		String input = "aabb";
		PalindromicPartitions pp = new PalindromicPartitions();
		System.out.println(pp.partition(input));
	}
	public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
         
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        
        if (start >= s.length()) 
            result.add(new ArrayList<String>(currentList));
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currentList.add(s.substring(start, i + 1));
                dfs(i + 1, result, currentList, s);      // add current substring in the currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) 
                return false;
        }
        return true;
    }
}
