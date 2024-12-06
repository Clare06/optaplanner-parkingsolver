package com.example.parkingsolver.domain;

import com.example.parkingsolver.dto.VehicleDetail;
import com.example.parkingsolver.vehicleinterface.VehicleType;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Vehicle {

    @PlanningId
    private Long id;

    private VehicleDetail vehicleDetail;

    @PlanningVariable(valueRangeProviderRefs = "parkingSlotRange")
    private ParkingSlot parkingSlot;

    public Vehicle() {
    }

    public Vehicle(Long id, VehicleDetail vehicleDetail, ParkingSlot parkingSlot) {
        this.id = id;
        this.vehicleDetail = vehicleDetail;
        this.parkingSlot = parkingSlot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleDetail getVehicleDetail() {
        return vehicleDetail;
    }

    public void setVehicleDetail(VehicleDetail vehicleDetail) {
        this.vehicleDetail = vehicleDetail;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
