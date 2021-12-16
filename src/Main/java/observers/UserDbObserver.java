package observers;

import Controller.Controller;
import Database.UserDB;
import GUI.GUI;
import User.User;

import java.beans.PropertyChangeEvent;



public class UserDbObserver implements Observer{
    private GUI gui;
    private Controller controller;

    public UserDbObserver(GUI gui, Controller controller) {
        this.gui = gui;
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

        System.out.println("User got updated!");
        gui.updateUser(controller);
    }
}
