package Tickets;

import User.User;

import java.util.HashMap;

public class OtherTicket extends Ticket {
    public OtherTicket(String description, HashMap<User, Double> users, double value, String purchaseDate, int splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}
