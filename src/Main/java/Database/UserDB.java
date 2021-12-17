package Database;

import Tickets.Ticket;
import User.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDB {
    private static UserDB instance;
    private final HashMap<Integer, User> db;

    public UserDB(){
        this.db = new HashMap();
    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    public void addUser(Integer hashValue, User user){
        if(db.get(hashValue)==null) {
            this.db.put(hashValue, user);
            change.firePropertyChange(null, null, user);
        }else{
            System.out.println("Error, this user already exists!");
        }
    }

    public User getUser(Integer hashValue){
        return this.db.get(hashValue);
    }

    public void removeUser(Integer hashValue){
        this.db.remove(hashValue);
        change.firePropertyChange(null, null, hashValue);
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        for(User user:db.values()){
            users.add(user);
        }
        return users;
    }


    private PropertyChangeSupport change = new PropertyChangeSupport(this);
    public void add(PropertyChangeListener pcl){
        change.addPropertyChangeListener(pcl);
    }

    public void remove(PropertyChangeListener pcl)
    {
        change.removePropertyChangeListener(pcl);
    }
}
