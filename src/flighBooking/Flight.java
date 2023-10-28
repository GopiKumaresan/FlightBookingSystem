package flighBooking;

import java.util.Arrays;

public class Flight {
	String flightNumber;
	String timing;
	int[] businessSeats;
	int[] economySeats;
	String[][] businessClassSeats;
	String[][] economyClassSeats;
	public Flight(String flightNumber, String timing, int[] bseats, int[] eSeats) {
		this.flightNumber = flightNumber;
		this.timing = timing;
		this.businessSeats = bseats;
		this.economySeats = eSeats;
		constructSeats();
	}
	public String toString() {
		return ("FNo : "+flightNumber +
							"\nTiming : "+timing +
							"\nbusinessSeats : "+Arrays.toString(businessSeats)+
							"\neconomySeats : "+Arrays.toString(economySeats));
	}
	
	public void constructSeats() {
		businessClassSeats = new String[businessSeats[0]][businessSeats[1]];
//		economyClassSeats = new int[economyClass[0]][economyClass[1]];
		
//		System.out.println("Business Class");
		for(int i = 0; i < businessClassSeats.length; i++) {
			for(int j = 0; j < businessClassSeats[0].length; j++) {
//				System.out.print((i+1)+"_"+(j+1)+" 	");
				businessClassSeats[i][j] = (i+1)+"_"+(j+1);
			}
//			System.out.println();
		}
	}	
	
	public void displayFlightSeats() {
		System.out.println("Displaying Seats");
		for(int i = 0; i < businessClassSeats.length; i++) {
			for(int j = 0; j < businessClassSeats[0].length; j++) {
//				System.out.print((i+1)+"_"+(j+1)+" 	"); //Wrong print
				System.out.print((businessClassSeats[i][j])+"	");
			}
			System.out.println();
		}
	}
}




