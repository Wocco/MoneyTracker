import Controller.Controller;
import Database.TicketDB;
import Database.UserDB;
import GUI.GUI;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import observers.Observer;
import observers.TicketDbObserver;
import observers.UserDbObserver;

import javax.swing.*;

public class Main
{
    /**
     * @function Main of the moneytrcker program
     * @param args
     */
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main() {
    }

    /**
     * @function runs the program
     */
    public void run()
    {
        TicketDB ticketDB = new TicketDB();
        UserDB userDB = new UserDB();
        TicketFactory ticketFactory = new TicketFactory();
        Controller controller = new Controller(ticketDB,userDB, ticketFactory);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        GUI gui = new GUI(controller);
        //Making the observers observing the databases
        Observer userDBObserver = new UserDbObserver(gui,controller);
        Observer ticketDBObserver = new TicketDbObserver(gui,controller);
        userDB.add(userDBObserver);
        ticketDB.add(ticketDBObserver);
        gui.app(gui);

    }
}
