/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radhey.parkingtickets.processor;

/**
 *
 * @author radhey
 */

import com.radhey.parkingtickets.constants.CommandInputMap;
import com.radhey.parkingtickets.exception.ParkingException;
import com.radhey.parkingtickets.service.AbstractService;


public interface AbstractProcessor
{
	public void setService(AbstractService service);
	
	public void execute(String action) throws ParkingException;
	
	public default boolean validate(String inputString)
	{
		boolean valid = true;
		try
		{
			String[] inputs = inputString.split(" ");
			int params = CommandInputMap.getCommandsParameterMap().get(inputs[0]);
			switch (inputs.length)
			{
				case 1:
					if (params != 0)
						valid = false;
					break;
				case 2:
					if (params != 1) 
						valid = false;
					break;
				case 3:
					if (params != 2) 
						valid = false;
					break;
				default:
					valid = false;
			}
		}
		catch (Exception e)
		{
			valid = false;
		}
		return valid;
	}
}