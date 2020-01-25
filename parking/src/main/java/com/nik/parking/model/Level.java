package com.nik.parking.model;

import java.util.List;

public class Level {
	private String leveName;
	private List<Spot> spots;
	private int capacity;

	public Level(String leveName, List<Spot> spots, int capacity) {
		super();
		this.leveName = leveName;
		this.spots = spots;
		this.capacity = capacity;
	}

	public String getLeveName() {
		return leveName;
	}

	public void setLeveName(String leveName) {
		this.leveName = leveName;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
