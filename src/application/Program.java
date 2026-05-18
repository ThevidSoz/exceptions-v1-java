package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			/*
			 * Instanciando a Reservation
			 */
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);

			/*
			 * Atualiacao de reserva
			 */
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserv.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reserv);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		} /*Exceção personalizada */ 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error" + e.getMessage());
		}

		sc.close();
	}
}