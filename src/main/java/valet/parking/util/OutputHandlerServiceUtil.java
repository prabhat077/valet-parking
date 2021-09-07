package valet.parking.util;

import valet.parking.constant.ValetParkingConstant;
import valet.parking.model.Vehicle;

/**
 * This utility Display output
 * 
 * @author Prabhat Bajpai
 *
 */
public class OutputHandlerServiceUtil {
	private OutputHandlerServiceUtil() {

	}

	public static String displayVehicleEnter(Vehicle vehicle) {
		if (vehicle.getLotNumber() == 0) {
			String str = ValetParkingConstant.REJECT;
			System.out.println(str);
			return str;
		} else {
			String str = ValetParkingConstant.ACCEPT + vehicle.getVehicleType().getVehicleNameOutput()
					+ ValetParkingConstant.LOT + vehicle.getLotNumber();
			System.out.println(str);
			return str;
		}
	}

	public static String displayVehicleExit(Vehicle vehicle, int parkingFee) {
		if (parkingFee > 0) {
			String str = vehicle.getVehicleType().getVehicleNameOutput() + ValetParkingConstant.LOT
					+ vehicle.getLotNumber() + " " + parkingFee;
			System.out.println(str);
			return str;
		} else {
			throw new IllegalArgumentException(ValetParkingConstant.INVALID_TIMESTAMP + vehicle.getVehicleNumber());
		}
	}

}
