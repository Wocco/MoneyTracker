package Tickets;

import java.util.Date;

public class OtherTicket extends Ticket {
    public OtherTicket(String description, int value, Date purchaseDate, boolean splitEvenly){
        super(description, value, purchaseDate, splitEvenly);
    }
}
