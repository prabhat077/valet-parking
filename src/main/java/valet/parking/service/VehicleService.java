package valet.parking.service;

import valet.parking.constant.VehicleEnum;
import valet.parking.model.Vehicle;

/**
 * This serivce will responsible for Entering and Exiting of vehicles.
 * 
 * @author Prabhat Bajpai
 *
 */
public interface VehicleService {

	/**
	 * Allow to park in minimum value available parking lot
	 * 
	 * @param vehicle
	 * @return return vahicle object 
	 */
	Vehicle enter(Vehicle vehicle);

	/**
	 * Need to find out what kind of Vehicle Exitting
	 * 
	 * @param vehicleNumber
	 * @return VehicleEnum or Runtime Exception is VehicalNumber invalid
	 */
	VehicleEnum getVehicalType(String vehicleNumber);

	/**
	 * Allow to Exit a vehical with fee
	 * 
	 * @param vehicleNumber
	 * @param timeToExit
	 * @return return vahicle object or Runtime Exception is vehical no Exist
	 */
	Vehicle exit(String vehicleNumber);

	/**
	 * Calculate parking fee based on parking time
	 * 
	 * @param parkingTime
	 * @return
	 */
	int getFee(Long parkingTime);
}
