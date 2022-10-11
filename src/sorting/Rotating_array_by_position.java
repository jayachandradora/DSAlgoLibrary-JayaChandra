package sorting;

public class Rotating_array_by_position {

	public static void main(String[] args) {

		/*int [] arr = {1,2,3,4,5,6,7,8};
        int  rotate =2;

       System.out.println("Print array length " + arr.length);
       for(int i = 0; i<rotate; i++){

           for(int j = arr.length-1; j>0; j--){
               int temp = arr[j];
               arr[j] = arr[j-1];
               arr[j-1] = temp;
           }
        }*/
		
		int order =2;
		
		int [] arr = {1,2,3,4,5,6,7,8}; 
		
		if (arr == null || order < 0) {
	        throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
	    }
	    int offset = arr.length - order % arr.length;
	    if (offset > 0) {
	        int[] copy = arr.clone();
	        for (int i = 0; i < arr.length; ++i) {
	            int j = (i + offset) % arr.length;
	            arr[i] = copy[j];
	        }
	    }

       for(int j = 0; j<arr.length; j++){
         System.out.println("element is " + arr[j]);

           }
	}
 
	
}
