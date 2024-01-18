package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date dateCheckIn = sdf1.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dateCheckOut = sdf1.parse(sc.next());
		
		if(!dateCheckOut.after(dateCheckIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, dateCheckIn, dateCheckOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dateCheckIn = sdf1.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dateCheckOut = sdf1.parse(sc.next());
			
			Date now = new Date();
			if(dateCheckIn.before(now) || dateCheckOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if(!dateCheckOut.after(dateCheckIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
			reservation.updateDates(dateCheckIn, dateCheckOut);
			System.out.println(reservation);
			}
			
		}
		sc.close();
	}

}
