package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	// Dando um formato padrão ao Date (Static para não precisar estanciar um
	// DateFormat para cada Obj Reservation.
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() { // long é o int mais longo. Uso para calcular datas
		long diff = checkOut.getTime() - checkIn.getTime(); // me devolve a diferença entre as datas em milisegundos.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte o valor diff em milesegundos para dia.
	}

	// fazendo um update da data usando como argumento o checkIn e o checkOut
	public String updateDates(Date checkIn, Date checkOut) {

		// (se checkIn ou checkOut forem antes que now faça).
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!(checkOut.after(checkIn))) {
			return "Check-out date must be after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // null para garantir que nenhum erro aconteca
	}

	@Override // Sempre usamos no toString pq é um caso de sobreposição qualquer
	public String toString() {
		return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
