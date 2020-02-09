/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radhey.parkingtickets.dao;

/**
 *
 * @author radhey
 */

import java.util.List;
import com.radhey.parkingtickets.model.Vehicle;

public interface ParkingDataManager<T extends Vehicle>
{
	public int parkCar(int level, T vehicle);
	
	public boolean leaveCar(int level, int slotNumber);
	
	public List<String> getStatus(int level);
	
	public List<String> getRegNumberForColor(int level, String color);
	
	public List<Integer> getSlotNumbersFromColor(int level, String colour);
	
	public int getSlotNoFromRegistrationNo(int level, String registrationNo);
	
	public int getAvailableSlotsCount(int level);
	
	public void doCleanup();
}
