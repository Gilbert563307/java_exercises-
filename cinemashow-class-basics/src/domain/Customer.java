package domain;

import java.util.*;

/**
 * class that represents the customer buying tickets for a CinameShow
 */
public class Customer {

	private final Collection<MovieTicket> tickets;
	private final String emailAddres;

	/**
	 * Adds a reserved ticket to the customer
	 *
	 * @param ticket the ticket that needs to be added
	 */
	public void addTicket(MovieTicket ticket) {
		this.tickets.add(ticket);
	}

	/**
	 * Constructor
	 *
	 * @param emailAddres the email address of the customer
	 */
	public Customer(String emailAddres) {
		this.tickets = new ArrayList<>();
		this.emailAddres = emailAddres;
	}

	/**
	 * Returns a String representation of the Object
	 *
	 * @return the object string
	 */
	@Override
	public String toString() {
		return "Customer{" +
				"ticket=" + tickets +
				", emailAddres='" + emailAddres + '\'' +
				'}';
	}
}