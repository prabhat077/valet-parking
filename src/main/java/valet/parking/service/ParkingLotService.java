package valet.parking.service;

import java.util.Map;

import valet.parking.model.Vehicle;

/**
 * This service will provide map containing information of parked Vehicles.
 * 
 * @author Prabhat Bajpai
 *
 */
public interface ParkingLotService {

	/**
	 * In Future we might need to use Cuncurrent or Syncronous hash map if we allow
	 * multi threading
	 * 
	 * @return
	 */
	Map<String, Vehicle> getParkingLot();

}
