package com.nik.parking.model;

public class Spot {
	private int spotNo;
	private String spotType;
	private boolean isSpotFree;
	private Vehicle vehicle;

	public Spot(int spotNo, String spotType, boolean isSpotFree, Vehicle vehicle) {
		super();
		this.spotNo = spotNo;
		this.spotType = spotType;
		this.isSpotFree = isSpotFree;
		this.vehicle = vehicle;
	}

	public int getSpotNo() {
		return spotNo;
	}

	public void setSpotNo(int spotNo) {
		this.spotNo = spotNo;
	}

	public String getSpotType() {
		return spotType;
	}

	public void setSpotType(String spotType) {
		this.spotType = spotType;
	}

	public boolean isSpotFree() {
		return isSpotFree;
	}

	public void setSpotFree(boolean isSpotFree) {
		this.isSpotFree = isSpotFree;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
