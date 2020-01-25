package com.nik.parking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.authenticator.SingleSignOn;
import org.springframework.stereotype.Service;

@Service
public class ParkingLot {
	private List<Level> levels;

	public ParkingLot(List<Level> levels) {
		this.levels = levels;
	}

	private int totalVehicle;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public String assignSpot(Vehicle vehicle) {
		Level level = getAvailableLevel();
		if (level != null) {
			Spot spot = getParkingSpot(level);
			if (spot.isSpotFree()) {
				spot.setVehicle(vehicle);
				spot.setSpotFree(false);
				vehicles.add(vehicle);
				totalVehicle++;
				String msg = "Vehicle assigned to level:" + level.getLeveName() + " and spot No.: " + spot.getSpotNo();
				System.out.println(msg);
				return msg;

			} else {
				return "No space";
			}
		} else {
			return "All levels are full";
		}

	}

	public Level getAvailableLevel() {
		Level level = null;
		for (Level l : levels) {
			if (getLevelCapactiy(l) >= 80) {
				level = l;
				break;
			}
		}
		return level;
	}

	public String releaseSpot(Vehicle vehicle) {
		String msg = "";
		if (vehicles.removeIf(v -> v.getVehicleNo().equals(vehicle.getVehicleNo()))) {
			makeSpotAvailable(vehicle);
			totalVehicle--;
			msg = "Vehicle no. " + vehicle.getVehicleNo() + " is released";
			System.out.println(msg);
		} else {
			msg = "No vehicle is found with vehicle no. " + vehicle.getVehicleNo();
		}
		System.out.println(msg);
		return msg;
	}

	private void makeSpotAvailable(Vehicle vehicle) {
		levels.stream().forEach((l) -> l.getSpots().stream().forEach(s -> s.setSpotFree(true)));
	}

	public Spot getParkingSpot(Level level) {
		return level.getSpots().stream().filter(s -> s.isSpotFree()).collect(Collectors.toList()).get(0);
	}

	public boolean isparkingFull() {
		//levels.stream().forEach((l)->l.getSpots().stream().filter(s->s.isSpotFree()).collect(Collectors.toList()));
		boolean status = true;
		for (Level l : levels) {
			for (Spot s : l.getSpots()) {
				if (s.isSpotFree()) {
					status = false;
					break;
				}
			}
		}
		return status;
	}

	public int getTotalVehicle() {
		return totalVehicle;
	}

	public int getLevelCapactiy(Level level) {
		double currentCapacity = 100.0;
		int capacity = level.getCapacity();
		int vehicles = (int) level.getSpots().stream().filter(s -> !s.isSpotFree()).count();
		if (vehicles > 0) {
			double v = vehicles;
			double c = capacity;
			currentCapacity = (v / c) * 100;
		}
		return (int) currentCapacity;
	}

	public int getTotalMotors() {
		return (int) vehicles.stream().filter(v -> v.getVehicleType().equalsIgnoreCase("Bike")).count();
	}

	public int getTotalCars() {
		return (int) vehicles.stream().filter(v -> v.getVehicleType().equalsIgnoreCase("Car")).count();
	}
}
