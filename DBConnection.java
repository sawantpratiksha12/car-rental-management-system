package myproject1;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

  public static Connection getConnection() {
      Connection con = null;

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL driver

          con = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/Cardb",   // your DB name
                  "root",                                 // MySQL username
                  "Pratiksha@123"                         // MySQL password
          );
          con.setAutoCommit(true);


          System.out.println("Connected Successfully!");
          System.out.println(con.getCatalog());

      } 
      catch (Exception e) {
          e.printStackTrace();
      }

      return con;
  }
}

