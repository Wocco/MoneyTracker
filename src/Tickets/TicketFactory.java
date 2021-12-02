package Tickets;

import java.util.Date;

public class TicketFactory {
    public TicketFactory(){}
    public Ticket makeTicket(String ticketKind, String description, int value, Date purchaseDate, boolean splitEvenly){
        switch(ticketKind){
            case "AirplaneTicket":
                return new AirplaneTicket(description, value, purchaseDate, splitEvenly);
            case "RestaurantTicket":
                return new RestaurantTicket(description, value, purchaseDate, splitEvenly);
            case "ConcertTicket":
                return new ConcertTicket(description, value, purchaseDate, splitEvenly);
            case "OtherTicket":
                return new OtherTicket(description, value, purchaseDate, splitEvenly);
            default:
                return null;
        }
    }
}
