package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TicketFactory {
    public TicketFactory(){}
    public Ticket makeTicket(String ticketKind, String description, HashMap<User, Integer> users, int value, Date purchaseDate, boolean splitEvenly){
        Ticket ticket = null;
        switch(ticketKind){
            case "AirplaneTicket":
            case "airplaneticket":
                ticket = new AirplaneTicket(description, users, value, purchaseDate, splitEvenly);
                break;
            case "RestaurantTicket":
            case "restaurantticket":
                ticket =  new RestaurantTicket(description, users, value, purchaseDate, splitEvenly);
                break;
            case "ConcertTicket":
            case "concertticket":
                ticket =  new ConcertTicket(description, users, value, purchaseDate, splitEvenly);
                break;
            case "OtherTicket":
            case "otherticket":
                ticket = new OtherTicket(description, users, value, purchaseDate, splitEvenly);
                break;
            default:
                ticket = null;
                break;
        }
        for(User user : users.keySet()){
            user.addTicketToUser(ticket.getValue());
        }
        return ticket;
    }
}
