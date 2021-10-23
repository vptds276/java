/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Operation;
import java.util.List;
import javafx.scene.Camera;

/**
 *
 * @author pro
 */
public interface OperDAO {
    //Добавить запись об операции
    public void addOperation(Operation operation);
    //Получение списка операций
    public List<Operation> getCountOperation(Integer num);
    
}
