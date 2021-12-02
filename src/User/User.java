package User;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Integer> tickets;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList getTickets(){
        return tickets;
    }

    public void addTicketToUser(Integer hashValue){
        tickets.add(hashValue);
    }

    public void setName(String name){
        this.name = name;
    }
}
