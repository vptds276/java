/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import newcalcfx.db.Configs;

/**
 *
 * @author pro
 */
public class ConnectDB {
    
    public ConnectDB(){
        try {
            Class.forName(Configs.getProperty("db.driver.class"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConncetion() throws SQLException{
        
        String url      = Configs.getProperty("db.url");
        String login    = Configs.getProperty("db.login");
        String password = Configs.getProperty("db.password");
        
        return (Connection) DriverManager.getConnection(url, login, password);
    }
    
}
