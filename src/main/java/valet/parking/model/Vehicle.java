package valet.parking.model;

import valet.parking.constant.VehicleEnum;

/**
 * Vehicle class contain all the vehicle information related to parking. All the
 * instanse variable will be set by constructor except lotNo. lotNo allow set
 * function and it will be set once Vehicle parked.
 * 
 * @author Prabhat Bajpai
 *
 */
public class Vehicle {
	private VehicleEnum vehicleType;
	private String vehicleNumber;
	private long timeToEnter;
	private int lotNumber;

	public Vehicle(VehicleEnum vehicleType, String vehicleNumber, long timeToEnter) {
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.timeToEnter = timeToEnter;
	}

	public VehicleEnum getVehicleType() {
		return vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public long getTimeToEnter() {
		return timeToEnter;
	}

	public int getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(int lotNumber) {
		this.lotNumber = lotNumber;
	}
}
