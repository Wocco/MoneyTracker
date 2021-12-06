package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    /**
     * Actions for all the buttons
     */

    public GUI()
    {
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
        frame.setContentPane(new GUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
