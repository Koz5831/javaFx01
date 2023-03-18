package edu.missouriwestern.jimmy;

import java.util.List;

public class Customer extends User {

    public Customer(String firstName, String lastName, String SSN, String StreetAddress, String Zip, String city, String State , String balance) {
        super(firstName, lastName, SSN, StreetAddress, Zip, city, State, balance, "Customer");
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", accountType='" + this.SSN + '\'' +
                ", currentBalance=" + StreetAddress +
                ", backup=" + Zip +
                ", overdrafts=" + city +
                ", dateCreated='" + State + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
    public static String setUserID(List<CheckingAccount> accounts) {
        // get the last account in the dataset
        CheckingAccount lastAccount = accounts.get(accounts.size() -1);
        // get id of last account and parse to an int
        int lastID = Integer.parseInt(lastAccount.getUserID());
        // return new id
        return Integer.toString(lastID+1);
    }
}


