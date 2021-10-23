/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Operation;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import newcalcfx.db.Const;

/**
 *
 * @author pro
 */
public class LoginModel {

    Connection connection;

    public LoginModel() {
        connection = SQLiteConnection.Connector();
        if (connection == null) {
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //Добавление сведений об операции
    public void addOper(double x, String oper, double y, double result) throws SQLException {
        PreparedStatement ps = null;
        String q = "INSERT INTO Operation (X, OPER, Y, RES_OPER) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(q);
            //ps.setLong(1, id);
            ps.setDouble(1, x);
            ps.setString(2, oper);
            ps.setDouble(3, y);
            ps.setDouble(4, result);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public List<Operation> findOper() throws SQLException {
        List<Operation> list = new LinkedList<>();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            String q = "SELECT x, oper, y, res_oper FROM Operation ORDER BY id DESC LIMIT 10";
            prst = connection.prepareStatement(q);
            rs = prst.executeQuery();

            while (rs.next()) {
                list.add(fillOper(rs));

            }
            rs.close();
            prst.close();
        } catch (Exception e) {

        } 

        return list;
    }

    private Operation fillOper(ResultSet rs) throws SQLException {
        Operation oper = new Operation();
       //oper.setId(rs.getInt(Const.ID));
        oper.setX(rs.getDouble(Const.X));
        oper.setOper(rs.getString(Const.OPER));
        oper.setY(rs.getDouble(Const.Y));
        oper.setResult(rs.getDouble(Const.RESULT));
        return oper;
    }
}
