package problems;

import java.util.ArrayList;

public class PrimeNmber {

	public ArrayList<Integer> solve(int p1,int p2,int p3,int k)
	{
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		int[] nextBestNumbers = new int[3];
		int[] currIndex = new int[3];
		int[] prime = new int[3];

		nextBestNumbers[0] = prime[0] = p1;
		nextBestNumbers[1] = prime[1] = p2;
		nextBestNumbers[2] = prime[2] = p3;

		currIndex[0] = currIndex[1] = currIndex[2] = -1;

		for(int j=1;j<=k;j++)
		{
			int nextNumber = Math.min(nextBestNumbers[0],Math.min(nextBestNumbers[1],nextBestNumbers[2]));
			finalAnswer.add(nextNumber);

			for(int i=0;i<3;i++)
			{
				if(nextNumber==nextBestNumbers[i])
				{
					currIndex[i]++;
					nextBestNumbers[i] = finalAnswer.get(currIndex[i])*prime[i];
				}
			}
		}

		return finalAnswer;
	}
	public static void main(String[] args) {

		PrimeNmber pm = new PrimeNmber();
		System.out.println(pm.solve(2, 3, 5, 5));
	}

}
