package valet.parking.model;

import valet.parking.constant.VehicleEnum;

/**
 * Car is currently inheriting all the properties from Vehicle.
 * 
 * @author Prabhat Bajpai
 *
 */
public class Car extends Vehicle{

	public Car(VehicleEnum vehicleType, String vehicleNumber, long timeToEnter) {
		super(vehicleType, vehicleNumber, timeToEnter);
	}
}
