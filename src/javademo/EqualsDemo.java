package javademo;

import java.util.HashMap;
import java.util.Map;

public class EqualsDemo {

	public static void main(String[] args) {

		Map<EmployeeKey, String > empCache = loadEmpClass();
		EmployeeKey emp1 = new EmployeeKey("1000", "10111980");
		String name = empCache.get(emp1);
		System.out.println("Name of Employee " + name);
	}
	
	static Map<EmployeeKey, String> loadEmpClass(){
		EmployeeKey emp1 = new EmployeeKey("1000", "10111980");
		EmployeeKey emp2 = new EmployeeKey("1001", "10111981");
		EmployeeKey emp3 = new EmployeeKey("1002", "10111982");
		
		Map<EmployeeKey, String> empMap = new HashMap<EmployeeKey, String>();
		empMap.put(emp1, "JC");
		empMap.put(emp2, "sujji");
		empMap.put(emp3, "ishu");
		return empMap;
	}
}

class EmployeeKey {

	String empId;
	String dob;

	public EmployeeKey(String theId, String theDob) {
		empId = theId;
		dob = theDob;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeKey other = (EmployeeKey) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

}