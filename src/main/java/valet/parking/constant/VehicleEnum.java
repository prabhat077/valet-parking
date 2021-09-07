package valet.parking.constant;

import java.util.Arrays;

/**
 * Enum repesent currently allowed vehicleType
 * @author Prabhat Bajpai
 *
 */
public enum VehicleEnum {
	CAR("car", "Car"), MOTOTCYCLE("motorcycle", "Motorcycle");

	String vehicleNameInput;
	String vehicleNameOutput;

	private VehicleEnum(String vehicleNameInput, String vehicleNameOutput) {
		this.vehicleNameInput = vehicleNameInput;
		this.vehicleNameOutput = vehicleNameOutput;
	}

	public String getVehicleNameInput() {
		return vehicleNameInput;
	}

	public String getVehicleNameOutput() {
		return vehicleNameOutput;
	}

	public static VehicleEnum getVehicleEnum(String vehicleNameInput) {
		return Arrays.asList(VehicleEnum.values()).stream()
				.filter(
						enumValue -> enumValue.getVehicleNameInput()
						.equals(vehicleNameInput))
				.findFirst()
				.orElse(null);
	}

}
