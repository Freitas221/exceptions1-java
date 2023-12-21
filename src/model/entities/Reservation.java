package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy");

	public Reservation(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}


	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkOut.before(now) || checkIn.before(now) ) {
			 throw new IllegalArgumentException("Erro de reserva: As reservas devem ser futuras do que as anteriores");	
		}	
		if(!checkOut.after(checkIn)) {
	    	throw new IllegalArgumentException("Erro de reserva: A data de checkOut deverá ser futura da data de checkIn.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+numQuarto
				+", checkIn "
				+sdf.format(checkIn)
				+", checkOut "
				+sdf.format(checkOut)
				+duration()
				+" nights";
				
	}
	
}

