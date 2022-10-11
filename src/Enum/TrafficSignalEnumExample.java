package Enum;

public class TrafficSignalEnumExample {

	public static void main(String[] args) {
		
		TrafficSignal []ts = TrafficSignal.values();
		for(TrafficSignal signal : ts)
			System.out.println("name : " + signal.name() +
                    " action: " + signal.getAction() );
		
				
		for(Gender g :Gender.values())
			System.out.println(g.name());
	}

}

enum Gender {
	MALE, FEMALE;
}

enum TrafficSignal{
	RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");
	
	private String action;
	
	public String getAction() {
		return this.action;
	}
	
	private TrafficSignal(String action) {
		this.action = action;
	}
}