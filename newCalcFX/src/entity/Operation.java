/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author pro
 */
public class Operation {
    //Первичный ключ
    private int id;
    //Дата операции
    private Date date_oper;
    //Значение Х
    private Double x;
    //Операция
    private String oper;
    //Значение Y
    private Double y;
    //Результат
    private Double result;

    public Operation() {
    }

    public Operation(Double x, String oper, Double y, Double result) {
        this.x = x;
        this.oper = oper;
        this.y = y;
        this.result = result;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_oper() {
        return date_oper;
    }

    public void setDate_oper(Date date_oper) {
        this.date_oper = date_oper;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Operation{" + "id=" + id + ", date_oper=" + date_oper + ", x=" + x + ", oper=" + oper + ", y=" + y + ", result=" + result + '}';
    }

   
    
    
}
