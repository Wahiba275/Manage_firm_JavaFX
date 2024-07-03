package ma.enset.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexionDB {
    private static Connection connection;

    static {
      try{
          String url = "jdbc:mysql://localhost:3306/cabinet?useUnicode=true &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC" ;
          Class.forName("com.mysql.cj.jdbc.Driver");
          connection= DriverManager.getConnection(url,"root","");
      }catch (Exception e){
          e.printStackTrace();
      }
    }

    public static Connection getConnection() {
        return connection;
    }
}
