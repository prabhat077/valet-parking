package valet.parking.service.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import valet.parking.service.EmptyParkingLotService;

public class EmptyParkingLotServiceImpl implements EmptyParkingLotService {
	private Queue<Integer> emptyParkingLot;

	public EmptyParkingLotServiceImpl(int capacity) {
		this.emptyParkingLot = new PriorityQueue<>(capacity);
		for (int i = 0; i < capacity; i++) {
			emptyParkingLot.add(i + 1);
		}
	}

	@Override
	public Queue<Integer> getEmptyParkingLot() {
		return emptyParkingLot;
	}

}
