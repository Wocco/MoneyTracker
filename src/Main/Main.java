package Main;

import Controller.Controller;
import Database.TicketDB;
import Database.UserDB;
import GUI.GUI;
import Tickets.TicketFactory;

public class Main
{

    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main() {
    }

    public void run()
    {
        TicketDB ticketDB = new TicketDB();
        UserDB userDB = new UserDB();
        Controller controller = new Controller(ticketDB,userDB);
        TicketFactory factory = new TicketFactory();
        GUI gui = new GUI(controller,factory);
        gui.app();

    }
}
