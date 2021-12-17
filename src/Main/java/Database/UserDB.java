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

    /**
     * @function constructor of the User database
     */
    public UserDB(){
        this.db = new HashMap();
    }

    /**
     * @function Get the instance of the database, this makes it possible that only one database gets instantiated.
     * @return the instance of the userdatabase
     */

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    /**
     * @function add a user to the database and check if the user isn't already in the db
     * @param hashValue
     * @param user
     */
    public void addUser(Integer hashValue, User user){
        if(db.get(hashValue)==null) {
            this.db.put(hashValue, user);
            change.firePropertyChange(null, null, user);
        }else{
            System.out.println("Error, this user already exists!");
        }
    }

    /**
     * @function get the user
     * @param hashValue the hash value of the desired user
     * @return
     */
    public User getUser(Integer hashValue){
        return this.db.get(hashValue);
    }

    /**
     * @function remove a user from the database
      * @param hashValue the hash of the to be deleted user
     */
    public void removeUser(Integer hashValue){
        this.db.remove(hashValue);
        change.firePropertyChange(null, null, hashValue);
    }

    /**
     * @function get an arraylist of al the users
     * @return
     */
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        for(User user:db.values()){
            users.add(user);
        }
        return users;
    }

    /**
     * @function when something changes in the user database this propertychange listener gets fired
     */
    private PropertyChangeSupport change = new PropertyChangeSupport(this);
    public void add(PropertyChangeListener pcl){
        change.addPropertyChangeListener(pcl);
    }

    /**
     * @function remove the propertychangelistener
     * @param pcl the to be deleted propertychangelistener
     */
    public void remove(PropertyChangeListener pcl)
    {
        change.removePropertyChangeListener(pcl);
    }
}
