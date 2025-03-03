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

	/**
	 * Constructor
	 *
	 * @param title Title of the movie
	 * @param movieDate date of the movie
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
	 * Returns a MovieTicket if there are still tickets available, otherwise returns null
	 *
	 * @param customer The customer reserving the ticket
	 * @return MovieTicket | null
	 */
	public MovieTicket reserveTicket(Customer customer) {
		// Make sure there are tickets available
		if (this.nrOfAvailablePlaces > 0) {
			// Create a new MovieTicket
			MovieTicket movieTicket = new MovieTicket(this, customer, 1, 1);
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