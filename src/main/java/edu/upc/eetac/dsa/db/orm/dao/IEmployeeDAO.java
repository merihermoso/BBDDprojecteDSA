package edu.upc.eetac.dsa.db.orm.dao;

import java.util.*;
import edu.upc.eetac.dsa.db.orm.model.*;
public interface IEmployeeDAO {

    public int addEmployee(String name, String surname, double salary);
    public Employee getEmployee(int employeeID);
    public void updateEmployee(int employeeID,String name, String surname, double salary);
    public void deleteEmployee(int employeeID);
    public List<Employee> getEmployees();
    public List <Employee> getEmployeeByDept(int deptId);
}
