package com.example.maintenance;

public abstract class Vehicle {
    protected String vehicleId;
    protected double mileage;

    public Vehicle(String vehicleId, double mileage) {
        this.vehicleId = vehicleId;
        this.mileage = mileage;
    }

    public void updateMileage(double mileage) {
        this.mileage = mileage;
    }
}
