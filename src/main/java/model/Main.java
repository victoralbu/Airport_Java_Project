package model;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.UsersService;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("flights.fxml"));

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root, 700, 400);
        root.setStyle("-fx-background-color: #f4f4f4");
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add("test.css");
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }



    public static void main(String[] args) {

        launch(args);
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
/*        UsersService userService = new UsersService();
        AccountsService accountsService = new AccountsService();
        ReservationsService reservationsService = new ReservationsService();
        FlightsService flightsService = new FlightsService();
        InvoicesService invoicesService = new InvoicesService();
        PlaneService planeService = new PlaneService();
        PlacesFlightsService placesFlightsService = new PlacesFlightsService();
        PlacesService placesService = new PlacesService();

        UsersEntity u1 = new UsersEntity();
        AccountsEntity a1 = new AccountsEntity();
        FlightsEntity f1 = new FlightsEntity();
        InvoicesEntity i1 = new InvoicesEntity();
        ReservationsEntity r1 = new ReservationsEntity();
        PlacesEntity pl1 = new PlacesEntity();
        PlacesFlightsEntity pf1 = new PlacesFlightsEntity();
        PlaneEntity p1 = new PlaneEntity();

        u1.setFirstname("boss");
        userService.addUser(u1);

        a1.setIdUser(u1.getIdUser());
        accountsService.addAccount(a1);

        *//*userService.removeInvoice(u1,u1.getIdUser());*//*

        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
        java.sql.Time time = java.sql.Time.valueOf("12:32:10");
        java.sql.Date date = java.sql.Date.valueOf("2007-09-23");
        System.out.println(time);

        f1.setPlaceOfDeparture("marte");
        f1.setTimeOfDeparture(timestamp);
        flightsService.addFlight(f1);

        placesService.addPlace(pl1);
        planeService.addPlane(p1);

        r1.setIdflight(f1.getIdflight());
        r1.setIdPlane(p1.getIdPlane());
        r1.setIdUsers(u1.getIdUser());
        reservationsService.addReservation(r1);

        i1.setIdReservation(r1.getIdReservation());
        invoicesService.addInvoice(i1);

        pf1.setIdflight(f1.getIdflight());
        pf1.setPlacesIdPlaces(pl1.getIdPlaces());
        placesFlightsService.addPlacesFlights(pf1);

        System.out.println(userService.find(1));*/
    }
}
