package edu.upc.eetac.dsa.db.orm.dao;

import java.util.*;
import edu.upc.eetac.dsa.db.orm.model.*;
public interface IUserDAO {

    public int addUser(String username, String email, String password, int nivel);
    public User getUser(int userID);
    public void updateUser(int userID,String username, String email, String password, int nivel);
    public void deleteUser(int userID);
    public List<User> getUsers();
    public List <User> getUserByPartida(int partidaId);
}
