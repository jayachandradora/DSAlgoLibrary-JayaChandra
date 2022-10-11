package arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWithinkIndices {

	public boolean duplicate(int arr[],int k){
        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0; i < arr.length; i++){
            if(visited.contains(arr[i])){
                return true;
            }
            if(i >= k){
                visited.remove(arr[i-k]);
            }
            visited.add(arr[i]);
        }
        return false;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,11,2,5,6};
        DuplicateWithinkIndices dk = new DuplicateWithinkIndices();
        System.out.println(dk.duplicate(arr, 3));
    }
    
}
