package Controller;


import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Double.parseDouble;


public class Controller
{
    private TicketDB ticketDB;
    private UserDB userDB;
    private TicketFactory ticketFactory;
    public Controller(TicketDB ticketDB, UserDB userDB, TicketFactory ticketFactory){
        this.ticketDB = ticketDB;
        this.userDB = userDB;
        this.ticketFactory = ticketFactory;
    }

    public Ticket createTicket(String ticketType, String description, String users, double value, String purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = null;
        String userString = "";
        if(splitEvenly) {
            String[] splittedUsers = users.split(";");
            int addedUsers = splittedUsers.length;
            userString = splittedUsers[0]+(-(value*(addedUsers-1))/addedUsers)+";";

            for(int i=1; i<addedUsers;i++){
                userString = userString+splittedUsers[i]+":"+(value/addedUsers)+";";
            }
        }else {
            String[] otherUsers = users.split(":;")[1].split(";");
            Double firstUserValue = 0.0;
            for(String usr : otherUsers){
                firstUserValue = firstUserValue + parseDouble(usr.split(":")[1]);
            }
            String firstUser = users.split(":;")[0]+":"+(-firstUserValue)+";";
            userString = firstUser + users.split(":;")[1];
        }
        HashMap<User, Double> userObjects = stringUsersToObjects(userString);
        ticket = ticketFactory.makeTicket(ticketType, description, userObjects, value, purchaseDate, splitEvenly);
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

    public ArrayList<User> getUsers(){
        return userDB.getUsers();
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
