package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ConcertTicket extends Ticket{
    public ConcertTicket(String description, HashMap<User, Integer> users, int value, String purchaseDate, boolean splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}