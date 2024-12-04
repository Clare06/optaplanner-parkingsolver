package com.example.parkingsolver;

import com.example.parkingsolver.domain.ParkingSolution;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingsolverApplication {
	SolverFactory<ParkingSolution> solverFactory = SolverFactory.createFromXmlResource(
			"solverConfig.xml");
	Solver<ParkingSolution> solver = solverFactory.buildSolver();
	public static void main(String[] args) {
		SpringApplication.run(ParkingsolverApplication.class, args);
	}

}
