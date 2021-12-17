package User;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Integer> tickets;
    private Double moneyBalance;

    public User(String name){
        tickets = new ArrayList<>();
        this.name = name;
        this.moneyBalance = 0.0;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Integer> getTickets(){
        return tickets;
    }

    public Double getMoneyBalance(){
        return moneyBalance;
    }

    public void addTicketToUser(Integer hashValue){
        tickets.add(hashValue);
    }

    public void setMoneyBalance(Double addingMoney){
        moneyBalance = moneyBalance + addingMoney;
    }

    public void setName(String name){
        this.name = name;
    }
}
