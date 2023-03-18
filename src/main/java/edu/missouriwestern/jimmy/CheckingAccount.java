package edu.missouriwestern.jimmy;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckingAccount extends User {


    public CheckingAccount(String firstName, String lastName, String userID, String accountType, String currentBalance, String backup, String overdrafts, String dateCreated) {
        super(firstName, lastName, userID, accountType, currentBalance, backup, overdrafts, dateCreated);
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userID='" + userID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", currentBalance=" + currentBalance +
                ", backup=" + backup +
                ", overdrafts=" + overdrafts +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }
}


