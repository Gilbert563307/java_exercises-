import domain.CinemaShow;
import domain.Customer;
import domain.MovieTicket;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Create customer
        Customer customer = new Customer("name@domain.com");

        // Create CinemaShow
        LocalDate movieDay = LocalDate.now().plusDays(8);
        CinemaShow cinemaShow = new CinemaShow("Dune", movieDay, 200);

        // Reserve tickets
        MovieTicket movieTicket = cinemaShow.reserveTicket(customer);
        if (movieTicket != null) {
            customer.addTicket(movieTicket);

        }

        System.out.println(customer.toString());
    }
}
