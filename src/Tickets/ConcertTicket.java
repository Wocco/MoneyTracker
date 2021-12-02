package Tickets;

import java.util.Date;

public class ConcertTicket extends Ticket{
    public ConcertTicket(String description, int value, Date purchaseDate, boolean splitEvenly){
        super(description, value, purchaseDate, splitEvenly);
    }
}
