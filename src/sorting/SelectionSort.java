package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 12, 30, 40, 8, 10 };
		SelectionSort ss = new SelectionSort();
		ss.sort(arr);
		ss.print(arr);
	}

	void sort(int arr[]) {

		int n = arr.length;

		for(int i=0; i<n;i++){
			
			int min_idx = i;
			
			//find min index
			for(int j=i+1; j<n; j++)
				if(arr[min_idx]>arr[j])
					min_idx = j;
			
			
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
			
		}
	}

	void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
}
