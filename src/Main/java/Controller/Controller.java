package Controller;


import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Controller
{
    private TicketDB ticketDB;
    private UserDB userDB;
    public Controller(TicketDB ticketDB, UserDB userDB){
        this.ticketDB = ticketDB;
        this.userDB = userDB;
    }

    public Ticket createAirplaneTicket(TicketFactory ticketFactory, String description, String users, int value, String purchaseDate, boolean splitEvenly)
    {
        HashMap<User, Integer> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket", description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createConcertTicket(TicketFactory ticketFactory,String description, String users, int value, String purchaseDate, boolean splitEvenly)
    {
        HashMap<User, Integer> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("ConcertTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createOtherTicket(TicketFactory ticketFactory,String description, String users, int value, String purchaseDate, boolean splitEvenly)
    {
        HashMap<User, Integer> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("OtherTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createRestaurantTicket(TicketFactory ticketFactory,String description, String users, int value, String purchaseDate, boolean splitEvenly)
    {
        HashMap<User, Integer> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("RestaurantTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }
    public Ticket createTaxiTicket(TicketFactory ticketFactory,String description, String users, int value, String purchaseDate, boolean splitEvenly)
    {
        HashMap<User, Integer> userObjects = stringUsersToObjects(users);
        Ticket ticket = ticketFactory.makeTicket("TaxiTicket",description, userObjects, value,purchaseDate,splitEvenly);
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }

    private HashMap<User, Integer> stringUsersToObjects(String users){
        String[] splitUsersAndMoney = users.split("; ");
        HashMap<User, Integer> userObjects = new HashMap<>();
        ArrayList<String> userNotFound = new ArrayList<>();
        for(String u : splitUsersAndMoney){
            String splitUser = u.split(":")[0];
            Integer splitMoney = Integer.parseInt(u.split(":")[1]);
            User userTemp = userDB.getUser(splitUser.hashCode());
            if(userTemp != null){
                userObjects.put(userTemp,splitMoney);
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
