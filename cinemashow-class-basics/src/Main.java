import domain.CinemaShow;
import domain.Customer;
import domain.MovieTicket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;

public class Main {
    public static void main(String[] args) {

        // Create customer
        Customer customer = new Customer("name@domain.com");

        // Pas de code in main aan zodat er meerdere voorstellingen zijn en meerdere
        // klanten die kaartjes kopen.
        Customer customer2 = new Customer("John@domain.com");
        Customer customer3 = new Customer("James@domain.com");

        // Create CinemaShow
        LocalDate movieDay = LocalDate.now().plusDays(8);
        CinemaShow cinemaShow = new CinemaShow("Dune", movieDay, 200);

        CinemaShow cinemaShow2 = new CinemaShow("Avatar", movieDay, 50);
        CinemaShow cinemaShow3 = new CinemaShow("LOK", movieDay, 60);
        CinemaShow cinemaShow4 = new CinemaShow("Nemo", movieDay, 100);

        // Reserve tickets
        MovieTicket movieTicket = cinemaShow.reserveTicket(customer);
        if (movieTicket != null) {
            customer.addTicket(movieTicket);
        }

        // Pas de code in main aan zodat er meerdere voorstellingen zijn en meerdere
        // klanten die verschillende kaartjes kopen.
        HashMap<Customer, CinemaShow> customers_and_Shows = new HashMap<Customer, CinemaShow>() {{
            put(customer2, cinemaShow2);
            put(customer3, cinemaShow3);
        }};

        for (Customer c : customers_and_Shows.keySet()){

            CinemaShow cinema = customers_and_Shows.get(c);
            MovieTicket mticket = cinema.reserveTicket(c);

            if (mticket != null) {
                c.addTicket(mticket);
            }

        }

        // System.out.println(customer.toString());

        for (Customer c : customers_and_Shows.keySet()) {
          System.out.println(c.toString());
        }

        // Pas de code in main aan zodat er in de console een meer aantrekkelijke output
        // komt van welke klant welke kaartjes heeft voor welke voorstelling.

    }
}
