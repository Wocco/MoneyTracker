package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;

public class OtherTicket extends Ticket {
    public OtherTicket(String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}
