package Database;


import Tickets.Ticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketDB{
    private static TicketDB instance;
    private final HashMap<Integer, Ticket> db;

    public TicketDB(){
        this.db = new HashMap();
    }

    public static TicketDB getInstance() {
        if (instance == null) {
            instance = new TicketDB();
        }
        return instance;
    }

    public void addTicket(Integer hashValue, Ticket ticket){
        if(db.get(ticket.getDescription().hashCode())==null) {
            this.db.put(hashValue, ticket);
            change.firePropertyChange(null, null, ticket);
        }
        else{
            System.out.println("Error: This description is the same as another ticket. Give another description to your ticket.");
        }
    }

    public ArrayList<Ticket> getAllTickets(){
        ArrayList<Ticket> allTickets = new ArrayList<>();
        for(Ticket ticket:db.values()){
            allTickets.add(ticket);
        }
        return allTickets;
    }

    private PropertyChangeSupport change = new PropertyChangeSupport(this);
    public void add(PropertyChangeListener pcl){
        change.addPropertyChangeListener(pcl);
    }

    public void remove(PropertyChangeListener pcl)
    {
        change.removePropertyChangeListener(pcl);
    }
}
