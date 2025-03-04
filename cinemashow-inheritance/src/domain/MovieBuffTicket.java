package domain;

public class MovieBuffTicket extends MovieTicket{

    private final double DISCOUNT = 5;
    private final double MAX_DISCOUNT = 100;

    /**
     * constructor
     *
     * @param show     The CinemaShow for the ticket
     * @param customer The customer reserving the ticket
     * @param rowNr    The row number of the seat
     * @param seatNr   the seatnumer of the seat
     */
    public MovieBuffTicket(CinemaShow show, Customer customer, int rowNr, int seatNr) {
        super(show, customer, rowNr, seatNr);
    }

    /**
     * Returns the price for an movieBuff ticket
     *
     * @return the calculated movieBuff price
     */
    @Override
    public double calcPrice() {
        return super.calcPrice() * ((this.MAX_DISCOUNT - this.DISCOUNT)/this.MAX_DISCOUNT);
    }
}
