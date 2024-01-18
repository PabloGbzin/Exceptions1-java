package model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {	
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	/*
	public Integer duration1() {
		
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal.setTime(checkIn);
		cal2.setTime(checkOut);
		
		int dayCheckin = cal.get(Calendar.DAY_OF_MONTH);
		int dayCheckout = cal2.get(Calendar.DAY_OF_MONTH);
		
		int count = 0;
		for(int i = dayCheckin; i < dayCheckout; i++) {
			count += 1;
		}
		
		return count;
	}
	*/
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room "
			  + roomNumber
			  + ", chek-in: "
			  + sdf1.format(checkIn)
			  + ", check-out: "
			  + sdf1.format(checkOut)
			  + ", "
			  + duration()
			  + " nights";
	}
	
}
