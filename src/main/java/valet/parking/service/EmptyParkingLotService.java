package valet.parking.service;

import java.util.Queue;

/**
 * This service will provide a Queue returning Emprt Parking spot correspond to
 * perticular Vehicle Type.
 * 
 * @author Prabhat Bajpai
 *
 */
public interface EmptyParkingLotService {

	/**
	 * If we need to use thread safe Queue in Future
	 * 
	 * @return return Queue object with all Parking slot available
	 */
	Queue<Integer> getEmptyParkingLot();

}
