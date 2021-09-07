package valet.parking.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import valet.parking.constant.ValetParkingConstant;
import valet.parking.constant.VehicleEnum;
import valet.parking.model.Vehicle;

/**
 * OutputHandlerServiceUtil is display service it only check if parkinng fee is
 * negative
 * 
 * @author Prabhat Bajpai
 *
 */

public class OutputHandlerServiceUtilTest {

	@Test
	void verifyDisplay_success() {
		
		// Display Exit vehicle case mock Vehicle class
		Vehicle vehicle = new Vehicle(VehicleEnum.MOTOTCYCLE, "XYZ", 1613546029);
		vehicle.setLotNumber(1);
		int parkingFee = 1;

		// If Vehicle class is valid and parkinng fee is positive
		String output = OutputHandlerServiceUtil.displayVehicleExit(vehicle, parkingFee);
		String expectedOutput = "MotorcycleLot1 1";
		Assertions.assertEquals(output, expectedOutput);
		
		// Display Enter vehicle case mock Vehicle class
		output = OutputHandlerServiceUtil.displayVehicleEnter(vehicle);
		expectedOutput = "Accept MotorcycleLot1";
		Assertions.assertEquals(output, expectedOutput);

		// If lot is full it will display lotNo = 0 and result as Reject
		vehicle.setLotNumber(0);
		output = OutputHandlerServiceUtil.displayVehicleEnter(vehicle);
		expectedOutput = "Reject";
		Assertions.assertEquals(output, expectedOutput);

	}

	@Test
	void verifyParkingFee_fail() {
		Vehicle vehicle = new Vehicle(VehicleEnum.MOTOTCYCLE, "XYZ", 1613546029);
		int parkingFee = -1;

		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> OutputHandlerServiceUtil.displayVehicleExit(vehicle, parkingFee));
		String output = exception.getMessage();
		String expectedOutput = ValetParkingConstant.INVALID_TIMESTAMP + vehicle.getVehicleNumber();
		Assertions.assertEquals(output, expectedOutput);
	}

}
