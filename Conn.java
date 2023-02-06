package bank.management.system;
import java.sql.*;
public class Conn {
    
//    Database Connectiviy
//    Step 1:- Register the Driver
//    Step 2:- Create Connection
//    Step 3:- Create Statement
//    Step 4:- Execute Query
//    Close Connection
    
//    Create Connection
    Connection c;
    Statement s;
    public Conn(){
        
        try{
//            Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","mypassword1234.,/");
//            Create Statement
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
