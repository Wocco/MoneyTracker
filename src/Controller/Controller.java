package Controller;

import Tickets.Ticket;
import Tickets.TicketFactory;

import java.util.Date;

public class Controller
{
    public Ticket createAirplaneTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }
    public Ticket createConcertTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("ConcertTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }
    public Ticket createOtherTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("OtherTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }
    public Ticket createRestaurantTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("RestaurantTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }
    public Ticket createTaxiTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("TaxiTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }

}
