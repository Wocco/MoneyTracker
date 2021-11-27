package Tickets;

public class Ticket {
    private String description;
    private int value;
    private boolean splitEvenly;
    public Ticket(String description, int value, boolean splitEvenly){
        this.description = description;
        this.value = value;
        this.splitEvenly = splitEvenly;
    }

    public String getDescription(){
        return description;
    }

    public int getValue(){
        return value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSplitEvenly() {
        return splitEvenly;
    }
}
