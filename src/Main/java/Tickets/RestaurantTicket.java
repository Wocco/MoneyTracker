package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RestaurantTicket extends Ticket{
    public RestaurantTicket(String description, HashMap<User, Double> users, double value, String purchaseDate, int splitEvenly){
        super(description, users, value, purchaseDate, splitEvenly);
    }
}
