package valet.parking.service.impl;

import java.util.HashMap;
import java.util.Map;

import valet.parking.model.Vehicle;
import valet.parking.service.ParkingLotService;

public class ParkingLotServiceImpl implements ParkingLotService {
	private Map<String, Vehicle> parkingLot = null;

	public ParkingLotServiceImpl(int capacity) {
		this.parkingLot = new HashMap<>(capacity);
	}

	@Override
	public Map<String, Vehicle> getParkingLot() {
		return parkingLot;
	}

}
