package edu.upc.eetac.dsa.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DBJDBC {

    public static void insert() throws SQLException{
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();        //demano recursos

            Statement statement1 = connection.createStatement();            //creo una sentencia i la executo a la linea de sota
            statement1.execute("INSERT INTO employees (employeeID, employeeName, employeeSurname, employeeSalary) VALUES (16,'Prova','Ferrer',1200)");
            //connection.close();                        //allibero recursos
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            connection.close();                         //asseguro que tanco conexió
        }
    }

    private static String getType (int type){
        return null;
    }

    public static void findAll() throws Exception{
        Connection connection= null;
        try {
            connection = DBUtils.getConnection();           //demano connexio
            Statement statement2 = connection.createStatement();    //creo sentencia
            ResultSet rs = statement2.executeQuery("SELECT * FROM USERE WHERE 1=1");

            //INTROSPECCIÓ BBDD
            ResultSetMetaData rsmd = rs.getMetaData();


            System.out.println("cols " + rsmd.getColumnCount());

            int i = 1;
            while (i <= rsmd.getColumnCount()) {
                System.out.println("col " + i + " " + rsmd.getColumnName(i) + " " +
                        rsmd.getColumnType(i) + " " + DBJDBC.getType(rsmd.getColumnType(i)));

                i++;
            }

            int id;
            String lastName, address, city;

            //Para cada fila
            while (rs.next()) {
                id = (Integer) rs.getObject(1); //La primera columna de JDBC es 1!!!!!!!!!!!!!!
                lastName = (String) rs.getObject(2);
                address = (String) rs.getObject(3);
                city = (String) rs.getObject(4);
                 /*rs.getString(2);
                re.getInt(2);
                rs.getDate(3);
                 */

                System.out.println(id+""+lastName+""+address+""+city);
                //per cada propietat dins de la fila
         //       while (j<=rsmd.getNumColumn()){
         //           theValue = rs.getObject(j);
         //          theProperty = rsmd.getColumnName(j);
         //          ObjectHelper.setter(theObject, theProperty, theValue);
         //       }

             //connection.close();
            }


        }
        catch (Exception e) {
            //log.d("", e);
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
       insert();
       // findAll();
    }
}
