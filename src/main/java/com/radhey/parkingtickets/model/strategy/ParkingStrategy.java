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
public interface ParkingStrategy
{
	public void add(int i);
	
	public int getSlot();
	
	public void removeSlot(int slot);
}