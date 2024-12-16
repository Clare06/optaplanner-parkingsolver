package com.example.parkingsolver.domain;

import com.example.parkingsolver.dto.AssignedPosition;
import com.example.parkingsolver.dto.LineCoordinate;
import com.example.parkingsolver.dto.VehicleDetail;
import com.example.parkingsolver.dto.VerticeCoordinate;
import com.example.parkingsolver.vehicleinterface.DirectionType;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class ParkingSlot {

    private Long id;
    private List<VerticeCoordinate> polygonVertices;
    private List<LineCoordinate> entranceLineCoordinates;
    private List<ParkingPosition> parkedPositions;
    private AssignedPosition assignedPosition;

    public ParkingSlot() {
    }

    public ParkingSlot(Long id, List<VerticeCoordinate> polygonVertices, List<LineCoordinate> entranceLineCoordinates, List<ParkingPosition> parkedPositions, AssignedPosition assignedPosition) {
        this.id = id;
        this.polygonVertices = polygonVertices;
        this.entranceLineCoordinates = entranceLineCoordinates;
        this.parkedPositions = parkedPositions;
        this.assignedPosition = assignedPosition;
    }

    public Boolean isInsidePolygon(Vehicle vehicle) {
        List<VerticeCoordinate> vehiclePolygon = this.getVehiclePolygonVertices(vehicle);

        Path2D.Double polygon = new Path2D.Double();
        if (!polygonVertices.isEmpty()) {
            VerticeCoordinate first = polygonVertices.get(0);
            polygon.moveTo(first.getX(), first.getY());
            for (int i = 1; i < polygonVertices.size(); i++) {
                VerticeCoordinate vertex = polygonVertices.get(i);
                polygon.lineTo(vertex.getX(), vertex.getY());
            }
            polygon.closePath();
        }

        for (VerticeCoordinate point : vehiclePolygon) {
            if (!polygon.contains(point.getX(), point.getY())) {
                return true;
            }
        }
        return false;
    }

    public Boolean isClearanceBlocking(Vehicle vehicle) {
        for (ParkingPosition parkingPosition : parkedPositions) {
            if (parkingPosition.getParkedVehicle().getWidth() > vehicle.getVehicleDetail().getWidth()) {
                VerticeCoordinate clearanceLineVertice2 = parkingPosition.getParkingVertices().get(0);
                VerticeCoordinate clearanceLineVertice1 = new VerticeCoordinate(parkingPosition.getParkingVertices().get(0).getX() - parkingPosition.getParkedVehicle().getClearanceHorizontal(), parkingPosition.getParkingVertices().get(0).getY());
                DirectionType directionType = this.assignedPosition.getDirection();
                Double x = null;
                switch (directionType) {
                    case TOP:
                        x = this.assignedPosition.getAssignedVertice().getX() + vehicle.getVehicleDetail().getWidth();
                      break;
                    case LEFT:
                        x = this.assignedPosition.getAssignedVertice().getX() - vehicle.getVehicleDetail().getWidth();

                }
                if( x != null){
                    if (x > clearanceLineVertice1.getX() && x < clearanceLineVertice2.getX()) {
                        return true;
                    }

                }

            }
        }
        return false;

    }
    private List<VerticeCoordinate> getVehiclePolygonVertices (Vehicle vehicle){
        List<VerticeCoordinate> polygonVertices = new ArrayList<>();
        VehicleDetail vd = vehicle.getVehicleDetail();
        polygonVertices.add(this.assignedPosition.getAssignedVertice());
        DirectionType directionType = this.assignedPosition.getDirection();
        Double x = this.assignedPosition.getAssignedVertice().getX();
        Double y = this.assignedPosition.getAssignedVertice().getY();
        switch (directionType) {
            case TOP:
                polygonVertices.add(new VerticeCoordinate(x, y+vd.getHeight()));
                polygonVertices.add(new VerticeCoordinate(x + vd.getWidth(), y));
                polygonVertices.add(new VerticeCoordinate(x + vd.getWidth(), y+vd.getHeight()));
                break;
//            case BOTTOM:
//                polygonVertices.add(new VerticeCoordinate(x, y-vd.getHeight()));
//                polygonVertices.add(new VerticeCoordinate(x - vd.getWidth(), y));
//                polygonVertices.add(new VerticeCoordinate(x - vd.getWidth(), y-vd.getHeight()));
//                break;
            case LEFT:
                polygonVertices.add(new VerticeCoordinate(x-vd.getWidth(), y));
                polygonVertices.add(new VerticeCoordinate( x, y-vd.getHeight()));
                polygonVertices.add(new VerticeCoordinate(x-vd.getWidth(), y-vd.getHeight()));
                break;
//            case RIGHT:
//                polygonVertices.add(new VerticeCoordinate(x+vd.getWidth(), y));
//                polygonVertices.add(new VerticeCoordinate( x, y+vd.getHeight()));
//                polygonVertices.add(new VerticeCoordinate(x+vd.getWidth(), y+vd.getHeight()));
//                break;
            default:

                break;
        }

        return polygonVertices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VerticeCoordinate> getPolygonVertices() {
        return polygonVertices;
    }

    public void setPolygonVertices(List<VerticeCoordinate> polygonVertices) {
        this.polygonVertices = polygonVertices;
    }

    public List<LineCoordinate> getEntranceLineCoordinates() {
        return entranceLineCoordinates;
    }

    public void setEntranceLineCoordinates(List<LineCoordinate> entranceLineCoordinates) {
        this.entranceLineCoordinates = entranceLineCoordinates;
    }

    public List<ParkingPosition> getParkedPositions() {
        return parkedPositions;
    }

    public void setParkedPositions(List<ParkingPosition> parkedPositions) {
        this.parkedPositions = parkedPositions;
    }

    public AssignedPosition getAssignedPosition() {
        return assignedPosition;
    }

    public void setAssignedPosition(AssignedPosition assignedPosition) {
        this.assignedPosition = assignedPosition;
    }
}
