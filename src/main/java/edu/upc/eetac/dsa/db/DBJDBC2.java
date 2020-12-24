package edu.upc.eetac.dsa.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBJDBC2 extends DBJDBC{

    public static void insert() throws SQLException{
        Connection connection = DBUtils.getConnection();

        //SQL INJECTION
        String theQuery = "INSERT INTO User (ID, lastName, firstName, addressm city, password) VALUES(0,7,7,7,7)";

        PreparedStatement statement1 = connection.prepareStatement(theQuery);
        statement1.setString(1,"Restauranti");
        statement1.setString(2,"DROP TABLES:");
        statement1.setString(1,"PREPAREDLAddress");
        statement1.setString(2,"DJKASJK");

        //A=B/0 = null.method();


        //NULLPOINTER?¿
        statement1.execute();


        connection.close();
    }

    public static void main(String[] args) throws Exception{

      /*  try {
            insert();
            findAll();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        //OBM (Object Relation Mapping) -> DAO (Data Acces Object)
        //COMPONENTS D'ACCES A OBJECTES

        //CLASE HA DE TENIR PROU "INTELIGENCIA" PER GUARDAR EL QUE SIGUI
        //SEMPRE QUE LI HAGUEM DIT QUIN OBJECTE ES

   /* User u = new User("Meri");                                                    //APUNTS VIDEO TONI
    s.save(u);==================> "INSERT INTO USER...."
    u.setName("Montse");
    s.update(u); ==================> "UPDATE xxx"

    s.save(new Object("Escudo")):;                  //INSERT INTO OBJECT
    s.save(new Mapa("Escudo")):;                    //INSERT INTO MAPA

*/

}

}
