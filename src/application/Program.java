package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (! checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");		
		}
		else {
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reserv);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			/*
			 * Validação de entrada das datas
			 * Verificando se os valores que serão inseridos são maiores maiores que o atual
			 */
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (! checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");		
			}
			reserv.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reserv);
		}
		sc.close();
	}

}
