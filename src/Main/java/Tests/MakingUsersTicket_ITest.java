package Tests;

import Controller.Controller;
import Database.TicketDB;
import Database.UserDB;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MakingUsersTicket_ITest {
    TicketDB ticketDB = TicketDB.getInstance();
    UserDB userDB = UserDB.getInstance();
    TicketFactory ticketFactory = new TicketFactory();
    Controller controller = new Controller(ticketDB,userDB,ticketFactory);

    public MakingUsersTicket_ITest()
    {
    }

    @Before
    public void initialize()
    {
        controller.addUser("User1");
        controller.addUser("User2");
        controller.addUser("User3");
    }

    @Test
    public void t_TicketUserTest() {
        Ticket ticket = controller.createTicket("AirplaneTicket", "test", "User1:;User2;User3", 150.00, "25/12/2021", true);
        ArrayList<Ticket> tickets = controller.getAllTickets();
        assertEquals("Testing ticket creation - should return true", true, tickets.contains(ticket));

        ArrayList<User> users = controller.getUsers();
        controller.removeUser("User2".hashCode());
        ArrayList<User> usersafterdel = controller.getUsers();
        assertEquals("Testing user deletion - should return false", false, usersafterdel.equals(users));

        users.removeAll(usersafterdel);
        assertEquals("Testing user deletion - should return 'User2'", "User2", users.get(0).getName());

        controller.removeTicket(ticket.getHashValue());
        ArrayList<Ticket> ticketsafterdel = controller.getAllTickets();
        assertEquals("Testing user deletion - should return false", false, ticketsafterdel.contains(ticket));
    }
}