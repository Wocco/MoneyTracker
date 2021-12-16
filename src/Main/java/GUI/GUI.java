package GUI;

import Controller.Controller;
import Tickets.TicketFactory;
import com.toedter.calendar.JDateChooser;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

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

    //calender
    private JLabel CalenderLabel;
    private JPanel CalenderPanel;
    private JLabel DescriptionLabel;
    private JTextField descriptionField;
    private JLabel nameLabel;
    private JTextField namePayerField;
    private JLabel namesSplitlabel;
    private JTextField splitNamesField;
    private JLabel usernameLabelAdd;
    private JTextField userNameAddField;
    private JButton SendButtonAdd;
    private JButton removeButton;
    private JLabel personDeleteLabel;
    private JTextField nameToDeleteField;
    private JLabel usersOverviewAllUsersLabel;
    private JButton allUsersButon;
    private JLabel overviewTicketsLabel;
    private JLabel overviewTicketsLabelShowhere;
    private JButton refreshButtonOverviewTickets;
    private JLabel addPeopleSuccesOrNotLabel;
    private JLabel informationLabelRemove;
    private JButton removeTicketButton;
    private JTextField removeTicketTextField;
    private JLabel RemoveticketLabel;
    private JLabel explanationLabelAddTicket;
    private JLabel informationRemoveTicketLabel;
    private JButton viewTicketsButton;
    private JLabel NameOfTicketsLabel;
    private JLabel namesOfTicketsOverviewLabel;
    private JPanel userAddPanelSuccesOrNot;
    private JLabel userOverviewLabel;
    JDateChooser dateChooser = new JDateChooser();
    Calendar cld = Calendar.getInstance();

    private ModuleLayer.Controller controller;
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
        comboBoxSplitEven.addItem("Split unevenly");
        //calender
        dateChooser.setDateFormatString("dd/MM/yyyy");
        CalenderPanel.add(dateChooser);


        /**
         * Listener for send button when a ticket is added.
         */
        addTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calendar
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dt = simpleDateFormat.format(dateChooser.getDate());


                String selectedTicket = (String) comboBoxAddTicket.getSelectedItem();

                String splitEven = (String) comboBoxSplitEven.getSelectedItem();
                int splitEvenOrUneven;

                if (splitEven.equals("Split evenly"))
                {
                    splitEvenOrUneven = 1;
                }
                else if(splitEven.equals("Do not split"))
                {
                    splitEvenOrUneven = 0;
                }
                else
                {
                    splitEvenOrUneven = -1;
                }

                String userString = namePayerField.getText()+":"+"-"+(parseDouble(PriceOfTicketField.getText()))+splitNamesField.getText();

                if(splitNamesField!=null && splitEvenOrUneven==1)                                       //splitting even
                {
                    String[] splitUsersfield = splitNamesField.getText().split(";");
                    if(splitEvenOrUneven==1){
                        for(String u : splitUsersfield)
                        {
                            userString = userString + u +":"+price+";";
                        }
                    }
                }
                else if(splitNamesField!=null && splitEvenOrUneven == -1)                                       //splitting uneven
                {

                    userString = namePayerField.getText();
                    userString = userString+splitNamesField.getText();
                }
                else
                {
                    userString = namePayerField.getText();
                    userString=userString+":"+PriceOfTicketField.getText()+";";

                }



                switch (selectedTicket)
                {
                    case "AirplaneTicket":
                        controller.createTicket(factory,"AirplaneTicket",descriptionField.getText(),userString,(parseDouble(PriceOfTicketField.getText())),dt,splitEvenOrUneven); //create an airplane ticket

                }
            }
        });

        /**
         * @function Add a user
         * add button pressed -> A user should be added
         */
        SendButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(userNameAddField.getText().equals(null))
                {
                    System.out.println("No value added because no name was given");
                    addPeopleSuccesOrNotLabel.setText("No value added because no name was given");
                }
                else
                {
                    controller.addUser(userNameAddField.getText());
                    addPeopleSuccesOrNotLabel.setText(userNameAddField.getText()+" has been added to the list of people");
                }
            }
        });

        /***
         * @function remove a person
         */
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(nameToDeleteField.getText().equals(null))
                {
                    System.out.println("No name was given");
                    informationLabelRemove.setText("No name was given");
                }
                else
                {
                    controller.removeUser(nameToDeleteField.getText().hashCode());
                }
            }
        });



        /**
         * Remove a ticket
         */
        removeTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(removeTicketTextField.getText().equals(null))
                {
                    System.out.println("No ticket was given");
                    informationRemoveTicketLabel.setText("No Ticket was given");
                }
                else
                {
                    controller.removeUser(removeTicketTextField.getText().hashCode());
                    informationRemoveTicketLabel.setText("Removed ticket");
                }
            }
        });

        
    }


    public void updateUser(Controller controller)
    {
        //Update the user fields
        ArrayList<String> allusers = controller.getUserNames();
        userOverviewLabel.setText(allusers.toString());

    }

    public void updateTicket(Controller controller)
    {
        //update the tickets
        namesOfTicketsOverviewLabel.setText(controller.getAllTickets().toString());
    }

    /**
     * Initialize the gui
     *
     */
    public void app(GUI gui)
    {
        JFrame frame = new JFrame("Money tracker");
        frame.setContentPane(gui.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setVisible(true);
    }
}
