package com.example.parkingsolver.domain;

import com.example.parkingsolver.vehicleinterface.VehicleType;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Vehicle {

    @PlanningId
    private Long id;

    private VehicleType type;
    private double width;
    private double height;

    private double clearanceLeft;
    private double clearanceRight;

    @PlanningVariable(valueRangeProviderRefs = "parkingSlotRange")
    private ParkingSlot parkingSlot;

    public Vehicle() {
    }

    public Vehicle(Long id, ParkingSlot parkingSlot, double clearanceRight, double clearanceLeft, double height, double width, VehicleType type) {
        this.id = id;
        this.parkingSlot = parkingSlot;
        this.clearanceRight = clearanceRight;
        this.clearanceLeft = clearanceLeft;
        this.height = height;
        this.width = width;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getClearanceLeft() {
        return clearanceLeft;
    }

    public void setClearanceLeft(double clearanceLeft) {
        this.clearanceLeft = clearanceLeft;
    }

    public double getClearanceRight() {
        return clearanceRight;
    }

    public void setClearanceRight(double clearanceRight) {
        this.clearanceRight = clearanceRight;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

}
