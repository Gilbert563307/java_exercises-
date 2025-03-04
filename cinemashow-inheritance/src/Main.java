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

        //second cinema show
        CinemaShow blackPantherShow = new CinemaShow("Black panther", movieDay.plusDays(1), 20);


        // Reserve tickets
        MovieTicket movieTicket = cinemaShow.reserveTicket(customer, false);
        if (movieTicket != null) {
            customer.addTicket(movieTicket);
        }


        //Pas de code aan door een ander soort kaartje te introduceren dat je afleid van de gegeven interface.

        //resever black panther tickets
        MovieTicket secondMovieTicket = blackPantherShow.reserveTicket(customer, true);
        if (secondMovieTicket != null) {
            customer.addTicket(secondMovieTicket);
        }

        System.out.println(customer.toString());
    }
}
