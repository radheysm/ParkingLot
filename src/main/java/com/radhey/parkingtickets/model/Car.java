/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radhey.parkingtickets.model;

/**
 *
 * @author radhey
 */
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car extends Vehicle
{
	
	public Car(String registrationNo, String color)
	{
		super(registrationNo, color);
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		super.writeExternal(out);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		super.readExternal(in);
	}
}
