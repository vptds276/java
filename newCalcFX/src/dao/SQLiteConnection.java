/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
/**
 *
 * @author pro
 */
public class SQLiteConnection {
    public static Connection Connector(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:base_oper.db");
            return conn;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }       
    }
}
