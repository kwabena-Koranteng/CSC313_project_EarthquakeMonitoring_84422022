package earthquakemonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Author Aileen Akpalu
 * @version 1.0.5
 */
public class MonitoringGUI extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
            primaryStage.setTitle("OBSEY");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
            // Set the Scene to the Stage
            Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
            Scene scene = new Scene(screen_two);
            Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            s_two.setScene(scene);
            // Set the Title to the Stage
            s_two.show();
        }

        public void button(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
            Scene scene = new Scene(screen_two);
            Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            s_two.setScene(scene);
            s_two.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }





