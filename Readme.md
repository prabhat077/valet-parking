# Automated Valet Car Parking

Design an automated valet car parking system where you manage a parking space
for vehicles as they enter/exit it and manage its revenue.

## Prerequisites
1. Install Java 1.8 version.
2. Install Maven 3.x.x version.
3. Set JAVA_HOME and MAVEN_HOME environment variable.

## Setup
1. Unzip file valet-parking.
2. Go inside valet-parking folder.
   ```sh
   cd valet-parking
   ```
3. Create jar file using maven.
   ```sh
   mvn package
   ```
4. Go inside target folder and run jar file.
   ```sh
   cd target
   java -jar valet-parking-0.0.1-SNAPSHOT.jar
   ```
5. Provide input for parking space for Car and Motorcycle.
   ```sh
   4 3
   ```
6. Run query for Enter and Exit of vehicle and check the output.
   ```sh
   Enter motorcycle SGX1234A 1613541902
   Enter car SGF9283P 1613541902
   Exit SGX1234A 1613545602
   ```
7. Press Ctrl+C to end the Application.

## Test
1. Unzip file valet-parking.
2. Go inside valet-parking folder.
   ```sh
   cd valet-parking
   ```
3. Create jar file using maven.
   ```sh
   mvn test
   ```
## Project Structure
1. Source Code Structure   
    ```
	valet.parking.main
		ValetParking.java
		ValetParkingFactory.java

	valet.parking.constant
		ParkingOperationEnum.java
		ValetParkingConstant.java
		VehicleEnum.java

	valet.parking.model
		Car.java
		Motorcycle.java
		Vehicle.java

	valet.parking.service
		EmptyParkingLotService.java
		ParkingLotService.java
		VehicleService.java

	valet.parking.service.impl
		CarServiceImpl.java
		EmptyParkingLotServiceImpl.java
		MotorCycleServiceImpl.java
		ParkingLotServiceImpl.java
		VehicleServiceImpl.java

	valet.parking.util
		InputHandlerServiceUtil.java
		OutputHandlerServiceUtil.java
   ```
2. Test Classes Structure
   ```
    valet.parking.service
            VehicleServiceTest.java	
    valet.parking.util
	    InputHandlerServiceUtilTest.java
	    OutputHandlerServiceUtilTest.java
   ```

## Future Enhancement
1. We can easily implement it when there is multiple Entries at the same time using Multi Threading we only need to change implementation of ParkingLotService and EmptyParkingLotService so they return thread safe objects.
2. We can use it for multiple Parking lots by using ThreadLocal while initializing services in ValetParkingFactory servicea and other implementation will remain same.
3. We can add additional properties for specific vehicle Car or Motorcycle and implement them in corresponding services.
4. We can use it for more vehicle other than Car and Motorcycle by adding more enum in VehicleEnum and change in ValetParkingFactory service.