package Tickets;

public class TicketFactory {
    public TicketFactory(){}
    public Ticket makeTicket(String ticketKind, String description, int value, boolean splitEvenly){
        switch(ticketKind){
            case "AirplaneTicket":
                return new AirplaneTicket(description, value, splitEvenly);
            case "RestaurantTicket":
                return new RestaurantTicket(description, value, splitEvenly);
            case "ConcertTicket":
                return new ConcertTicket(description, value, splitEvenly);
            case "OtherTicket":
                return new OtherTicket(description, value, splitEvenly);
            default:
                return null;
        }
    }
}
