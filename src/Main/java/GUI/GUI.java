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
import java.util.Calendar;
import java.util.Date;

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
    private JPanel userAddPanelSuccesOrNot;
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
                int splitEvenOrUneven=-10;

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

                String userString = namePayerField.getText()+":"+"-"+PriceOfTicketField.getText()+";";

                if(splitNamesField!=null && splitEvenOrUneven==1)                                       //splitting even
                {
                    String[] splitUsersfield = splitNamesField.getText().split(";");
                    if(splitEvenOrUneven==1){
                        Integer price = parseInt(PriceOfTicketField.getText())/(splitUsersfield.length+1);
                        for(String u : splitUsersfield)
                        {
                            userString = userString + u +":"+price+";";
                        }
                    }
                }
                /***
                 * @// FIXME: 11/12/2021 
                 */
                if(splitNamesField!=null && splitEvenOrUneven==-1)                                       //splitting uneven
                {
                    String[] splitUsersfield = splitNamesField.getText().split(";");
                    if(splitEvenOrUneven==-1){

                        int percentagecheck=0;
                        for(String u : splitUsersfield)
                        {
                            String[] getPercentage = u.split(":");
                            int percentage = parseInt(getPercentage[1]);
                            percentagecheck = percentagecheck+percentage;
                            
                            Integer price = (parseInt(PriceOfTicketField.getText())*(percentage/100));
                            userString = userString + getPercentage[0] +":"+price+";";
                        }
                    }
                    //System.out.println(userString);

                }




                System.out.println(userString);

                switch (selectedTicket)
                {
                    case "AirplaneTicket":
                        controller.createAirplaneTicket(factory,descriptionField.getText(),userString,(parseInt(PriceOfTicketField.getText())),dt,splitEvenOrUneven); //create an airplane ticket

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
