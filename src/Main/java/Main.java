import Controller.Controller;
import Database.TicketDB;
import Database.UserDB;
import GUI.GUI;
import Tickets.TicketFactory;
import User.User;
import observers.Observer;
import observers.TicketDbObserver;
import observers.UserDbObserver;

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
        //Making the observers observing the databases
        Observer userDBObserver = new UserDbObserver(gui,controller);
        Observer ticketDBObserver = new TicketDbObserver(gui,controller);
        userDB.add(userDBObserver);
        ticketDB.add(ticketDBObserver);
        gui.app(gui);

    }
}
