package javademo;

public class ReverseSentenceTest {

	public static void main(String[] args) {

		String sen = "Thanks a lot very much";
		String arr[] = sen.split(" ");
		
		String temp;
		for(int i=0; i<arr.length/2; i++){
			temp = arr[i];
			arr[i] = arr[arr.length -i -1];
			arr[arr.length -i -1] = temp;
		}
		
		for(String out : arr)
			System.out.println(out);
		
		System.out.println("2012 Is Leap year: " + isLeapYear(2012));
		System.out.println("2014 Is Leap year: " + isLeapYear(2014));

	}
	
	static boolean isLeapYear(int year){
		
		return (year%400 ==0) || (year%100 ==0 ) || (year%4 ==0);
	}

}
