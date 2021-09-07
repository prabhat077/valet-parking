package valet.parking.service.impl;

import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import valet.parking.constant.ValetParkingConstant;
import valet.parking.constant.VehicleEnum;
import valet.parking.model.Vehicle;
import valet.parking.service.EmptyParkingLotService;
import valet.parking.service.ParkingLotService;
import valet.parking.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	int capacity;
	int currCapacity;
	int parkingFee;
	Queue<Integer> emptyParkingLot;
	Map<String, Vehicle> parkingLot;


	/**
	 * Need this constuctor to find type of vehicle when exitting
	 * 
	 * @param parkingLot
	 */
	public VehicleServiceImpl(ParkingLotService parkingLotService) {
		this.parkingLot = parkingLotService.getParkingLot();
	}

	/**
	 * Intialize Parking space with Empty parking lot.
	 * 
	 * @param capacity        - capacity of parking space.
	 * @param emptyParkingLot - contain free parkingLot info
	 */
	public VehicleServiceImpl(ParkingLotService parkingLotService, EmptyParkingLotService emptyParkingLotService,
			int capacity, int parkingFee) {
		this.parkingLot = parkingLotService.getParkingLot();
		this.emptyParkingLot = emptyParkingLotService.getEmptyParkingLot();

		this.capacity = capacity;
		this.parkingFee = parkingFee;
		this.currCapacity = 0;
	}

	@Override
	public Vehicle enter(Vehicle vehicle) {
		if (Objects.nonNull(parkingLot.get(vehicle.getVehicleNumber()))) {
			throw new IllegalArgumentException(ValetParkingConstant.ALREADY_EXIST + vehicle.getVehicleNumber());
		}
		/*
		 * If lot is full
		 */
		if (currCapacity == capacity) {
			return vehicle;
		} else {
			/*
			 * Priority Queue will get the min available free parking slot
			 */
			int lotNo = emptyParkingLot.poll();
			vehicle.setLotNumber(lotNo);
			parkingLot.put(vehicle.getVehicleNumber(), vehicle);
			currCapacity++;
			return vehicle;
		}
	}

	@Override
	public VehicleEnum getVehicalType(String vehicleNumber) {
		if (Objects.nonNull(parkingLot.get(vehicleNumber))) {
			Vehicle vehicle = parkingLot.get(vehicleNumber);
			return vehicle.getVehicleType();
		} else {
			throw new IllegalArgumentException(ValetParkingConstant.INVALID_VEHICLE + vehicleNumber);
		}
	}

	@Override
	public Vehicle exit(String vehicleNumber) {
		/*
		 * If VehicalNumber valid than should be in the parkingLot Map
		 */
		if (Objects.nonNull(parkingLot.get(vehicleNumber))) {
			Vehicle vehicle = parkingLot.get(vehicleNumber);
			parkingLot.remove(vehicleNumber);
			currCapacity--;
			emptyParkingLot.add(vehicle.getLotNumber());
			return vehicle;
		}
		throw new IllegalArgumentException(ValetParkingConstant.INVALID_VEHICLE + vehicleNumber);
	}

	@Override
	public int getFee(Long parkingTime) {
		return (int) (Math.ceil((double) parkingTime / (60 * 60))) * this.parkingFee;
	}

}
