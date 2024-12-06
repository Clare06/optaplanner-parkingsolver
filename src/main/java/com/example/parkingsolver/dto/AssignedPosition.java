package com.example.parkingsolver.dto;

import com.example.parkingsolver.vehicleinterface.DirectionType;

public class AssignedPosition {
    private DirectionType direction;
    private VerticeCoordinate assignedVertice;

    public AssignedPosition() {
    }

    public AssignedPosition(DirectionType direction, VerticeCoordinate assignedVertice) {
        this.direction = direction;
        this.assignedVertice = assignedVertice;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public VerticeCoordinate getAssignedVertice() {
        return assignedVertice;
    }

    public void setAssignedVertice(VerticeCoordinate assignedVertice) {
        this.assignedVertice = assignedVertice;
    }
}
