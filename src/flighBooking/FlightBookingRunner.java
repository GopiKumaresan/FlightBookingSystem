package flighBooking;

import java.util.Scanner;

public class FlightBookingRunner {

	static int[] seatArrangements(String seatClass){
//		int seatCount[] = new int[2];
//		2,3,2:12
		String[] splitSeats = seatClass.split(":");
		String[] splitColumns = splitSeats[0].split(",");
		int column1 = Integer.parseInt(splitColumns[0]);
		int column2 = Integer.parseInt(splitColumns[1]);
		int column3 = Integer.parseInt(splitColumns[2]);
		
		
		int totalRows = Integer.parseInt(splitSeats[1]);
		
		int totalColumns = column1+column2+column3;
		
		int[] seatCount = new int[]{totalRows, totalColumns};
		return seatCount;
		
	}
	
	
	public static void main(String[] args) {
	
//		String[] inputs = {"F101##Timing:Morning##Business:2,3,2:12##Economy:3,4,4:20", "F102##Timing:Evening##Business:2,4,2:12##Economy:3,4,2:20"};
		String[] inputs = {"F101##Timing:Morning##Business:2,3,2:12##Economy:3,4,4:20"};
		Flight[] flightObject = new Flight[inputs.length];
		for(int i=0; i <inputs.length; i++) 
		{
			String tempInput = inputs[i];
			String[] splitInputs = tempInput.split("##");
			String flightNumber = splitInputs[0];
			String timing = splitInputs[1];
			String business = splitInputs[2];
			String economy = splitInputs[3];
			int[] businessSeats = seatArrangements(business.replace("Business:",""));
			int[] economySeats = seatArrangements(economy.replace("Economy:",""));
			flightObject[i] = new Flight(flightNumber, timing.replace("Timing:",""), businessSeats, economySeats);
			System.out.println(flightObject[i]);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many tickets you want to book ?");
		int numberOfTickets = input.nextInt();
		input.nextLine();
		Passenger[] passenger = new Passenger[numberOfTickets];
		for(int i = 0; i < numberOfTickets; i++) {
			System.out.println("Enter your name : \n");
			String name = input.nextLine();
			System.out.println("Enter your age : ");
			int age = input.nextInt();
			input.nextLine();
			System.out.println("Do You want meal ?\n Type 'Y' for yes or 'N' for no");
			String meal = input.nextLine();
			boolean mealPreference = (meal == "Y") ? true : false;
			System.out.println("Enter your timing from MORNING or EVENING ");
			String timing = input.nextLine();
			System.out.println("Enter your preferred class from Business or Economy ");
			String travelClass = input.nextLine();
			
			flightObject[0].constructSeats();
			flightObject[0].displayFlightSeats();
			System.out.println("Select your seats");
			String seatNumber = input.nextLine();
			
			passenger[i] = new Passenger(name, age, mealPreference, timing, travelClass, seatNumber);
			Booking book = new Booking();
			book.bookTicket(flightObject[0], passenger[i]);	
			flightObject[0].displayFlightSeats();
		}
		
				
		
		
		
		
		
	}

}
