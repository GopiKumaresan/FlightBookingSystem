package flighBooking;

public class Booking {

	public int getSeatRow(String seat) {
		String[] splitSeatRows = seat.split("_");
		int seatR = Integer.parseInt(splitSeatRows[0]);
		return seatR;
	}
	public int getSeatColumn(String seat) {
		String[] splitSeatColumns = seat.split("_");
		int seatC = Integer.parseInt(splitSeatColumns[1]);
		return seatC;
	}
	
	public int calculatePrice(String bookingclass, String seatRow, boolean meal) {
			
		int businessCost = 2000;
		int economyCost = 1000;
		int window = 200;
		int aisle = 100;
		int middle = 0;
		int mealCost = 200;
		int totalPrice = 0;
		
		int seatColumn = getSeatColumn(seatRow);
		
		if(bookingclass.equals("Business")) {
			totalPrice = totalPrice + businessCost;
			if(seatColumn == 1 || seatColumn == 7) {
				totalPrice += window;
			}
			else if(seatColumn == 4) {
				totalPrice += middle;
			}
			else {
				totalPrice += aisle;
			}
		}
		
		if(meal) {
			totalPrice = totalPrice + mealCost;
		}
		
		return totalPrice;
		
	}
	
	public void bookSeat(Flight flight, Passenger pass) {
		System.out.println("Booking seat");
		String getClass = pass.flightClass;
		String[][] flightSeats= flight.businessClassSeats;
		int seatRow = getSeatRow(pass.seatNumber);
		int seatColumn = getSeatColumn(pass.seatNumber);
		
		if(getClass.equals("Business")) {
			flightSeats[seatRow-1][seatColumn-1] = "booked"; 
		}
//		int[][] seats = flight.businessSeats;
	}
	
	
	public Flight bookTicket(Flight fObj, Passenger pas) {
		
		String getClass = pas.flightClass;
		String getSeat = pas.seatNumber;
		boolean getMeal = pas.meal;
		
		int price = calculatePrice(getClass, getSeat, getMeal);
		
		bookSeat(fObj, pas);
		return fObj;
		
	}
}
