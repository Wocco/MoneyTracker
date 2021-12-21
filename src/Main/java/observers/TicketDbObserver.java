package observers;

import Controller.Controller;
import GUI.GUI;

import java.beans.PropertyChangeEvent;

public class TicketDbObserver implements Observer{
    private GUI gui;
    private Controller controller;

    /**
     * @function constructor of TicketDBObsersver
     * @param gui
     * @param controller
     */
    public TicketDbObserver(GUI gui, Controller controller) {
        this.gui = gui;
        this.controller = controller;
    }

    /**
     * @function when something changes in the ticketDB this function gets called
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        gui.updateTicket(controller);
        gui.updateUser(controller);
    }
}
