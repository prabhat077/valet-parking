package valet.parking.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import valet.parking.constant.ValetParkingConstant;
import valet.parking.constant.VehicleEnum;
import valet.parking.model.Vehicle;
import valet.parking.service.impl.CarServiceImpl;
import valet.parking.service.impl.EmptyParkingLotServiceImpl;
import valet.parking.service.impl.MotorCycleServiceImpl;
import valet.parking.service.impl.ParkingLotServiceImpl;
import valet.parking.service.impl.VehicleServiceImpl;
import valet.parking.util.OutputHandlerServiceUtil;

@TestInstance(Lifecycle.PER_CLASS)
class VehicleServiceTest {
	ParkingLotService parkingLotService;;
	EmptyParkingLotService carEmptyParkingLotService;
	EmptyParkingLotService motorbikeEmptyParkingLotService;
	VehicleService vehicleService;
	VehicleService carService;
	VehicleService motorcycleService;

	public static int MOTOR_BIKE_PARKING_FEE = 1;
	public static int CAR_PARKING_FEE = 2;
	
	
	@BeforeAll
	void setup() {
		int carCapacity = 3;
		int motorbikeCapacity = 4;
		parkingLotService = new ParkingLotServiceImpl(motorbikeCapacity + carCapacity);
		vehicleService = new VehicleServiceImpl(parkingLotService);

		carEmptyParkingLotService = new EmptyParkingLotServiceImpl(carCapacity);
		carService = new CarServiceImpl(parkingLotService, carEmptyParkingLotService, carCapacity, CAR_PARKING_FEE);

		motorbikeEmptyParkingLotService = new EmptyParkingLotServiceImpl(motorbikeCapacity);
		motorcycleService = new MotorCycleServiceImpl(parkingLotService, motorbikeEmptyParkingLotService,
				motorbikeCapacity, MOTOR_BIKE_PARKING_FEE);
	}
	
	@Test
	void verifyEnterExitCar_test() {
		// Car capcity is 3 so first 3 car should return 1, 2, 3 lot no 4th should return 0(REJECT) lot no
		Vehicle vehicle1 = carService.enter(new Vehicle(VehicleEnum.CAR, "SGF9283P", 1613541902));
		// Assign to lot 1
		Assertions.assertEquals(vehicle1.getLotNumber(), 1);

		// Assign to lot 2
		Vehicle vehicle2 = carService.enter(new Vehicle(VehicleEnum.CAR, "SGP2937F", 1613546029));
		Assertions.assertEquals(vehicle2.getLotNumber(), 2);

		// Assign to lot 3
		Vehicle vehicle3 = carService.enter(new Vehicle(VehicleEnum.CAR, "SDW2111W", 1613549730));
		Assertions.assertEquals(vehicle3.getLotNumber(), 3);

		// Assign to lot 0 mean there is no parking space left
		Vehicle vehicle4 = carService.enter(new Vehicle(VehicleEnum.CAR, "SSD9281L", 1613549740));
		Assertions.assertEquals(vehicle4.getLotNumber(), 0);

		// Vehical1 already in the parking lot so should throw Exception
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> carService.enter(vehicle1));
		String output = exception.getMessage();
		String expectedOutput = ValetParkingConstant.ALREADY_EXIST + vehicle1.getVehicleNumber();
		Assertions.assertEquals(output, expectedOutput);
		
		
		// Now Exit vehicle3 and vehicle1
		carService.exit(vehicle3.getVehicleNumber());
		carService.exit(vehicle2.getVehicleNumber());
		
		// Now lot 2 and 3 are empty so next lots assigned should be minimum 2
		vehicle4 = carService.enter(new Vehicle(VehicleEnum.CAR, "SSD9281L", 1613549740));
		Assertions.assertEquals(vehicle4.getLotNumber(), 2);
		
		// Vahicle Type test
		VehicleEnum outputenum = vehicleService.getVehicalType(vehicle4.getVehicleNumber());
		Assertions.assertTrue(outputenum.equals(VehicleEnum.CAR));

		// Vehicle No not exist so should throw Exception
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> vehicleService.getVehicalType("XYZ"));
		output = exception.getMessage();
		expectedOutput = ValetParkingConstant.INVALID_VEHICLE + "XYZ";
		Assertions.assertEquals(output, expectedOutput);
	}

	@Test
	void verifyEnterMotorcycle_test() {
		Vehicle vehicle1 = motorcycleService.enter(new Vehicle(VehicleEnum.MOTOTCYCLE, "SGX1234A", 1613541902));
		// First Motorcycle Assign to lot 1
		Assertions.assertEquals(vehicle1.getLotNumber(), 1);
	}

}
