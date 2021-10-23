/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalcfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author pro
 */
public class FXMLaboutController implements Initializable {

    @FXML
    private Label lbResTxt;
    @FXML
    private Button btnCloseAbout;
    @FXML
    private Pane pnlMenu;
    @FXML
    private Label btnClose;
    @FXML
    private Label btnMinimized;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnMinimized.setOnMouseClicked((t) -> {
            Stage stage = (Stage) pnlMenu.getScene().getWindow();
            stage.setIconified(true);
        });
        btnClose.setOnMousePressed((t) -> {
            System.exit(0);
        });
        btnCloseAbout.setOnAction((t) -> {
            btnCloseAbout.getScene().getWindow().hide();
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
