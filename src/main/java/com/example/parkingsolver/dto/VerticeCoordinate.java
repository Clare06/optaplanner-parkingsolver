package com.example.parkingsolver.dto;

public class VerticeCoordinate {
    private Double x;
    private Double y;

    public VerticeCoordinate() {
    }

    public VerticeCoordinate(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
