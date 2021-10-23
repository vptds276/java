/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalcfx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import newcalcfx.db.Configs;

/**
 *
 * @author pro
 */
public class CalcFXMain extends Application {

    private double xCoord, yCoord;

    @Override
    public void start(Stage primaryStage) {

        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCalc.fxml"));

            Scene scene = new Scene(loader.load());
            scene.setOnMousePressed(t -> {
                xCoord = primaryStage.getX() - t.getScreenX();
                yCoord = primaryStage.getY() - t.getScreenY();

            });
            scene.setOnMouseDragged((t) -> {

                primaryStage.setX(t.getScreenX() + xCoord);
                primaryStage.setY(t.getScreenY() + yCoord);

            });
            
            scene.setFill(Color.TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setResizable(false);
            primaryStage.setTitle("newCalcFX");
            
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(CalcFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
