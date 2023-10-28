package flighBooking;

public class Passenger {

	String name;
	int age;
	boolean meal;
	String preferredTiming;
	String flightClass;
	String seatNumber;
	
	public Passenger(String name, int age, boolean meal, String preferredTiming, String flightClass, String seatNumber){
		this.name = name;
		this.age = age;
		this.meal = meal;
		this.preferredTiming = preferredTiming;
		this.flightClass = flightClass;
		this.seatNumber = seatNumber;
	}
}
