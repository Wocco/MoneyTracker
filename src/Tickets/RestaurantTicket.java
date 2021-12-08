package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}
