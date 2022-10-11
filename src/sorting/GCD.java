package sorting;

import java.util.Scanner;

public class GCD {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the First no : ");
		int n1 = sc.nextInt();
		System.out.print("Enter the Second no : ");
		int n2 = sc.nextInt();

		while (n1 != n2) {
			if (n1 > n2)
				n1 = n1 - n2;
			else
				n2 = n2 - n1;
		}
		System.out.print("GCD = " + n1);
	}

}
