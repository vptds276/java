/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Operation;
import java.util.LinkedList;
import java.util.List;
import newcalcfx.db.Const;

/**
 *
 * @author pro
 */
//реализация методов интерфейса
public class OperDbDAO implements OperDAO{

    //Добавление записи об операции
    private static final String INSERT_OPER
            = "INSERT INTO " + Const.TBL_NAME + "("
            + Const.ID + ","
            + Const.DATE_OPER + ","
            + Const.X + ","
            + Const.OPER + ","
            + Const.Y + ","
            + Const.RESULT + ")"
            + " VALUES (?, ?, ?, ?, ?, ?)";
    //получение списка операций
    private static final String SELECT_LIST_OPER
            = "SELECT id, date_oper, x, oper, y FROM " + Const.TBL_NAME;// + " WHERE " + Const.CAM_N1 + "=?";
    
    //создание подключения к базе
    
    
    @Override
    public void addOperation(Operation operation) {
        
    }

    @Override
    public List<Operation> getCountOperation(Integer num) {
        List list = new LinkedList();
        
        return list;
    }
    
}
