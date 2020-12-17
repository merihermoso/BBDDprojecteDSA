package edu.upc.eetac.dsa.db.orm;

import edu.upc.eetac.dsa.db.orm.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.sql.*;

public interface Session<E> {
    void save(Object entity);                           //CRUD
    void close();
    Object get(Class theClass, int ID);                   //CRUD
    void update(Object object);                           //CRUD
    void delete(Object object);                           //CRUD
    List<Object> findAll(Class theClass);                 //CRUD
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);


}
