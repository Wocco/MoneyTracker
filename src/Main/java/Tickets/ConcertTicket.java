package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;

public class ConcertTicket extends Ticket{
    public ConcertTicket(String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}
