package com.nik.parking;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.nik.parking.model.Level;
import com.nik.parking.model.ParkingLot;
import com.nik.parking.model.Spot;

@SpringBootApplication
public class ParkingApplication {
	@Autowired
	private ParkingLot parkingLot;

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		designParkingLot();
	}

	private void designParkingLot() {
		Spot spot1 = new Spot(1, "Bike", true, null);
		Spot spot2 = new Spot(2, "Car", true, null);
		Spot spot3 = new Spot(3, "Bike", true, null);
		Spot spot4 = new Spot(4, "Car", true, null);

		List<Spot> l1Spot = Arrays.asList(spot1, spot2);
		List<Spot> l2Spot = Arrays.asList(spot3, spot4);

		Level level1 = new Level("level-1", l1Spot, 4);
		Level level2 = new Level("level-2", l2Spot, 4);

		List<Level> levels = Arrays.asList(level1, level2);
		System.out.println("Parking set up completed");
		parkingLot.setLevels(levels);

	}

}
