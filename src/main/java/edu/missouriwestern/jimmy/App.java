package edu.missouriwestern.jimmy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.missouriwestern.jimmy.Customer;
import edu.missouriwestern.jimmy.Manager;
import edu.missouriwestern.jimmy.Teller;
import edu.missouriwestern.jimmy.CheckingAccount;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static edu.missouriwestern.jimmy.CheckingAccount.readAccountsFromCSV;

public class App extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Account Selection");

        // Create buttons for each account type
        Button customerButton = new Button("Customer Account");
        Button tellerButton = new Button("Teller Account");
        Button managerButton = new Button("Manager Account");

        // Set the event handlers for each button
        customerButton.setOnAction(e -> {
            // Open the customer Java class
            User userUI = new User();
            try {
                userUI.newStage(readAccountsFromCSV("C:/Users/jimmy/Downloads/CSC406team2.csv"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            //customerUI.show(readAccountsFromCSV("C:/Users/jimmy/Downloads/CSC406team2.csv"));
        });

        tellerButton.setOnAction(e -> {
            // Open the teller Java class
            Teller tellerUI = new Teller();
            //User userUI = new User();
            try {
                tellerUI.newStage(readAccountsFromCSV("C:/Users/jimmy/Downloads/CSC406team2.csv"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });

        managerButton.setOnAction(e -> {
            // Open the manager Java class
            Manager managerUI = new Manager();
            try {
                managerUI.newStage(readAccountsFromCSV("C:/Users/jimmy/Downloads/CSC406team2.csv"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });

        // Create a layout for the buttons
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(customerButton, tellerButton, managerButton);

        // I live in your walls

        // Set the scene and show the window
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) {

        launch(args);
    }

}
