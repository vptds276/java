/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalcfx;

import dao.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javax.management.Query.value;

/**
 * FXML Controller class
 *
 * @author pro
 */
public class FXMLCalcController implements Initializable {

    @FXML
    private Label lbTxt;
    @FXML
    private Label btnClose;
    @FXML
    private Label btnMinimized;

    private String oper;
    private double x, y;
    
    @FXML
    private Label lbResTxt;
    @FXML
    private Pane pnlMenu;
    @FXML
    private Button btnDB;
    @FXML
    private Label btnHelp;
    
    public LoginModel loginModel = new LoginModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        if (loginModel.isDbConnected()){
            btnDB.setVisible(true);
        }else btnDB.setVisible(false);
            
        btnClose.setOnMousePressed((t) -> {
            System.exit(0);
        });
       btnMinimized.setOnMouseClicked((t) -> {
           Stage stage=(Stage) pnlMenu.getScene().getWindow();
           stage.setIconified(true);
       });
        
        
        btnDB.setOnAction((t) -> {
            btnDB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLdb.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLCalcController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
            
        });
        btnHelp.setOnMousePressed((t) -> {
            btnHelp.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLabout.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLCalcController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
            
        });
    }

    @FXML
    private void btnClickClear(ActionEvent event) {
        lbTxt.setText("0.0");
        lbResTxt.setText("");
        x = 0;
        y = 0;
    }

    @FXML
    private void btnClickDiv(ActionEvent event) {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText(String.valueOf(x) + "/");
        lbTxt.setText("0");
        oper = "/";
    }

    @FXML
    private void btnClickMul(ActionEvent event) {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText(String.valueOf(x) + "*");
        lbTxt.setText("0");
        oper = "*";
    }

    @FXML
    private void btnClickMinus(ActionEvent event) {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText(String.valueOf(x) + "-");
        lbTxt.setText("0");
        oper = "-";
    }

    @FXML
    private void btnClickPlus(ActionEvent event) {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText(String.valueOf(x) + "+");
        lbTxt.setText("0");
        oper = "+";
    }
    @FXML
    private void btnClickStep(ActionEvent event) {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText(String.valueOf(x) + "^");
        lbTxt.setText("0");
        oper = "^";
    }

    @FXML
    private void btnClickSQRT(ActionEvent event) throws SQLException {
        x = Double.parseDouble(lbTxt.getText());
        lbResTxt.setText("sqrt("+String.valueOf(x)+")="+String.valueOf(Math.sqrt(x)));
        lbTxt.setText("0");
        oper = "sqrt";
        loginModel.addOper(x, oper, 0, Math.sqrt(x));
    }

    @FXML
    private void btnClick7(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("7");
        } else {
            String oldV = lbTxt.getText();
            String set = "7";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick8(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("8");
        } else {
            String oldV = lbTxt.getText();
            String set = "8";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick9(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("9");
        } else {
            String oldV = lbTxt.getText();
            String set = "9";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick4(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("4");
        } else {
            String oldV = lbTxt.getText();
            String set = "4";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick5(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("5");
        } else {
            String oldV = lbTxt.getText();
            String set = "5";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick6(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("6");
        } else {
            String oldV = lbTxt.getText();
            String set = "6";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick3(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("3");
        } else {
            String oldV = lbTxt.getText();
            String set = "3";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick2(ActionEvent event) {
        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("2");
        } else {
            String oldV = lbTxt.getText();
            String set = "2";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick1(ActionEvent event) {

        if (Double.parseDouble(lbTxt.getText()) == 0) {
            lbTxt.setText("1");
        } else {
            String oldV = lbTxt.getText();
            String set = "1";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClick0(ActionEvent event) {
        //lbTxt.setText(Double.parseDouble(lbTxt.getText())==0?String.valueOf(0):String.valueOf(Double.parseDouble(lbTxt.getText())*10+0));
        if (Double.parseDouble(lbTxt.getText()) != 0) {
            String oldV = lbTxt.getText();
            String set = "0";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClickDot(ActionEvent event) {
        //lbTxt.setText(Double.parseDouble(lbTxt.getText())==0?String.valueOf(0):String.valueOf(Double.parseDouble(lbTxt.getText())*10+0));
        //не допускаем ввода второй точки
        if (lbTxt.getText().contains(".")) {
        } else {
            String oldV = lbTxt.getText();
            String set = ".";
            lbTxt.setText(oldV + set);
        }
    }

    @FXML
    private void btnClickEquals(ActionEvent event) throws SQLException {
        //выбираем операцию в зависимости от значения переменной oper
        switch (oper) {
            case "+":
                //получаем второе число
                y = Double.parseDouble(lbTxt.getText());
                //добавляем к строке подсказке второе число
                lbResTxt.setText(lbResTxt.getText() + String.valueOf(y)+"="+String.valueOf(x + y));
                
                //lbTxt.setText(String.valueOf(x + y));
                lbTxt.setText("0");
                //запись результата в базу
                loginModel.addOper(x, oper, y, x+y);
                break;
            case "-":
                y = Double.parseDouble(lbTxt.getText());
                lbResTxt.setText(lbResTxt.getText() + String.valueOf(y)+"="+String.valueOf(x - y));
                lbTxt.setText("0");
                loginModel.addOper(x, oper, y, x-y);
                break;
            case "*":
                y = Double.parseDouble(lbTxt.getText());
                lbResTxt.setText(lbResTxt.getText() + String.valueOf(y)+"="+String.valueOf(x * y));
                lbTxt.setText("0");
                loginModel.addOper(x, oper, y, x*y);
                break;
            case "/":
                //проверим на ноль
                y = Double.parseDouble(lbTxt.getText());
                if (y != 0) {
                    lbResTxt.setText(lbResTxt.getText() + String.valueOf(y)+"="+String.valueOf(x / y));
                    lbTxt.setText("0");
                    loginModel.addOper(x, oper, y, x/y);
                }
                break;
            case "^":
                y = Double.parseDouble(lbTxt.getText());
                //добавляем к строке подсказке второе число
                lbResTxt.setText(lbResTxt.getText() + String.valueOf(y)+"="+String.valueOf(Math.pow(x,y)));
                //вывод результата
                lbTxt.setText("0");
                loginModel.addOper(x, oper, y, Math.pow(x,y));
                break;
        }
    }

    @FXML
    private void onNumberClicked(MouseEvent event) {
    }

    

}
