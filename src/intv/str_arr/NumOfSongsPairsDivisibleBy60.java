package intv.str_arr;

public class NumOfSongsPairsDivisibleBy60 {

	public static void main(String[] args) {
		int time[] = { 30, 20, 150, 100, 40 };
		System.out.println(numPairsDivisibleBy60(time));
	}

	static int numPairsDivisibleBy60(int[] time) {

		int[] cnt = new int[60];
		int total = 0;
		for (int num : time) {
			int remainder = num % 60;
			int comp = (60 - remainder) % 60;
			total += cnt[comp];
			cnt[remainder]++;
		}

		return total;
	}

}
