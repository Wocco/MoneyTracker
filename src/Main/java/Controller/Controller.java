package Controller;


import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;

import java.lang.reflect.Array;
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

    public Ticket createAirplaneTicket(TicketFactory ticketFactory, String description, String users, int value, Date purchaseDate, boolean splitEvenly)
    {
        ArrayList<User> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket", description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createConcertTicket(TicketFactory ticketFactory,String description, String users, int value, Date purchaseDate, boolean splitEvenly)
    {
        ArrayList<User> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("ConcertTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createOtherTicket(TicketFactory ticketFactory,String description, String users, int value, Date purchaseDate, boolean splitEvenly)
    {
        ArrayList<User> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("OtherTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createRestaurantTicket(TicketFactory ticketFactory,String description, String users, int value, Date purchaseDate, boolean splitEvenly)
    {
        ArrayList<User> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("RestaurantTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createTaxiTicket(TicketFactory ticketFactory,String description, String users, int value, Date purchaseDate, boolean splitEvenly)
    {
        ArrayList<User> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("TaxiTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }

    private ArrayList<User> stringUsersToObjects(String users){
        String[] splitUsers = users.split("; ");
        ArrayList<User> userObjects = new ArrayList<>();
        ArrayList<String> userNotFound = new ArrayList<>();
        for(String u : splitUsers){
            User userTemp = userDB.getUser(u.hashCode());
            if(userTemp != null){
                userObjects.add(userTemp);
            }else{
                userNotFound.add(u);
            }
        }
        if(!userNotFound.isEmpty()) {
            System.out.println("Database error! Users that couldn't be found: " + userNotFound.toString());
        }
        return userObjects;
    }


}
