package GUI;

import Bill.Bill;
import Controller.Controller;
import Tickets.Ticket;
import Tickets.TicketFactory;
import User.User;
import com.toedter.calendar.JDateChooser;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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
    private JLabel addPeopleSuccesOrNotLabel;
    private JLabel informationLabelRemove;
    private JButton removeTicketButton;
    private JTextField removeTicketTextField;
    private JLabel RemoveticketLabel;
    private JLabel explanationLabelAddTicket;
    private JLabel informationRemoveTicketLabel;
    private JButton viewTicketsButton;

    private JPanel userAddPanelSuccesOrNot;
    private JLabel userOverviewLabel;
    private JTable billTableOverview;
    private JPanel BillOverviewPanel;
    private JTable tableOverviewTickets;
    private JPanel OverviewPanel;
    JDateChooser dateChooser = new JDateChooser();
    Calendar cld = Calendar.getInstance();

    private ModuleLayer.Controller controller;
    private TicketFactory factory;


    /**
     * Actions for all the buttons
     */

    public GUI(Controller controller)
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
                boolean splitEvenOrUneven;

                if (splitEven.equals("Split evenly"))
                {
                    splitEvenOrUneven = true;
                }
                else
                {
                    splitEvenOrUneven = false;
                }

                String userString = namePayerField.getText()+":;"+splitNamesField.getText();
                controller.createTicket(selectedTicket,descriptionField.getText(),userString,(parseDouble(PriceOfTicketField.getText())),dt,splitEvenOrUneven); //create an airplane ticket
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
                    controller.removeTicket(removeTicketTextField.getText().hashCode());
                    informationRemoveTicketLabel.setText("Removed ticket");
                }
            }
        });

        
    }


    public void updateUser(Controller controller)
    {
        //Update the user fields
        ArrayList<User> allusers = controller.getUsers();
        String users = "Users: ";
        for(User user : allusers){
            users = users+user.getName()+", ";
        }
        userOverviewLabel.setText(users);
        updateTable(controller);
    }

    public void updateTicket(Controller controller)
    {
        //update the tickets
        ArrayList<Ticket> tickets = controller.getAllTickets();
        String ticketText = "Tickets: ";
        for(Ticket ticket : tickets){
            ticketText = ticketText + ticket.getDescription()+ ", ";
        }

        updateTable(controller);

        //update jtableof overview of the tickets
        String[] columns = {"Description of ticket","Price","Date of Purchase"};
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(columns);
        tableOverviewTickets.setModel(dtm);
        int howManytickets=0;
        for(Ticket ticket : tickets){
            String description = ticket.getDescription();
            double value = ticket.getValue();
            String date = ticket.getPurchaseDate();
            howManytickets++;
            Object[] data = {description,round(value,2),date};
            dtm.addRow(data);
        }
        tableOverviewTickets.setPreferredScrollableViewportSize(new Dimension(500,50));
        tableOverviewTickets.setFillsViewportHeight(true);


    }

    /**
     * @// FIXME: 16/12/2021 
     * @param controller
     */
    private void updateTable(Controller controller){

        ArrayList<User> userobjects = controller.getUsers();
        ArrayList<Ticket> tickets = controller.getAllTickets();
        ArrayList<String> userNames = new ArrayList();
        Integer howManyUsers = 0;


        String[] columns = {"Names","Balance"};
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(columns);
        billTableOverview.setModel(dtm);

        for(User user : userobjects){
            String name = user.getName();
            double balance = user.getMoneyBalance();
            howManyUsers++;
            Object[] data = {name,round(balance,2)};
            dtm.addRow(data);

        }
        billTableOverview.setPreferredScrollableViewportSize(new Dimension(500,50));
        billTableOverview.setFillsViewportHeight(true);





    }

    /**
     * @source https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
     * @param value Value you put in that you want to round
     * @param places how many decimal numbers
     * @return the rounded value
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
