package valet.parking.model;

import valet.parking.constant.VehicleEnum;

/**
 * MotorCycle is currently inheriting all the properties from Vehicle.
 *
 * @author Prabhat Bajpai
 *
 */
public class Motorcycle extends Vehicle{

	public Motorcycle(VehicleEnum vehicleType, String vehicleNumber, long timeToEnter) {
		super(vehicleType, vehicleNumber, timeToEnter);
	}
}
