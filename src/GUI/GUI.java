package GUI;

import Controller.Controller;
import Tickets.TicketFactory;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GUI {

    private JPanel MainPanel;
    private JTabbedPane Tabbedpane;
    private JLabel welcomeTextField;
    private JComboBox comboBoxAddTicket;
    private JLabel TicketOptionsLabel;
    private JTextField PriceOfTicketField;
    private JLabel priceLabel;
    private JComboBox comboBoxSplitEven;
    private JLabel splitEvenLabel;
    private JButton addTicketButton;


    private Controller controller;
    private TicketFactory factory;
    /**
     * Actions for all the buttons
     */

    public GUI(Controller controller, TicketFactory factory)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime now = LocalDateTime.now();


        // addticket
        //combobox kind of ticker
        comboBoxAddTicket.addItem("AirplaneTicket");
        comboBoxAddTicket.addItem("TaxiTicket");
        comboBoxAddTicket.addItem("ConcertTicket");
        comboBoxAddTicket.addItem("OtherTicket");
        comboBoxAddTicket.addItem("RestaurantTicket");
        //combobox split evenly or not
        comboBoxSplitEven.addItem("Split evenly");
        comboBoxSplitEven.addItem("Do not split");
        /**
         * Listener for send button when a ticket is added.
         */
        addTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTicket = (String) comboBoxAddTicket.getSelectedItem();
                String splitEven = (String) comboBoxSplitEven.getSelectedItem();
                boolean splitEventrueorfalse;

                if (splitEven.equals("Split evenly"))
                {
                    splitEventrueorfalse = true;
                }
                else
                {
                    splitEventrueorfalse = false;
                }
                switch (selectedTicket)
                {
                    case "AirplaneTicket":
                        controller.createAirplaneTicket(factory,"test",(Integer.parseInt(PriceOfTicketField.getText())),new Date(""),splitEventrueorfalse); //create an airplane ticket
                }
            }
        });
    }



    /**
     * Initialize the gui
     *
     */
    public void app()
    {
        JFrame frame = new JFrame("Money tracker");
        frame.setContentPane(new GUI(controller, factory).MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
