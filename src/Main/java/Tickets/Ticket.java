package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Ticket {
    private String description;
    private String purchaseDate;
    private int hashValue;
    private HashMap<User, Double> users;
    private double value;
    private int splitEvenly;
    public Ticket(String description, HashMap<User, Double> users, double value, String purchaseDate, int splitEvenly){
        this.description = description;
        this.users = users;
        this.hashValue = description.hashCode();
        this.purchaseDate = purchaseDate;
        this.value = value;
        this.splitEvenly = splitEvenly;
    }

    public String getDescription(){
        return description;
    }

    public int getHashValue(){return hashValue;}

    public double getValue(){
        return value;
    }

    public String getPurchaseDate(){
        return purchaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public int isSplitEvenly() {
        return splitEvenly;
    }

    public void addUser(User user, Double money){this.users.put(user,money);}

    public HashMap<User, Double> getUsers(){return users;}
}
