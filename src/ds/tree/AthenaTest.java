package ds.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AthenaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minSteps(int[] piles) {
	    Arrays.sort(piles);
	    int sum = 0;
	    int n = piles.length;
	    for (int i = 1; i < n; i++) {
	        if (piles[n-i-1] != piles[n-i]) {
	            sum += i;
	        }
	    }
	    return sum;
	}
	
	public static long minimalSum(List<Integer> num, int k) {
        if (num.size() == 0) {
            return 0;
        }

        int index = 0;
        int max = Integer.MAX_VALUE;
        while (k > 0) {
            int currentValue = num.get(index);
            if (currentValue <= max) {
                num.sort(Comparator.reverseOrder());
                index = 0;
                max = num.get(0) / 2;
                continue;
            }
            k--;

            int roundUp = currentValue & 1;
            currentValue /= 2;
            currentValue += roundUp;

            num.set(index, currentValue);
            if (index + 1 < num.size()) {
                index++;
            }
        }
        return num.stream().mapToLong(a->a).sum();
    }

}
