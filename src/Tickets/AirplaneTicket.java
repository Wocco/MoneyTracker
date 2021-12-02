package Tickets;

import java.util.Date;

public class AirplaneTicket extends Ticket{
    public AirplaneTicket(String description, int value, Date purchaseDate, boolean splitEvenly){
        super(description, value, purchaseDate, splitEvenly);
    }
}
