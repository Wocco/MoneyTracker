package User;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Integer> tickets;
    private Double moneyBalance;

    /***
     * @function constructor of user
     * @param name name of the user
     */
    public User(String name){
        tickets = new ArrayList<>();
        this.name = name;
        this.moneyBalance = 0.0;
    }

    /***
     * @function get the name of the user
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @function get the tickets where this user is mentioned in
     * @return
     */
    public ArrayList<Integer> getTickets(){
        return tickets;
    }

    /**
     * @function remove ticket from user
     * @param hashvalueOfTicket
     */
    public void removeTicket(Integer hashvalueOfTicket){
        if(tickets.contains(hashvalueOfTicket)){
            tickets.remove(hashvalueOfTicket);
        }else{
            System.out.println("An error occured! The ticket couldn't be found in the user object.");
        }
    }


    /**
     * @function get the balance of this user
     * @return the money balance (double)
     */
    public Double getMoneyBalance(){
        return moneyBalance;
    }

    /**
     * @function Add a ticket to the user
     * @param hashValue
     */
    public void addTicketToUser(Integer hashValue){
        tickets.add(hashValue);
    }

    /**
     * @function set the moneybalance
     * @param addingMoney
     */
    public void setMoneyBalance(Double addingMoney){
        moneyBalance = moneyBalance + addingMoney;
    }

    /**
     * @function set the name of the user if it's already initialised
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
}
