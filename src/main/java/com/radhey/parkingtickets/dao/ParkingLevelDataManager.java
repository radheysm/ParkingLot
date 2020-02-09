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

public interface ParkingLevelDataManager<T extends Vehicle>
{
	public int parkCar(T vehicle);
	
	public boolean leaveCar(int slotNumber);
	
	public List<String> getStatus();
	
	public List<String> getRegNumberForColor(String color);
	
	public List<Integer> getSlotNumbersFromColor(String colour);
	
	public int getSlotNoFromRegistrationNo(String registrationNo);
	
	public int getAvailableSlotsCount();
	
	public void doCleanUp();
}