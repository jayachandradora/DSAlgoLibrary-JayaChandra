package arrays;

public class DoubleFirstElements {

	public static void main(String[] args) {
		//4 4 8 0 0 8 
		int arr[] = {2, 2, 0, 4, 0, 8};
		int temp =0, j=0; 
		for(int i=0; i<arr.length; i++){
			if(arr[i] != 0){
				arr[i] = arr[i]*2;
			}else{
				if(arr.length-1-j == 0)
					j++;
				else if(arr.length-1 == i)
					break;
				
				temp= arr[i];
				arr[i] = arr[arr.length-1-j];
				arr[arr.length-1-j] = temp;
				j++;
			}
		}
		for(int l: arr)
			System.out.print(l + " ");
	}

}
