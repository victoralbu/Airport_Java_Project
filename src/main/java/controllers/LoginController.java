package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.FlightsEntity;
import model.UsersEntity;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import service.FlightsService;
import service.UsersService;

import javax.persistence.Entity;
import java.io.Serializable;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private Label lblLogin;
    @FXML
    private Button btnTryLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        FlightsService flightsService = new FlightsService();
        System.out.println(flightsService.getAllFlights());
    }



    public void login(ActionEvent actionEvent) throws Exception{
        UsersService<UsersEntity> usersService = new UsersService<>();
        List<UsersEntity> usersEntityList = usersService.login(tfUsername.getText(),tfPassword.getText());
        if(usersEntityList != null){
            lblLogin.setText("A MERS!");
        }else{
            lblLogin.setText("NU A MERS");
        }
    }
}
