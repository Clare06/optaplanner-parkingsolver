package com.example.parkingsolver.dto;

public class LineCoordinate {
    private VerticeCoordinate point1;
    private VerticeCoordinate point2;

    public LineCoordinate() {
    }

    public LineCoordinate(VerticeCoordinate point1, VerticeCoordinate point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public VerticeCoordinate getPoint1() {
        return point1;
    }

    public void setPoint1(VerticeCoordinate point1) {
        this.point1 = point1;
    }

    public VerticeCoordinate getPoint2() {
        return point2;
    }

    public void setPoint2(VerticeCoordinate point2) {
        this.point2 = point2;
    }
}
