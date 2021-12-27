package Database;


import Tickets.Ticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketDB{
    private static TicketDB instance = new TicketDB();
    private final HashMap<Integer, Ticket> db;

    /**
     * @function contstructor of the ticket database
     */
    private TicketDB(){
        this.db = new HashMap();
    }

    /**
     * @function get the instance of the ticketDB
     * @return instance of ticketDB
     */
    public static TicketDB getInstance() {
        if (instance == null) {
            instance = new TicketDB();
        }
        return instance;
    }

    /**
     * @function add a ticket to the database, when the ticket with the same description is already present in the database it doesn't get added
     * @param hashValue hashvalue of the ticket
     * @param ticket the to be added ticket
     */
    public void addTicket(Integer hashValue, Ticket ticket){
        if(db.get(ticket.getDescription().hashCode())==null) {
            this.db.put(hashValue, ticket);
            change.firePropertyChange(null, null, ticket);
        }
        else{
            System.out.println("Error: This description is the same as another ticket. Give another description to your ticket.");
        }
    }

    /**
     * @function remove a ticket from the database
     * @param hashValue hash of the to be deleted ticekt
     */
    public Ticket removeTicket(Integer hashValue){
        Ticket ticket = this.db.get(hashValue);
        if(ticket!=null) {
            this.db.remove(hashValue);
            change.firePropertyChange(null, null, hashValue);
        }
        return ticket;
    }

    /**
     * @function get an arraylist of all the tickets in the database
     * @return Arraylist of all the tickets
     */
    public ArrayList<Ticket> getAllTickets(){
        ArrayList<Ticket> allTickets = new ArrayList<>();
        for(Ticket ticket:db.values()){
            allTickets.add(ticket);
        }
        return allTickets;
    }

    /**
     * @function get a certain ticket from the database
     * @param hashvalue of the  ticket
     * @return Ticket
     */
    public Ticket getTicket(Integer hashvalue){
        return this.db.get(hashvalue);
    }

    /**
     * @function add support for the PropertyChangeListener
     */
    private PropertyChangeSupport change = new PropertyChangeSupport(this);
    /**
     * @function add a PropertyChangeListener when something changes in the database the property changelistener fires
     */
    public void add(PropertyChangeListener pcl){
        change.addPropertyChangeListener(pcl);
    }

    /**
     * @function remove the PropertyChangeListener
     * @param pcl
     */
    public void remove(PropertyChangeListener pcl)
    {
        change.removePropertyChangeListener(pcl);
    }
}
