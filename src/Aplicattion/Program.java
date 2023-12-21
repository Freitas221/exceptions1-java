
package Aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.print("CheckIn data: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut data: ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Entre com os dados da reserva atualizada: ");
			System.out.print("CheckIn data: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut data: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Data inválida");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro de reserva" + e.getMessage());
		}

		sc.close();
	}

}
