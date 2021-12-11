package Tickets;

import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Ticket {
    private String description;
    private String purchaseDate;
    private int hashValue;
    private HashMap<User, Integer> users;
    private int value;
    private boolean splitEvenly;
    public Ticket(String description, HashMap<User, Integer> users, int value, String purchaseDate, boolean splitEvenly){
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

    public int getValue(){
        return value;
    }

    public String getPurchaseDate(){
        return purchaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public boolean isSplitEvenly() {
        return splitEvenly;
    }

    public void addUser(User user, Integer money){this.users.put(user,money);}

    public HashMap<User, Integer> getUsers(){return users;}
}
