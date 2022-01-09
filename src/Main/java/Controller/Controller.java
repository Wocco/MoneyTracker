package Controller;


import Database.TicketDB;
import Database.UserDB;
import GUI.DarkTheme;
import GUI.LightTheme;
import GUI.ThemeContext;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Double.parseDouble;


public class Controller
{
    private ThemeContext themeContext = new ThemeContext();
    private TicketDB ticketDB;
    private UserDB userDB;
    private TicketFactory ticketFactory;
    public Controller(TicketDB ticketDB, UserDB userDB, TicketFactory ticketFactory){
        this.ticketDB = ticketDB;
        this.userDB = userDB;
        this.ticketFactory = ticketFactory;
    }

    /**
     * @function create a ticket
     * @param ticketType can be an Airplaneticket,concertticket,...
     * @param description name of the ticket string
     * @param users users related to the ticket user
     * @param value price of the ticket double
     * @param purchaseDate Date of the purchase
     * @param splitEvenly split evenly or unevenly Boolean
     * @return
     */
    public Ticket createTicket(String ticketType, String description, String users, double value, String purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = null;
        String userString = "";
        int addedUsers = 0;
        if(splitEvenly) {
            String[] splittedUsers = users.split(";");
            addedUsers = splittedUsers.length;
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
            addedUsers = userString.length();
        }
        HashMap<User, Double> userObjects = stringUsersToObjects(userString);
        if(userObjects.size()==addedUsers) {
            ticket = ticketFactory.makeTicket(ticketType, description, userObjects, value, purchaseDate, splitEvenly);
            ticketDB.addTicket(description.hashCode(), ticket);
            return ticket;
        }else{
            return null;
        }
    }

    /**
     * @function get all the tickets from the ticketDB
     * @return Arraylist of all the tickets
     */
    public ArrayList<Ticket> getAllTickets(){
        return ticketDB.getAllTickets();
    }

    /**
     * @function add a user to the database
     * @param name name of the user
     */
    public void addUser(String name){
        User newUser = new User(name);
        userDB.addUser(name.hashCode(), newUser);
    }

    /**
     * @function remove a user from the database
     * @param hashvalue hash of the user
     */
    public void removeUser(Integer hashvalue){
        userDB.removeUser(hashvalue);
    }

    /**
     * @function remove a ticket from the database
     * @param hashvalue hash of the ticket
     */
    public void removeTicket(Integer hashvalue){
        ArrayList<User> users = userDB.getUsers();
        Ticket ticket = ticketDB.getTicket(hashvalue);
        HashMap<User, Double> userWithMoney = ticket.getUsers();
        for(User user : users ){
            if(user.getTickets().contains(hashvalue)){
                Double moneyOfTicket = userWithMoney.get(user);
                user.setMoneyBalance(-moneyOfTicket);

                user.removeTicket(hashvalue);
                user.printUser();
            }
        }
        if(ticketDB.removeTicket(hashvalue)==null){
            System.out.println("This ticket doesn't exist.");
        }
    }

    /**
     * @function get all the users
     * @return an arraylist with all the users
     */
    public ArrayList<User> getUsers(){
        return userDB.getUsers();
    }

    /**
     * @function Give money back to a user.
     */
    public void payBack(String user1, String user2, Double amount){
        User userr1 = userDB.getUser(user1.hashCode());
        User userr2 = userDB.getUser(user2.hashCode());
        if(userr1!=null && userr2!=null){
            userr1.setMoneyBalance(-amount);
            userr2.setMoneyBalance(amount);
        }else {
            System.out.println("One of the users doesn't exist.");
        }
    }

    /***
     * @function String users to object
     */
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

    public void setTheme(Boolean light){
        if(light){
            LightTheme lightTheme = new LightTheme();
            lightTheme.changeTheme(themeContext);
        }else{
            DarkTheme darkTheme = new DarkTheme();
            darkTheme.changeTheme(themeContext);
        }
    }
}
