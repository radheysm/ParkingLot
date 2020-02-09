/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radhey.parkingtickets.model.strategy;

/**
 *
 * @author radhey
 */
import java.util.TreeSet;

public class NearestFirstParkingStrategy implements ParkingStrategy
{
	private TreeSet<Integer> freeSlots;
	
	public NearestFirstParkingStrategy()
	{
		freeSlots = new TreeSet<Integer>();
	}
	
	@Override
	public void add(int i)
	{
		freeSlots.add(i);
	}
	
	@Override
	public int getSlot()
	{
		return freeSlots.first();
	}
	
	@Override
	public void removeSlot(int availableSlot)
	{
		freeSlots.remove(availableSlot);
	}
}