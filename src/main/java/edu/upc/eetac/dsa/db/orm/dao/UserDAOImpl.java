package edu.upc.eetac.dsa.db.orm.dao;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.db.orm.*;
import edu.upc.eetac.dsa.db.orm.model.User;
import java.util.*;

public class UserDAOImpl implements IUserDAO{

    public int addUser(String username, String email, String password, int nivel) {
        Session session = null;
        int userID = 0;
        try {
            session = FactorySession.openSession();
            User user = new User(username, email, password, nivel);
            session.save(user);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return userID;
    }


    public User getUser(int userID) {
        Session session = null;
        User user = null;
        try {
            session = FactorySession.openSession();
            user = (User)session.get(User.class, userID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return user;
    }




    public void updateUser(int userID, String username, String email, String password, int nivel) {
        User user = this.getUser(userID);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setNivel(nivel);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }


    public void deleteUser(int userID) {
        User user = this.getUser(userID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }

    public List<User> getUsers() {
        return null;
    }


    public List<User> getUser() {
        Session session = null;
        List<User> userList=null;
        try {
            session = FactorySession.openSession();
            userList = session.findAll(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }


    public List<User> getUserByPartida(int partidaID) {

        Session session = null;
        List<User> userList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("partidaID", partidaID);

            userList = session.findAll(User.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }


}
