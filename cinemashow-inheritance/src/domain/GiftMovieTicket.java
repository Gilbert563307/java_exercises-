package domain;

// Pas de code aan door een ander soort kaartje te introduceren dat je afleid van de gegeven interface.
public class GiftMovieTicket extends MovieTicket {

    private final double DISCOUNT = 100;
    private final double MAX_DISCOUNT = 100;

    public GiftMovieTicket(CinemaShow show, Customer customer, int rowNr, int seatNr) {
        super(show, customer, rowNr, seatNr);
    }

    /**
     * Returns the price for an movieBuff ticket
     *
     * @return the calculated movieBuff price
     */
    @Override
    public double calcPrice() {
        return super.calcPrice() * ((this.MAX_DISCOUNT - this.DISCOUNT) / this.MAX_DISCOUNT);
    }
}
