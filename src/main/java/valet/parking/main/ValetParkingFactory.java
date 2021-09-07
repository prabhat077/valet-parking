package valet.parking.main;

import valet.parking.constant.ParkingOperationEnum;
import valet.parking.constant.VehicleEnum;
import valet.parking.model.Car;
import valet.parking.model.Motorcycle;
import valet.parking.model.Vehicle;
import valet.parking.service.EmptyParkingLotService;
import valet.parking.service.ParkingLotService;
import valet.parking.service.VehicleService;
import valet.parking.service.impl.CarServiceImpl;
import valet.parking.service.impl.EmptyParkingLotServiceImpl;
import valet.parking.service.impl.MotorCycleServiceImpl;
import valet.parking.service.impl.ParkingLotServiceImpl;
import valet.parking.service.impl.VehicleServiceImpl;
import valet.parking.util.InputHandlerServiceUtil;
import valet.parking.util.OutputHandlerServiceUtil;

/**
 * This Factory will responsible to initializing services baseed on Input and
 * also forward the input queries to respective services.
 * 
 * @author Prabhat Bajpai
 *
 */
public class ValetParkingFactory {

	ParkingLotService parkingLotService;;
	EmptyParkingLotService carEmptyParkingLotService;
	EmptyParkingLotService motorbikeEmptyParkingLotService;
	VehicleService vehicleService;
	VehicleService carService;
	VehicleService motorcycleService;

	public static int MOTOR_BIKE_PARKING_FEE = 1;
	public static int CAR_PARKING_FEE = 2;

	public void initializeService(int carCapacity, int motorbikeCapacity) {

		parkingLotService = new ParkingLotServiceImpl(motorbikeCapacity + carCapacity);
		/*
		 * This service to get type of Vehical
		 */
		vehicleService = new VehicleServiceImpl(parkingLotService);

		carEmptyParkingLotService = new EmptyParkingLotServiceImpl(carCapacity);
		/*
		 * Initialize Car and Motorbike Serivce
		 */
		carService = new CarServiceImpl(parkingLotService, carEmptyParkingLotService, carCapacity, CAR_PARKING_FEE);

		/*
		 * Initialize Car and Motorbike Serivce
		 */
		motorbikeEmptyParkingLotService = new EmptyParkingLotServiceImpl(motorbikeCapacity);
		motorcycleService = new MotorCycleServiceImpl(parkingLotService, motorbikeEmptyParkingLotService,
				motorbikeCapacity, MOTOR_BIKE_PARKING_FEE);

	}

	public void execute(String[] input) {

		Vehicle vehicle = null;
		if (ParkingOperationEnum.ENTER.getName().equals(input[0])
				&& VehicleEnum.MOTOTCYCLE.getVehicleNameInput().equals(input[1])) {
			vehicle = motorcycleService
					.enter(new Motorcycle(VehicleEnum.MOTOTCYCLE, input[2], Long.parseLong(input[3])));
			OutputHandlerServiceUtil.displayVehicleEnter(vehicle);

		} else if (ParkingOperationEnum.ENTER.getName().equals(input[0])
				&& VehicleEnum.CAR.getVehicleNameInput().equals(input[1])) {
			vehicle = carService.enter(new Car(VehicleEnum.CAR, input[2], Long.parseLong(input[3])));
			OutputHandlerServiceUtil.displayVehicleEnter(vehicle);

		} else if (ParkingOperationEnum.EXIT.getName().equals(input[0])) {
			int parkingFee;
			VehicleEnum vehicleType = vehicleService.getVehicalType(input[1]);

			if (VehicleEnum.MOTOTCYCLE.equals(vehicleType)) {
				vehicle = motorcycleService.exit(input[1]);
				parkingFee = motorcycleService.getFee(Long.parseLong(input[2]) - vehicle.getTimeToEnter());
				OutputHandlerServiceUtil.displayVehicleExit(vehicle, parkingFee);
			} else {
				vehicle = carService.exit(input[1]);
				parkingFee = carService.getFee(Long.parseLong(input[2]) - vehicle.getTimeToEnter());
				OutputHandlerServiceUtil.displayVehicleExit(vehicle, parkingFee);
			}
		}

	}

}
