package com.nik.parking.model;

public class Vehicle {
	private String vehicleNo;
	private String VehicleName;
	private String vehicleSize;
	private String vehicleType;
	private int SpotsNeedd;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return VehicleName;
	}

	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

	public String getVehicleSize() {
		return vehicleSize;
	}

	public void setVehicleSize(String vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getSpotsNeedd() {
		return SpotsNeedd;
	}

	public void setSpotsNeedd(int spotsNeedd) {
		SpotsNeedd = spotsNeedd;
	}

}
