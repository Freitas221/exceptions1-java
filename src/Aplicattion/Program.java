

	package Aplicattion;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;

	import model.entities.Reservation;

	public class Program {

		public static void main(String[] args) throws ParseException {

			Scanner sc = new Scanner (System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.print("CheckIn data: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut data: ");
			Date checkOut = sdf.parse(sc.next());

			if(!checkOut.after(checkIn))
				System.out.println("Erro de reserva: A data de checkOut deverá ser futura da data de checkIn.");
			else {
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation: "+ reservation);
				System.out.println("Entre com os dados da reserva atualizada: ");
				System.out.print("CheckIn data: ");
				checkIn = sdf.parse(sc.next());
				System.out.print("CheckOut data: ");
				checkOut = sdf.parse(sc.next());
				
				Date now = new Date();
				
				if(checkOut.before(now) || checkIn.before(now) ) {
					System.out.println("Erro de reserva: As reservas devem ser futuras do que as anteriores");	
				}	
				else if(!checkOut.after(checkIn)) {
					System.out.println("Erro de reserva: A data de checkOut deverá ser futura da data de checkIn.");
				}
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: "+ reservation);
			}

			sc.close();
		}

	}

