package dbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection 
{    
   final static String MYSQL_DB_URL="jdbc:mysql://database-1.cbvzvh1cuoti.ap-south-1.rds.amazonaws.com/sys";
   final static String MYSQL_DB_USER_NAME="TAndP";
   final static String MYSQL_DB_PASS="ScaBhopal1998";
   
   private static Connection conn=null;
   static 
   {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn=DriverManager.getConnection(MYSQL_DB_URL,MYSQL_DB_USER_NAME,MYSQL_DB_PASS);
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
           System.out.println("Error in DBConnection :- ");
       }
       catch(ClassNotFoundException ex)
       {
           ex.printStackTrace();
           System.out.println("Error in DBConnection :- ");
       }
   }
   
   public static Connection getConnection()throws SQLException
   {
       return conn;
   }
   
   public static void closeConnection()
   {
       try
       {    
           if(conn!=null)
                conn.close();
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
           System.out.println("Error while Closing Conn ");
       }
       
   }
}
