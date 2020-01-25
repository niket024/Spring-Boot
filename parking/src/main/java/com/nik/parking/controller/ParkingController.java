package com.nik.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nik.parking.model.ParkingLot;
import com.nik.parking.model.Vehicle;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	@Autowired
	private ParkingLot parkingLot;

	@GetMapping(value = "/getVehicles", headers = "Accept=application/json")
	public List<Vehicle> welcome() {
		return parkingLot.getVehicles();
	}

	@GetMapping("/total")
	public int totalVehicles() {
		return parkingLot.getTotalVehicle();
	}

	@GetMapping("/totalMotors")
	public int totalMotors() {
		return parkingLot.getTotalMotors();
	}

	@GetMapping("/totalCars")
	public int totalCars() {
		return parkingLot.getTotalCars();
	}

	@PostMapping(value = "/assign", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> assignSpot(@RequestBody Vehicle vehicle) {
		String msg = "";
		if (parkingLot.isparkingFull()) {
			msg = "Parking is full";
		} else {
			msg = parkingLot.assignSpot(vehicle);
		}

		return ResponseEntity.ok(msg);
	}

	@PostMapping(value = "/release", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> releaseSpot(@RequestBody Vehicle vehicle) {
		String msg = parkingLot.releaseSpot(vehicle);
		return ResponseEntity.ok(msg);
	}
}
