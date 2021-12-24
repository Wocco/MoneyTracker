package Tests;

import Controller.Controller;
import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MakingUsersTicket_UTest {
    TicketDB ticketDB = TicketDB.getInstance();
    UserDB userDB = UserDB.getInstance();
    TicketFactory ticketFactory = new TicketFactory();
    Controller controller = new Controller(ticketDB,userDB,ticketFactory);
    public MakingUsersTicket_UTest()
    {

    }

    @Before
    public void initialize()
    {

    }

    @Test
    public void t_Users() throws Exception
    {
        controller.addUser("User1");
        controller.addUser("User2");
        controller.addUser("User3");
        ArrayList<User> users = controller.getUsers();
        for(User u : users){
            System.out.println("Username: "+u.getName()+"\nTickets: "+u.getTickets()+"\nBalance: "+u.getMoneyBalance());
            assertEquals("Testing user creation - should return 0.0 as money balance.", new Double(0.0), u.getMoneyBalance());
        }
        System.out.println("\n\n");
    }

    @Test
    public void t_Tickets() throws Exception
    {
        Ticket ticket1 = controller.createTicket("AirplaneTicket","airplane","User1:;User2",100.0,"25/12/2021",true);
        controller.createTicket("ConcertTicket","concert","User2:;User1",100.0,"25/12/2021",true);
        ArrayList<Ticket> tickets = controller.getAllTickets();
        for(Ticket t : tickets){
            System.out.println("Description: "+t.getDescription()+"\nUsers: "+t.getUsers()+"\nPrice: "+t.getValue());
        }

        controller.removeTicket(ticket1.getHashValue());
        ArrayList<Ticket> ticketsafterdel = controller.getAllTickets();
        assertEquals("Testing ticket creation - should return false.", false, ticketsafterdel.containsAll(tickets));
    }
}
