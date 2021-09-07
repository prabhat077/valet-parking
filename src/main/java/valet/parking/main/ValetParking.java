package valet.parking.main;

import java.util.Scanner;

import valet.parking.util.InputHandlerServiceUtil;

/**
 * This is Driver function it will take input from command line and forward to
 * Vehicle facotry Service
 * 
 * @author Prabhat Bajpai
 *
 */

public class ValetParking {

	public static void main(String args[]) {
		ValetParkingFactory factory = new ValetParkingFactory();
		Scanner sc = new Scanner(System.in);

		/*
		 * line no 1 contain parking info which will help initialize our service.
		 */
		int inputLineNo = 1;
		String inputLine = sc.nextLine();
		
		/*
		 * Validate Input
		 */
		String[] input = InputHandlerServiceUtil.verifyInput(inputLine, inputLineNo);
		// first input contain car and second contain motorcycle capacity
		int carCapacity = Integer.parseInt(input[0]);
		int motorcycleCapacity = Integer.parseInt(input[1]);
		
		
		/*
		 * Initialize all Vehicle Services
		 */
		factory.initializeService(carCapacity, motorcycleCapacity);
		
		/*
		 * Other line contain Parking vahicles to enter or exit vehicle.
		 */
		inputLineNo++;
		while (sc.hasNext()) {
			inputLine = sc.nextLine();
			// Validate Input
			input = InputHandlerServiceUtil.verifyInput(inputLine, inputLineNo);
			factory.execute(input);
			inputLineNo++;
		}
		sc.close();
	}
}
