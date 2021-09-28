package controllers;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.controlsfx.control.textfield.TextFields;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FlightsController implements Initializable {



    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMinimize;

    @FXML
    private Label lblFrom;

    @FXML
    private Label lblDestination;

    @FXML
    private TextField from;

    @FXML
    private TextField destination;

    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query1 = session.createQuery("SELECT DISTINCT placeOfDeparture FROM FlightsEntity");
        Query query2 = session.createQuery("SELECT DISTINCT placeOfLanding FROM FlightsEntity");
        List placeDeparture = query1.list();
        List placeLanding = query2.list();

        TextFields.bindAutoCompletion(from, placeDeparture);
        TextFields.bindAutoCompletion(destination, placeLanding).setVisibleRowCount(3);

        btnClose.setOnAction(actionEvent -> Platform.exit());

    }

    public void setLabelFrom() {
        lblFrom.setStyle("-fx-background-color: #f4f4f4;-fx-text-fill: #006a79;");
        from.setStyle("-fx-prompt-text-fill: transparent;");
    }

    public void unsetLabelFrom() {
        lblFrom.setStyle("-fx-background-color: transparent;-fx-text-fill: none;");
        from.setStyle("-fx-prompt-text-fill: #aaaaaa;");
    }

    public void setLabelTo() {
        lblDestination.setStyle("-fx-background-color: #f4f4f4;-fx-text-fill: #006a79;");
        destination.setStyle("-fx-prompt-text-fill: transparent;");
    }

    public void unsetLabelTo() {
        lblDestination.setStyle("-fx-background-color: transparent;-fx-text-fill: none;");
        destination.setStyle("-fx-prompt-text-fill: #aaaaaa;");
    }

    public void setBtnMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void setBtnLoginStage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent next = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        Scene scene = new Scene(next, 700, 400);
        stage.setScene(scene);
        stage.show();
    }
}

