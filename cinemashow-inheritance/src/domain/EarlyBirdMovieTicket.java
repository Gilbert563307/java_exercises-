package domain;

public class EarlyBirdMovieTicket extends MovieTicket{

    private final double DISCOUNT = 10;
    private final double MAX_DISCOUNT = 100;

    /**
     * constructor
     *
     * @param show     The CinemaShow for the ticket
     * @param customer The customer reserving the ticket
     * @param rowNr    The row number of the seat
     * @param seatNr   the seatnumer of the seat
     */
    public EarlyBirdMovieTicket(CinemaShow show, Customer customer, int rowNr, int seatNr) {
        super(show, customer, rowNr, seatNr);
    }

    /**
     * Returns the price for an earlyBird ticket
     *
     * @return the calculated earlybird price
     */
    @Override
    public double calcPrice() {
        return super.calcPrice() * ((this.MAX_DISCOUNT - this.DISCOUNT)/this.MAX_DISCOUNT);
    }
}
