package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private String description;
    private Date purchaseDate;
    private int hashValue;
    private ArrayList<User> users;
    private int value;
    private boolean splitEvenly;
    public Ticket(String description, ArrayList<User> users, int value, Date purchaseDate, boolean splitEvenly){
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

    public int getValue(){
        return value;
    }

    public Date getPurchaseDate(){
        return purchaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public boolean isSplitEvenly() {
        return splitEvenly;
    }

    public void addUser(User user){this.users.add(user);}

    public ArrayList<User> getUsers(){return users;}
}
