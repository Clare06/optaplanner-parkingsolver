package com.example.parkingsolver.solver;

import com.example.parkingsolver.domain.Vehicle;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class ParkingConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[] {
                vehicleOutOfPolygon(factory),
                vehicleBlockingClearance(factory),
        };
    }

    private Constraint vehicleOutOfPolygon(ConstraintFactory factory) {
        return factory.forEach(Vehicle.class)
                .filter(vehicle -> vehicle.getParkingSlot() != null) // Ensure the vehicle has an assigned parking slot
                .filter(vehicle ->
                        vehicle.getParkingSlot().isInsidePolygon(vehicle)
                )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Don't assign vehicle outside slot");
    }

    private Constraint vehicleBlockingClearance(ConstraintFactory factory) {
        return factory.forEach(Vehicle.class)
                .filter(vehicle -> vehicle.getParkingSlot() != null) // Ensure the vehicle has an assigned parking slot
                .filter(vehicle ->
                        vehicle.getParkingSlot().isClearanceBlocking(vehicle)
                )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Don't assign vehicle blocks clearance");
    }





}