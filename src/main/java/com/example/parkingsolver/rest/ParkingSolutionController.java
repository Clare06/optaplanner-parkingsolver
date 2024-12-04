package com.example.parkingsolver.rest;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.example.parkingsolver.domain.ParkingSolution;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ParkingSolution")
public class ParkingSolutionController {

    @Autowired
    private SolverManager<ParkingSolution, UUID> solverManager;

    @PostMapping("/solve")
    public ParkingSolution solve(@RequestBody ParkingSolution problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving
        SolverJob<ParkingSolution, UUID> solverJob = solverManager.solve(problemId, problem);
        ParkingSolution solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }

}