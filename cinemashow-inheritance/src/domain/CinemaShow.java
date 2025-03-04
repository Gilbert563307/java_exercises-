package domain;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class CinemaShow {

	Collection<MovieTicket> tickets;
	private final String title;
	private int nrOfAvailablePlaces;
	private LocalDate movieDate;
	private static final int EARLYBIRD_DAY_COUNT = 7;
	private static final double PLACEPRICE = 25;
	private Boolean isCinemaShowGifted = false;

	/**
	 * Returns a MovieTicket if there are still tickets available, otherwise returns
	 * null
	 *
	 * @param customer The customer reserving the ticket
	 * @return MovieTicket | null
	 */
	public MovieTicket reserveTicket(Customer customer, Boolean isCinemaShowGifted) {
		if (isCinemaShowGifted) {
			System.out.println("here i am");
			this.isCinemaShowGifted = true;
		}

		// Make sure there are tickets available
		if (this.nrOfAvailablePlaces > 0) {
			// Create a new MovieTicket
			MovieTicket movieTicket = this.determinTicketKind(customer);
			// Add the ticket to the collection and reduce the available tickets
			this.tickets.add(movieTicket);
			this.nrOfAvailablePlaces--;
			// return the movieticket
			return movieTicket;
		} else {
			return null;
		}
	}

	/**
	 * Returns a MovieTicket variant applicable to the situation
	 *
	 * @param customer The customer reserving the ticket
	 * @return MovieTicket | null
	 */
	private MovieTicket determinTicketKind(Customer customer) {

		if (this.isCinemaShowGifted) {
			System.out.println("Gifted");
			return new GiftMovieTicket(this, customer, 1, 1);
		}

		// If the current date is EARLYBIRD_DAY_COUNT days before the show, an early
		// bird ticket is applicable
		if (this.isEarlyBird()) {
			System.out.println(("earlybird"));
			return new EarlyBirdMovieTicket(this, customer, 1, 1);
		}
		// If the customer is a MovieBuff, a MovieBuff ticket is applicable
		if (customer.isMovieBuff()) {
			System.out.println(("MovieBuff"));
			return new MovieBuffTicket(this, customer, 1, 1);
		}

		// Otherwise a standard ticket is applicable
		System.out.println(("Normal"));
		return new MovieTicket(this, customer, 1, 1);
	}

	/**
	 * If the reservation date (now) is EARLYBIRD_DAY_COUNT days prior to the show
	 * date, it is an earlybird ticket
	 * 
	 * @return true | false
	 */
	private boolean isEarlyBird() {
		// Get the date of today +EARLYBIRD_DAY_COUNT days
		LocalDate earlyBirdDate = LocalDate.now().plusDays(EARLYBIRD_DAY_COUNT);

		return earlyBirdDate.isBefore(this.movieDate);
	}

	/**
	 * Constructor
	 *
	 * @param title      Title of the movie
	 * @param movieDate  date of the movie
	 * @param nrOfPlaces The numer of seats availabel in the theater
	 */
	public CinemaShow(String title, LocalDate movieDate, int nrOfPlaces) {
		// Initialize the tickets list
		this.tickets = new ArrayList<>();
		// copy the parameters
		this.title = title;
		this.movieDate = movieDate;
		this.nrOfAvailablePlaces = nrOfPlaces;
	}

	/**
	 * Sets a new time for the show, but must be on the same day
	 *
	 * @param newDate the new date
	 */
	public void setMovieDate(LocalDate newDate) {

		// If the day is the same this is allowed
		if (newDate.getDayOfYear() == this.movieDate.getDayOfYear()) {
			this.movieDate = newDate;
		}
	}

	/**
	 * Returns the standard price of a place in the cinema for this show
	 *
	 * @return the price for a place
	 */
	public double calcPlacePrice() {
		return PLACEPRICE;
	}

	/**
	 * returns the current date for the show
	 *
	 * @return the date for the show
	 */
	public LocalDate getDate() {
		return movieDate;
	}

	/**
	 * Returns a String representation of the Object
	 *
	 * @return the object string
	 */
	@Override
	public String toString() {
		return "CinemaShow{" +
				"title='" + title + '\'' +
				", nrOfAvailablePlaces=" + nrOfAvailablePlaces +
				", date=" + movieDate +
				'}';
	}
}