package edu.missouriwestern.jimmy;

import javafx.application.Application;
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

public class User {
    String firstName;
    String lastName;
    String SSN;
    String StreetAddress;
    String Zip;
    String city;
    String State;
    String balance;
    String userID;
    String accountType;
    String currentBalance;
    String backup;
    String overdrafts;
    String dateCreated;


    // shooting blanks
    public User(){}

    // Customer Constructor
    public User(String firstName, String lastName, String SSN, String StreetAddress, String Zip, String city, String State , String balance, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.StreetAddress = StreetAddress;
        this.Zip = Zip;
        this.city = city;
        this.State = State;
        this.balance = balance;
        this.accountType = accountType;
    }


    // Checking Account Constructor
    public User(String firstName, String lastName, String userID, String accountType, String currentBalance, String backup, String overdrafts, String dateCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.backup = backup;
        this.overdrafts = overdrafts;
        this.dateCreated = dateCreated;

    }



    static List<CheckingAccount> readAccountsFromCSV(String filePath) {
        List<CheckingAccount> accounts = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                String firstName = data[0];
                String lastName = data[1];
                String userID = data[2];
                String accountType = data[3];
                String currentBalance = data[4];
                String backup = data[5];
                String overdrafts = data[6];
                String dateCreated = data[7];
                CheckingAccount account = new CheckingAccount(firstName, lastName, userID, accountType, currentBalance, backup, overdrafts, dateCreated);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    static List<Customer> readAccountsFromCSV1(String filePath) {
        List<Customer> accounts = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data1 = line.split(cvsSplitBy);
                String SSN = data1[0];
                String StreetAddress = data1[1];
                String City = data1[2];
                String State = data1[3];
                String Zip = data1[4];
                String FirstName = data1[5];
                String LastName = data1[6];
                String balance = data1[7];
                Customer account = new Customer(FirstName,  LastName,  SSN,  StreetAddress,  Zip,  City,  State ,  balance);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public void newStage(List<CheckingAccount> accounts) throws Exception {
        // Create a new Stage
        Stage stage = new Stage();
        stage.setTitle("Login");

        // Create a GridPane to hold the login controls
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add a Label to prompt the user to enter their ID
        Label idLabel = new Label("ID:");
        gridPane.add(idLabel, 0, 0);

        // Add a TextField to allow the user to enter their ID
        TextField idField = new TextField();
        gridPane.add(idField, 1, 0);

        // Add a Button to submit the login form
        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1, 1);

        // Add a Button to create a new user account
        Button newAccountButton = new Button("New User");
        gridPane.add(newAccountButton, 2, 2);

        // Set the onAction event of the Login button to perform the login validation logic
        loginButton.setOnAction(e -> {
            String id = idField.getText();
            boolean validId = false;
            for (CheckingAccount account : accounts) {
                if (id.equals(account.getUserID())) {
                    System.out.println(id);
                    validId = true;
                    break;
                }
            }
            if (!validId) {
                System.out.println("Please enter a valid ID");
            }
        });

        // Set the onAction event of the New User button to create a new user account
        newAccountButton.setOnAction(e -> {
            CustomerStage customerUI = new CustomerStage();
            try {
                customerUI.newStage1(readAccountsFromCSV("C:/Users/jimmy/Downloads/CSC406team2.csv"),readAccountsFromCSV1("C:/Users/jimmy/Downloads/CSC406UserData.csv"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            //System.out.println("create an account");
        });

        // Show the GridPane in the new Stage
        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
