package arrays;

public class Arrange {
	
	int no;
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
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
		Arrange other = (Arrange) obj;
		if (no != other.no)
			return false;
		return true;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	public static void main(String args[]){
		/*int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		List<Integer> list1 = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++){
			list1.add(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++){
			if(list1.contains(i))
				System.out.println(i);
			else
				System.out.println(-1);
		}*/
		
		int arr1[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		
		int neg=0, pos = 0;
		for(int i=0; i<arr1.length; i++){
			int temp = 0;
			if(arr1[i]<0){
				temp = arr1[neg];
				arr1[neg] = arr1[i];
				arr1[i] = temp;
				neg = neg+1;
			}
		}
		
		pos = neg;
		neg = neg-1;
		int temp=0;
		int size = arr1.length-1;
		while(pos >size && neg<=pos && arr1[neg]<0 ){
			temp = arr1[neg];
            arr1[neg] = arr1[pos];
            arr1[pos] = temp;
            pos++;
            neg += 2;
		}
		
		for(int k : arr1)
			System.out.println(k);
		
	}
}
