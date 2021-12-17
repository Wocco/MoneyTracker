package observers;

import Controller.Controller;
import Database.UserDB;
import GUI.GUI;
import User.User;

import java.beans.PropertyChangeEvent;



public class UserDbObserver implements Observer{
    private GUI gui;
    private Controller controller;

    /**
     * @function constructor of UserDbObserver
     * @param gui
     * @param controller
     */
    public UserDbObserver(GUI gui, Controller controller) {
        this.gui = gui;
        this.controller = controller;
    }

    /**
     * @function when something changes in ticketDB this function gets called
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

        System.out.println("User got updated!");
        gui.updateUser(controller);
    }
}
