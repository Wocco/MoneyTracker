package Database;


import Tickets.Ticket;

import java.util.HashMap;

public class TicketDB extends Database {
    private static TicketDB instance;
    private final HashMap<Ticket> db;

    TicketDB(){
        this.db = new HashMap();
    }

    public static TicketDB getInstance(){
        if(instance == null){
            instance = new TicketDB();
        }
    }
}
