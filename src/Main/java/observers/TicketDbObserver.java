package observers;

import Controller.Controller;
import GUI.GUI;

import java.beans.PropertyChangeEvent;

public class TicketDbObserver implements Observer{
    private GUI gui;
    private Controller controller;

    public TicketDbObserver(GUI gui, Controller controller) {
        this.gui = gui;
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        gui.updateTicket(controller);
    }
}
