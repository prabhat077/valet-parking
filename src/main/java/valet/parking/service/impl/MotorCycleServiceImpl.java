package valet.parking.service.impl;

import valet.parking.service.EmptyParkingLotService;
import valet.parking.service.ParkingLotService;

/**
 * This class only be here if there is something specific to Vehicle type
 *
 * @author Prabhat Bajpai
 *
 */
public class MotorCycleServiceImpl extends VehicleServiceImpl {
	
	public MotorCycleServiceImpl(ParkingLotService parkingLotService, EmptyParkingLotService emptyParkingLotService,
			int capacity, int parkingFee) {
		super(parkingLotService, emptyParkingLotService, capacity, parkingFee);
	}
}
