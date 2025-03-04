package domain;

public class MovieTicket {

	Customer customer;
	CinemaShow show;
	private int rowNr;
	private int seatNr;

	/**
	 * constructor
	 *
	 * @param show	The CinemaShow for the ticket
	 * @param customer The customer reserving the ticket
	 * @param rowNr The row number of the seat
	 * @param seatNr the seatnumer of the seat
	 */
	public MovieTicket(CinemaShow show, Customer customer, int rowNr, int seatNr) {
		this.show = show;
		this.customer = customer;
		this.rowNr = rowNr;
		this.seatNr = seatNr;
	}

	/**
	 * Returns the  price for a ticket
	 *
	 * @return price of a ticket
	 */
	public double calcPrice() {
		return this.show.calcPlacePrice();
	}

	/**
	 * Returns a String representation of the Object
	 *
	 * @return the object string
	 */
	@Override
	public String toString() {
		return "MovieTicket{" +
				"show=" + show +
				", rowNr=" + rowNr +
				", seatNr=" + seatNr +
				", price=" + calcPrice() +
				'}';
	}
}