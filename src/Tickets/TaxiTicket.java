package Tickets;

import java.util.Date;

public class TaxiTicket extends Ticket{
    public TaxiTicket(String description, int value, Date purchaseDate, boolean splitEvenly){
        super(description, value, purchaseDate, splitEvenly);
    }
}
