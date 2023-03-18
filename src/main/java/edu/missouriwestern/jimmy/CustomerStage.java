package edu.missouriwestern.jimmy;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerStage {

    public void newStage1(List<CheckingAccount> accountss,List<Customer> accounts) throws Exception {
        // Create a new Stage
        Stage stage = new Stage();
        stage.setTitle("Create Account");

        // Create a GridPane to hold the account creation controls
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(11));
        gridPane.setHgap(11);
        gridPane.setVgap(11);

        // Add a Label to prompt the user to enter their SSN
        Label ssnLabel = new Label("SSN:");
        gridPane.add(ssnLabel, 0, 0);

        // Add a TextField to allow the user to enter their SSN
        TextField ssnField = new TextField();
        gridPane.add(ssnField, 1, 0);

        // Add a Label to prompt the user to enter their street address
        Label addressLabel = new Label("Street Address:");
        gridPane.add(addressLabel, 0, 1);

        // Add a TextField to allow the user to enter their street address
        TextField addressField = new TextField();
        gridPane.add(addressField, 1, 1);

        // Add a Label to prompt the user to enter their city
        Label cityLabel = new Label("City:");
        gridPane.add(cityLabel, 0, 2);

        // Add a TextField to allow the user to enter their city
        TextField cityField = new TextField();
        gridPane.add(cityField, 1, 2);

        // Add a Label to prompt the user to enter their state
        Label stateLabel = new Label("State:");
        gridPane.add(stateLabel, 0, 3);

        // Add a TextField to allow the user to enter their state
        TextField stateField = new TextField();
        gridPane.add(stateField, 1, 3);

        // Add a Label to prompt the user to enter their zip code
        Label zipLabel = new Label("Zip:");
        gridPane.add(zipLabel, 0, 4);

        // Add a TextField to allow the user to enter their zip code
        TextField zipField = new TextField();
        gridPane.add(zipField, 1, 4);

        // Add a Label to prompt the user to enter their first name
        Label firstNameLabel = new Label("First Name:");
        gridPane.add(firstNameLabel, 0, 5);

        // Add a TextField to allow the user to enter their first name
        TextField firstNameField = new TextField();
        gridPane.add(firstNameField, 1, 5);

        // Add a Label to prompt the user to enter their last name
        Label lastNameLabel = new Label("Last Name:");
        gridPane.add(lastNameLabel, 0, 6);

        // Add a TextField to allow the user to enter their last name
        TextField lastNameField = new TextField();
        gridPane.add(lastNameField, 1, 6);
        // Add a Label to prompt the user to enter their last name
        Label balanceLabel = new Label("balance:");
        gridPane.add(balanceLabel, 0, 7);

        // Add a TextField to allow the user to enter their last name
        TextField balanceField = new TextField();
        gridPane.add(balanceField, 1, 7);

        // Add a Button to submit the account creation form
        Button enterButton = new Button("Enter");
        gridPane.add(enterButton, 1, 8);

        // Set the onAction event of the Enter button to create a new user account
        enterButton.setOnAction(e -> {
                    String ssn = ssnField.getText();
                    String address = addressField.getText();
                    String city = cityField.getText();
                    String state = stateField.getText();
                    String zip = zipField.getText();
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String balance = balanceField.getText();
            System.out.println(ssn + " " + address + " " +city + " " +state +" " + zip +" " + firstName +" " + lastName +" " + balance);
            System.out.println(Customer.setUserID(accountss));
                });

            // Show the GridPane in the new Stage
        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
