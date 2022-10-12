package sorabh86;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class DBConnect {
    
//    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//    private static final String DB = "jdbc:mysql://localhost:3306/webjsp";
//    private static final String USR = "root";
//    private static final String PASS = "root";
    
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USR = "HR";
    private static final String PASS = "hr";
    
    private static Connection conn;
    
    public static boolean connect() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        try {
            conn = DriverManager.getConnection(DB, USR, PASS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
