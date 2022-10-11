package designpattern.decorator;

//https://www.youtube.com/watch?v=DX6zmUyIhZg&list=PLFYf87MeyEq4LZVVExVFia_WPtXKrCfrT&ab_channel=AjitSingh
public class Test {
	public static void main(String[] args) {
		
		FlightSeat mainCabinSeat = new WiFi(new HeadPhone(new LiveTV(new MainCabinSeat())));

		System.out.println("Chosen Facilities for your seat:");
		System.out.println(mainCabinSeat.getFacilities());
		System.out.println("Total Cost:" + mainCabinSeat.getCost());
	}
}
