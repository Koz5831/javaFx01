package edu.missouriwestern.jimmy;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

import static edu.missouriwestern.jimmy.User.readAccountsFromCSV;
import static edu.missouriwestern.jimmy.User.readAccountsFromCSV1;

public class Manager extends User {

    public void newStage(List<CheckingAccount> accounts) throws Exception {
        // Create a new Stage
        Stage stage = new Stage();
        // Create a GridPane to hold the login controls and the table
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a table to display the account details
        TableView<CheckingAccount> table = new TableView<>();
        table.setItems(FXCollections.observableArrayList());

        // Create columns for the table
        TableColumn<CheckingAccount, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<CheckingAccount, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<CheckingAccount, String> userIDCol = new TableColumn<>("User ID");
        userIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));

        TableColumn<CheckingAccount, String> accountTypeCol = new TableColumn<>("Account Type");
        accountTypeCol.setCellValueFactory(new PropertyValueFactory<>("accountType"));

        TableColumn<CheckingAccount, String> currentBalanceCol = new TableColumn<>("Current Balance");
        currentBalanceCol.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));

        TableColumn<CheckingAccount, String> dateCreatedCol = new TableColumn<>("Date Created");
        dateCreatedCol.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

        // Add columns to the table
        table.getColumns().addAll(firstNameCol, lastNameCol, userIDCol, accountTypeCol, currentBalanceCol, dateCreatedCol);

        // Add the table to the grid pane
        gridPane.add(table, 0, 3, 3, 1);

        // Create a new Scene with the GridPane as its root node
        Scene scene = new Scene(gridPane, 800, 600);

        // Set the scene to the Stage
        stage.setScene(scene);

        // Show the stage
        stage.show();

    }
}