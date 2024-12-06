package com.example.parkingsolver.dto;

import com.example.parkingsolver.vehicleinterface.VehicleType;

public class VehicleDetail {
    private VehicleType type;
    private double width;
    private double height;

    private double clearanceHorizontal;
    private double clearanceVertical;

    public VehicleDetail(VehicleType type) {
        this.type = type;
        switch (type) {
            case CAR:
                this.width = 1.8;
                this.height = 1.5;
                this.clearanceHorizontal = 2.1;
                this.clearanceVertical = 0.75;   // 0.2 top + 0.2 bottom
                break;
            case MOTORCYCLE:
                this.width = 0.8;
                this.height = 1.1;
                this.clearanceHorizontal = 1; // 0.2 left + 0.2 right
                this.clearanceVertical = 0.55;   // 0.2 top + 0.2 bottom
                break;
            case TRUCK:
                this.width = 2.5;
                this.height = 3.5;
                this.clearanceHorizontal = 3; // 0.5 left + 0.5 right
                this.clearanceVertical = 1.8;   // 0.4 top + 0.4 bottom
                break;
            case BUS:
                this.width = 2.6;
                this.height = 3.2;
                this.clearanceHorizontal = 3.1; // 0.5 left + 0.5 right
                this.clearanceVertical = 1.8;   // 0.4 top + 0.4 bottom
                break;
            case BICYCLE:
                this.width = 0.6;
                this.height = 1.2;
                this.clearanceHorizontal = 0.8; // 0.2 left + 0.2 right
                this.clearanceVertical = 0.6;   // 0.2 top + 0.2 bottom
                break;
            case VAN:
                this.width = 2.0;
                this.height = 2.5;
                this.clearanceHorizontal = 2.3; // 0.3 left + 0.3 right
                this.clearanceVertical = 1.25;   // 0.3 top + 0.3 bottom
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public VehicleDetail() {
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

    public double getClearanceHorizontal() {
        return clearanceHorizontal;
    }

    public void setClearanceHorizontal(double clearanceHorizontal) {
        this.clearanceHorizontal = clearanceHorizontal;
    }

    public double getClearanceVertical() {
        return clearanceVertical;
    }

    public void setClearanceVertical(double clearanceVertical) {
        this.clearanceVertical = clearanceVertical;
    }
}
