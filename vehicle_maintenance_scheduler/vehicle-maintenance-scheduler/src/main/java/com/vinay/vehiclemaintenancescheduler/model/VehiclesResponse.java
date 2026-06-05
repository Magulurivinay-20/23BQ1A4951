package com.vinay.vehiclemaintenancescheduler.model;

import java.util.List;

public class VehiclesResponse {

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}