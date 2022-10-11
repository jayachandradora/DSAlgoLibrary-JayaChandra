package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualsAndHashCodeSet {

	public static void main(String args[]) {

		UserData[] userData = {};
		int count = 0;
		while (count < 2) {
			Set<UserData> set = null;
			if (count == 0)
				set = new HashSet<UserData>(Arrays.asList(getuserData()));

			if (count == 1)
				set = new HashSet<UserData>(Arrays.asList(getuserData1()));

			List<UserData> list = new ArrayList<>();
			list.addAll(set);
			Object[] str3 = list.toArray();
			userData = Arrays.copyOf(str3, str3.length, UserData[].class);
			count++;
		}

		for (UserData ud : userData)
			System.out.println(ud.getEmailAddress());
	}

	public static UserData[] getuserData() {

		UserData u1 = new UserData();
		u1.setAccountName("a1");
		u1.setDisplayName("d1");
		u1.setEmailAddress("a@a.com");
		u1.setType("t1");

		UserData u2 = new UserData();
		u2.setAccountName("a2");
		u2.setDisplayName("d2");
		u2.setEmailAddress("a2@a.com");
		u2.setType("t2");

		UserData u3 = new UserData();
		u3.setAccountName("a3");
		u3.setDisplayName("d3");
		u3.setEmailAddress("a2@a.com");
		u3.setType("t3");
		UserData[] userData = { u1, u2, u3 };

		return userData;
	}

	public static UserData[] getuserData1() {

		UserData u1 = new UserData();
		u1.setAccountName("a1");
		u1.setDisplayName("d1");
		u1.setEmailAddress("a@a.com");
		u1.setType("t1");

		UserData u2 = new UserData();
		u2.setAccountName("a2");
		u2.setDisplayName("d2");
		u2.setEmailAddress("a2@a.com");
		u2.setType("t2");

		UserData u3 = new UserData();
		u3.setAccountName("a3");
		u3.setDisplayName("d3");
		u3.setEmailAddress("a3@a.com");
		u3.setType("t3");
		UserData[] userData = { u1, u2, u3 };

		return userData;
	}

}

class UserData {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		return true;
	}

	private String displayName;
	private String emailAddress;
	private String type;
	private String accountName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
