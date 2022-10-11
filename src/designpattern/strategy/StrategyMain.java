package designpattern.strategy;

//https://www.youtube.com/watch?v=F7_cRqNKoJs&ab_channel=AjitSingh
public class StrategyMain {

	public static void main(String[] args) {
		Employee ram = new Employee("Ram", new Consultant());
		Employee rahul = new Employee("Rahul", new SeniorConsultant());

		System.out.println("=======Before promotion=======\n");

		ram.doWork();
		rahul.doWork();

		ram.promote(new SeniorConsultant());
		rahul.promote(new LeadConsultant());

		System.out.println("\n=======After promotion=======\n");

		ram.doWork();
		rahul.doWork();

	}
}
