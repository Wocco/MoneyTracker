package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JPanel MainPanel;
    private JTabbedPane Tabbedpane;
    private JLabel welcomeTextField;
    private JComboBox comboBoxAddTicket;

    /**
     * Actions for all the buttons
     */

    public GUI()
    {

        comboBoxAddTicket.addItem("AirplaneTicket");
        comboBoxAddTicket.addItem("TaxiTicket");
        comboBoxAddTicket.addItem("ConcertTicket");
        comboBoxAddTicket.addItem("OtherTicket");
        comboBoxAddTicket.addItem("RestaurantTicket");

    }



    /**
     * Initialize the gui
     *
     */
    public void app()
    {
        JFrame frame = new JFrame("Money tracker");
        frame.setContentPane(new GUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
