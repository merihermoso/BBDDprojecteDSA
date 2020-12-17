package edu.upc.eetac.dsa.db;

import java.sql.Connection;

public class DBUtils {
   // private static final Connection DB_NAME = ;           //ERROR (fet)
   // private static final Connection DB_HOST = ;
   // private static final Connection DB_USER = ;
    // private static final Connection DB_PASS = ;
  //  private static final Connection DB_PORT = ;

    public static Connection getDb() { return DB_NAME; }
    public static Connection getDbHost() {return DB_HOST; }
    public static Connection getDbUser() {return DB_USER; }
    public static Connection getDbPasswd() {return DB_PASS; }
    public static Connection getDbPort() {return DB_PORT; }

    public static Connection getConnection() {
        String db = DBUtils.getDb();
        String host = DBUtils.getDbHost();
        String port = DBUtils.getDbUser();
        String pass = DBUtils.getDbPasswd();
        String port = DBUtils.getDbPort();

        Connection connection = DriveManager.getConnection("jdbc:mariadb://"+host+":"+port+
                db+"?user="+user+"&password="+pass);

        return connection;
    }
}
