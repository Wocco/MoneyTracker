package Controller;


import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class Controller
{
    private TicketDB ticketDB;
    private UserDB userDB;
    public Controller(TicketDB ticketDB, UserDB userDB){
        this.ticketDB = ticketDB;
        this.userDB = userDB;
    }

    public Ticket createAirplaneTicket(TicketFactory ticketFactory, String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket", description, users, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createConcertTicket(TicketFactory ticketFactory,String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("ConcertTicket",description, users, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createOtherTicket(TicketFactory ticketFactory,String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("OtherTicket",description, users, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createRestaurantTicket(TicketFactory ticketFactory,String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("RestaurantTicket",description, users, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createTaxiTicket(TicketFactory ticketFactory,String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("TaxiTicket",description, users, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }

}
