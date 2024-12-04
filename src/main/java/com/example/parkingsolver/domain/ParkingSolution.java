package com.example.parkingsolver.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class ParkingSolution {

    @ValueRangeProvider(id = "parkingSlotRange")
    @ProblemFactCollectionProperty
    private List<ParkingSlot> parkslotList;
    @PlanningEntityCollectionProperty
    private List<Vehicle> vehicleList;

    @PlanningScore
    private HardSoftScore score;


    public ParkingSolution() {
    }

    public ParkingSolution(List<ParkingSlot> parkslotList, List<Vehicle> vehicleList, HardSoftScore score) {
        this.parkslotList = parkslotList;
        this.vehicleList = vehicleList;
        this.score = score;
    }

    public List<ParkingSlot> getParkslotList() {
        return parkslotList;
    }

    public void setParkslotList(List<ParkingSlot> parkslotList) {
        this.parkslotList = parkslotList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public HardSoftScore getScore() {
        return score;
    }

}
