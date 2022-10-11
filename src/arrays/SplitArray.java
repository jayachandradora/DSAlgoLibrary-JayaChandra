package arrays;

public class SplitArray {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5,6};
		int k =2;
		int arr1[] = new int[arr.length];
		int index = 0;
		for(int i=k; i<arr.length; i++){
			arr1[index] = arr[i];
			index = index+1;
		}
		
		for(int i=0; i<k; i++){
			arr1[index] =arr[i];
			index = index+1;
		}
		
		for(int i :arr1)
			System.out.println(i);
	}

}
