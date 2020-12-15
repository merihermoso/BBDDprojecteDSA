package edu.upc.eetac.dsa.db.orm;

import edu.upc.eetac.dsa.db.orm.model.Employee;

public interface Session {
    void save(Employee employee);

    void close();
}
