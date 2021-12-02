package Tickets;

import java.util.Date;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(String description, int value, Date purchaseDate, boolean splitEvenly){
        super(description, value, purchaseDate, splitEvenly);
    }
}
