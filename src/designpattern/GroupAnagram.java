package designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

	public static void main(String[] args) {

		String strs[] = {"eat", "ate", "nat", "bat", "tan", "tea","sujata"};
		GroupAnagram ga = new GroupAnagram();
		List<List<String>> gaList = ga.groupAnagrams(strs);
		for(List<String> gaLists : gaList)
				//for(String gas : gaLists)
					System.out.println(gaLists);
	}
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	            map.put(str, new ArrayList<String>());
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
}

