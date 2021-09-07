package valet.parking.util;

import valet.parking.constant.ParkingOperationEnum;
import valet.parking.constant.ValetParkingConstant;
import valet.parking.constant.VehicleEnum;

/**
 * Utilitity function validate each line of input
 * 
 * @author Prabhat Bajpai
 *
 */
public class InputHandlerServiceUtil {
	
	private InputHandlerServiceUtil() {
		
	}
	public static String[] verifyInput(String inputLine, int inputLineNo) {
		String[] input = inputLine.split(" ");
		/**
		 * First line contain number of parking spot available for different vehicle
		 * types.
		 */
		if (inputLineNo == 1) {
			if (input.length != 2) {
				throw new IllegalArgumentException(ValetParkingConstant.INVALID_NO_ARGUMENTS + inputLineNo);
			} else {
				try {
					Integer.parseInt(input[0]);
					Integer.parseInt(input[1]);
				} catch (NumberFormatException e) {
					throw new NumberFormatException(ValetParkingConstant.INVALID_NUMBER_FORMAT + inputLineNo);
				}
			}
			/**
			 * Other lines contain either Enter or Exit vehicle query.
			 */
		} else {
			if ((input.length != 4 || !ParkingOperationEnum.ENTER.getName().equals(input[0])
					|| VehicleEnum.getVehicleEnum(input[1]) == null)
					&& ((input.length != 3) || (!ParkingOperationEnum.EXIT.getName().equals(input[0])))) {
				throw new IllegalArgumentException(ValetParkingConstant.INVALID_LINE + inputLineNo);
			} else {
				try {
					if (input.length == 4) {
						Long.parseLong(input[3]);
					} else {
						Long.parseLong(input[2]);
					}
				} catch (NumberFormatException e) {
					throw new NumberFormatException(ValetParkingConstant.INVALID_LONG_FORMAT + inputLineNo);
				}
			}
		}
		return input;
	}
}
