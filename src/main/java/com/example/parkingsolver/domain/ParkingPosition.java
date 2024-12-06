package com.example.parkingsolver.domain;

import com.example.parkingsolver.dto.VehicleDetail;
import com.example.parkingsolver.dto.VerticeCoordinate;

import java.util.List;

public class ParkingPosition {
    private VehicleDetail parkedVehicle;
    private List<VerticeCoordinate> parkingVertices;

    public ParkingPosition() {
    }

    public ParkingPosition(VehicleDetail parkedVehicle, List<VerticeCoordinate> parkingVertices) {
        this.parkedVehicle = parkedVehicle;
        this.parkingVertices = parkingVertices;
    }

    public VehicleDetail getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(VehicleDetail parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public List<VerticeCoordinate> getParkingVertices() {
        return parkingVertices;
    }

    public void setParkingVertices(List<VerticeCoordinate> parkingVertices) {
        this.parkingVertices = parkingVertices;
    }
}
