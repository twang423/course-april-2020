package com.company;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DesignPatternPractice {
    public static void main(String[] args) {

    }

}

class AppleDesignerFactory implements Serializable, Cloneable{
    private static AppleDesignerFactory instance;
    private AppleDesignerFactory() {

    }
    public static synchronized AppleDesignerFactory getInstance() {
        if (instance == null) {
            instance = new AppleDesignerFactory();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return instance;
    }
}

class Currency {

}

class USD extends Currency {

}

class RMB extends Currency {

}

class CurrencyExchange {
    public static Currency makeCurrency(String country) {
        if ("USA".equals(country))
            return new USD();
        if ("China".equals(country))
            return new RMB();

        return null;
    }
}

class ParkingLot implements Serializable, Cloneable{
    // singleton
    private static ParkingLot instance;
    private ParkingLot() {

    }
    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected ParkingLot readResolve() {
        return instance;
    }

    private static List<ParkingSpot> parkingSpots;
    private int capacity;

    public int load() {
        return 0;
    }
    public int unload() {
        return 0;
    }
}

class ParkingSpot {

    private int number;
    private boolean handicapped;
    private Size parkingSpotSize;
    private boolean occupied;
    private double rate;

}

class Vehicle {
    private String LicensePlate;
    private Date enterTime;
    Size VehicleSize;

}

class Payment {

}

enum Size {SMALL, LARGE}