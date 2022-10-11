package arrays;

public class RotationCountLinearSearch {

	// Returns count of rotations for an 
    // array which is first sorted in 
    // ascending order, then rotated
    static int countRotations(int arr[], int n)
    {
        // We basically find index of minimum
        // element
        int min = arr[0], min_index = -1;
        for (int i = 0; i < n; i++)
        {
            if (min > arr[i])
            {
                min = arr[i];
                min_index = i;
            }
        }
        //Anti Clockwise Array Rotation.
        return n - min_index;
        //Anti Clockwise Array Rotation.
        //return min_index;
    }
 
    // Driver program to test above functions
    public static void main (String[] args) 
    {
    	// 2,3,6,12,15,18
    	//Clockwise Array Rotation.
        //int arr[] = {15, 18, 2, 3, 6, 12};
    	//Anti Clockwise Array Rotation.
    	int arr[] = {15, 18, 2, 3, 6, 12};
        int n = arr.length;
     
        System.out.println(countRotations(arr, n));
    }
}