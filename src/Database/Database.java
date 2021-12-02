package Database;

import Tickets.Ticket;

public abstract class Database {
    public Database(){

    }

    public abstract void addTicket(Integer hash, Ticket ticket);
}
