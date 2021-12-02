package Controller;


import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import java.util.Date;

public class Controller
{
    private TicketDB ticketDB;
    private UserDB userDB;
    public Controller(TicketDB ticketDB, UserDB userDB){
        this.ticketDB = ticketDB;
        this.userDB = userDB;
    }

    public Ticket createAirplaneTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket",description,value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createConcertTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("ConcertTicket",description,value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createOtherTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("OtherTicket",description,value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createRestaurantTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("RestaurantTicket",description,value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createTaxiTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("TaxiTicket",description,value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }

}
