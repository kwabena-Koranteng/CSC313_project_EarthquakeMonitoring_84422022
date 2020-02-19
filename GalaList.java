package earthquakemonitoring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GalaList implements Initializable {
    @FXML
    private Button quer_id;
    @FXML
    private Button ques_id;
    Galamseydb g_db;
    @FXML
    private TextField ol_id;
    @FXML
    private TableView tabl_id;
    @FXML
    private TableColumn ia_id;
    @FXML
    private TableColumn ve_id;
    @FXML
    private TableColumn cv_id;
    @FXML
    private TableColumn la_id;
    @FXML
    private TableColumn lo_id;
    @FXML
    private TableColumn ye_id;
    @FXML
    Button back;
    Connection con;
    private final ObservableList<Object> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void buttonstats(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }
    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_Galam.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }
    public void buttons(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Gala_List.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    public void que(javafx.event.ActionEvent event){
        try {
            String query = "select * from galamsey where col_val >" + ol_id.getText();
            Statement st = g_db.connect().createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);//executes the query
            String galamseyData = "";//assigns data fetched from database
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                galamseyData +=  rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                        Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                        Integer.parseInt(rs.getString("year_started")) + "\n";

            }
            data.add(galamseyData);
            ia_id.setCellValueFactory(new PropertyValueFactory1<>("GID"));
            ve_id.setCellValueFactory(new PropertyValueFactory1<>("veg_col"));
            cv_id.setCellValueFactory(new PropertyValueFactory1<>("col_val"));
            la_id.setCellValueFactory(new PropertyValueFactory1<>("latitude"));
            lo_id.setCellValueFactory(new PropertyValueFactory1<>("longitude"));
            ye_id.setCellValueFactory(new PropertyValueFactory1<>("year_started"));

            tabl_id.setItems(data);



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}