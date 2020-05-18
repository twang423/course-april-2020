package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OOPPractice {
    public static void main(String[] args) {
        System.out.println(MathDemo.sum(5, 10));
        System.out.println(MathDemo.sum(1.4, 5));
        System.out.println(MathDemo.sum(5, 1.4));
        System.out.println(MathDemo.sum(1.4, 2.5));

        VisaCard visa = new VisaCard("Abby", 123456, 1645.48);
        MasterCard master = new MasterCard("Bob", 458216, 1645.48);

        Automobile auto = new Automobile();
        Car car = new Car();
        Truck truck = new Truck();
        System.out.println(auto.tax());
        auto = car;
        System.out.println(auto.tax());
        auto = truck;
        System.out.println(auto.tax());
    }
}

interface DatabaseConnection {
    Connection getConnection(String host, String user, String password) throws ClassNotFoundException;
}

class OracleConnection implements DatabaseConnection {

    private String host;
    private String user;
    private String password;
    Connection conn;

    public Connection getConnection(String host, String user, String password) throws ClassNotFoundException {
        this.host = host;
        this.user = user;
        this.password = password;
        Class.forName ("oracle.jdbc.OracleDriver");
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ host + ":1521:xe", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

class MySqlConnection implements DatabaseConnection {

    private String host;
    private String user;
    private String password;
    Connection conn;

    public Connection getConnection(String host, String user, String password) throws ClassNotFoundException {
        this.host = host;
        this.user = user;
        this.password = password;
        Class.forName ("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+ host + ":3306", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

class SqlServerConnection implements DatabaseConnection {
    public Connection getConnection(String url, String user, String password) {
        return null;
    }
}



abstract class CreditCard {
    protected String holderName;
    protected int cardNumber;
    protected double accountBalance;
    protected String cardType;

    CreditCard(String holderName, int cardNumber, double accountBalance) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
    }

    abstract boolean isCardAcceptable(String cartType);
    public void payBill(double bill) {
        accountBalance -= bill;
    }

}

class VisaCard extends CreditCard {

    VisaCard(String holderName, int cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance);
        this.cardType = "visaCard";
    }

    @Override
    boolean isCardAcceptable(String cardType) {
        return this.cardType.equals(cardType);
    }

}

class MasterCard extends CreditCard {

    MasterCard(String holderName, int cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance);
        this.cardType = "masterCard";
    }

    @Override
    boolean isCardAcceptable(String cardType) {
        return this.cardType.equals(cardType);
    }
}

//static polymorphism
class MathDemo {
    public static int sum(int a, int b) {
        return a + b;
    }
    public static double sum(double a, double b) {
        return a + b;
    }
}

//dynamic polymorphism
class Automobile {
    String tax() {
        return "It depends";
    }
}

class Car extends Automobile {
    String tax() {
        return "5%";
    }
}

class Truck extends Automobile {
    String tax() {
        return "10%";
    }
}