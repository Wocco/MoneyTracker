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

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Controller
{
    private TicketDB ticketDB;
    private UserDB userDB;
    public Controller(TicketDB ticketDB, UserDB userDB){
        this.ticketDB = ticketDB;
        this.userDB = userDB;

    }

    public Ticket createTicket(TicketFactory ticketFactory,String ticketType, String description, String users, double value, String purchaseDate, int splitEvenly)
    {
        HashMap<User, Double> userObjects = stringUsersToObjects(users);
        if(splitEvenly == 1) {
            Ticket ticket = ticketFactory.makeTicket(ticketType, description, userObjects, value, purchaseDate, splitEvenly);
        }
        ticketDB.addTicket(description.hashCode(),ticket);
        return ticket;
    }

    public ArrayList<Ticket> getAllTickets(){
        return ticketDB.getAllTickets();
    }

    public void addUser(String name){
        User newUser = new User(name);
        userDB.addUser(name.hashCode(), newUser);
    }

    public void removeUser(Integer hashvalue){
        userDB.removeUser(hashvalue);
    }

    public ArrayList<String> getUserNames(){
        return userDB.getUserNames();
    }

    private HashMap<User, Double> stringUsersToObjects(String users){
        String[] splitUsersAndMoney = users.split(";");
        HashMap<User, Double> userObjects = new HashMap<>();
        ArrayList<String> userNotFound = new ArrayList<>();
        for(String u : splitUsersAndMoney){
            String splitUser = u.split(":")[0];
            Double splitMoney = parseDouble(u.split(":")[1]);
            User userTemp = userDB.getUser(splitUser.hashCode());
            if(userTemp != null){
                userObjects.put(userTemp,splitMoney);
            }else{
                userNotFound.add(splitUser);
            }
        }
        if(!userNotFound.isEmpty()) {
            System.out.println("Database error! Users that couldn't be found: " + userNotFound);
        }
        return userObjects;
    }




}
