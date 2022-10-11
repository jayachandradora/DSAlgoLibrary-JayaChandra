package arrays;

public class MinimumSwapArr {

	public static void main(String[] args) {
		//int arr[] = {2, 7, 9, 5, 8, 7, 4};
		int arr[] = {7,12,11,10,9,5,4,7,17,18,6,67,2,78,4,5,2,7};
		//int k = 5;
		int k = 7;
		int index = 0;
		int p =0;
		for(int i=0; i<arr.length; i++){
			int temp = 0;
			if(arr[i] == k)
				p = 1;
			
			if(arr[i] <= k){
				if(p==1){
					index = index +1;
					temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}
		
		for(int j : arr)
			System.out.println(j);
		
		System.out.println("number of swap: " + index);
	}

}
