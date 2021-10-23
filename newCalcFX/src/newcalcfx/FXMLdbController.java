/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalcfx;

import dao.LoginModel;
import entity.Operation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author pro
 */
public class FXMLdbController implements Initializable {

    @FXML
    private Label lbResTxt;
    @FXML
    private Pane pnlMenu;
    @FXML
    private Label btnClose;
    @FXML
    private Label btnMinimized;
    @FXML
    private Button btnBack;
    // определяем таблицу и устанавливаем данные
    @FXML
    private TableView<Operation> tblOperation;
   
    
    
    @FXML
    private TableColumn<Operation, Double> colX;
    @FXML
    private TableColumn<Operation, String> colOper;
    @FXML
    private TableColumn<Operation, Double> colY;
    @FXML
    private TableColumn<Operation, Double> colRes;

    private ObservableList<Operation> usersData = FXCollections.observableArrayList();
    private LoginModel loginModel = new LoginModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Operation> oper = loginModel.findOper();
            
            for (Operation operation : oper) {
                usersData.add(new Operation( operation.getX(), 
                                             operation.getOper(), 
                                             operation.getY(), 
                                             operation.getResult() ));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLdbController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // устанавливаем тип и значение которое должно хранится в колонке
        colX.setCellValueFactory(new PropertyValueFactory<Operation, Double>("X"));
        colOper.setCellValueFactory(new PropertyValueFactory<Operation, String>("oper"));
        colY.setCellValueFactory(new PropertyValueFactory<Operation, Double>("Y"));
        colRes.setCellValueFactory(new PropertyValueFactory<Operation, Double>("result"));
        // заполняем таблицу данными
        tblOperation.setItems(usersData);

        btnClose.setOnMousePressed((t) -> {
            System.exit(0);
        });
        btnMinimized.setOnMouseClicked((t) -> {
           Stage stage=(Stage) pnlMenu.getScene().getWindow();
           stage.setIconified(true);
       });
        btnBack.setOnAction((t) -> {
            btnBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLcalc.fxml"));
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
    
}
