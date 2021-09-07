package valet.parking.constant;

/**
 * Enum Represent currently allowed parking operations.
 * 
 * @author Prabhat Bajpai
 *
 */
public enum ParkingOperationEnum {
	ENTER("Enter"), EXIT("Exit");
	
	private String name;

	private ParkingOperationEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
