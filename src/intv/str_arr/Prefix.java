package intv.str_arr;

import java.util.ArrayList;
import java.util.List;

public class Prefix {

	public static void main(String[] args) {
		List<String> res = new ArrayList<>();
		res.add("aajaya");
		res.add("aaSujata");

		for (String str : findDistinct(res, "aa"))
			System.out.println(str);

	}

	public static List<String> findDistinct(List<String> names, String prefix) {
		List<String> res = new ArrayList<>();
		StringBuilder strb = new StringBuilder();

		for (String str : names)
			if (str.startsWith(prefix)) {
				String temp = "";
				for (int i = 0; i < str.length(); i++) {
					if (temp.indexOf(str.charAt(i)) == -1) {
						temp = temp + str.charAt(i);
					}
				}
				res.add(strb.append(str).append("-").append(temp.length()).toString());
				strb = new StringBuilder();
			}
		return res;
	}

}
