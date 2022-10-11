package dp;

public class MinimumSubSetSumDifference {

	public static int findMinRec(int arr[], int n, int sumCalculated, int sumTotal) {
		if (n == 0)
			return Math.abs((sumTotal - sumCalculated) - sumCalculated);

		return Math.min(findMinRec(arr, n - 1, sumCalculated + arr[n - 1], sumTotal),
				findMinRec(arr, n - 1, sumCalculated, sumTotal));
	}

	public static int findMin(int arr[], int n) {
		int sumTotal = 0;
		for (int i = 0; i < n; i++)
			sumTotal += arr[i];

		return findMinRec(arr, n, 0, sumTotal);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 2, 1 };
		int n = arr.length;
		System.out.print("The minimum difference" + " between two sets is " + findMin(arr, n));
		System.out.println();
		System.out.println(findMinBottomUp(arr, n));
	}

	static int findMinBottomUp(int arr[], int n) { 
        int sum = 0;  
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
      
        boolean dp[][] = new boolean[n + 1][sum + 1]; 
        
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true; 
      
        for (int i = 1; i <= n; i++) {// consider all sum from 1 to sum
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
			}
		}
        int diff = Integer.MAX_VALUE; 
          
        for (int j = sum / 2; j >= 0; j--){ 
            if (dp[n][j] == true){ 
                diff = sum - 2 * j; 
                break; 
            } 
        } 
        return diff; 
    }
	
	// Refer this link as well -- https://thecodingsimplified.com/partition-with-min-difference-of-subset-sum/
	// See his video https://www.youtube.com/watch?v=WJUXGJ4pGtM
}
