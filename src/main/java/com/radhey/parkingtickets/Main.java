/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radhey.parkingtickets;

/**
 *
 * @author radhey
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.radhey.parkingtickets.exception.ErrorCode;
import com.radhey.parkingtickets.exception.ParkingException;
import com.radhey.parkingtickets.processor.AbstractProcessor;
import com.radhey.parkingtickets.processor.RequestProcessor;
import com.radhey.parkingtickets.service.impl.ParkingServiceImpl;

public class Main
{
	public static void main(String[] args)
	{
		AbstractProcessor processor = new RequestProcessor();
		processor.setService(new ParkingServiceImpl());
		BufferedReader bufferReader = null;
		String input = null;
		try
		{
			System.out.println("\n\n");
			printUsage();
			switch (args.length)
			{
				case 0: 
				{
					System.out.println("Enter 'exit' to end Execution");
					System.out.println("Input:");
					while (true)
					{
						try
						{
							bufferReader = new BufferedReader(new InputStreamReader(System.in));
							input = bufferReader.readLine().trim();
							if (input.equalsIgnoreCase("exit"))
							{
								break;
							}
							else
							{
								if (processor.validate(input))
								{
									try
									{
										processor.execute(input.trim());
									}
									catch (ParkingException e)
									{
										System.out.println(e.getMessage());
									}
								}
								else
								{
									printUsage();
								}
							}
						}
						catch (IOException e)
						{
							throw new ParkingException(ErrorCode.INVALID_REQUEST.getMessage(), e);
						}
					}
					break;
				}
				case 1:// File input/output
				{
					File inputFile = new File(args[0]);
					try
					{
						bufferReader = new BufferedReader(new FileReader(inputFile));
						int lineNo = 1;
						while ((input = bufferReader.readLine()) != null)
						{
							input = input.trim();
							if (processor.validate(input))
							{
								try
								{
									processor.execute(input);
								}
								catch (ParkingException e)
								{
									System.out.println(e.getMessage());
								}
							}
							else
								System.out.println("Incorrect Command Found at line: " + lineNo + " ,Input: " + input);
							lineNo++;
						}
					}
					catch (IOException e)
					{
						throw new ParkingException(ErrorCode.INVALID_FILE.getMessage(), e);
					}
					break;
				}
				default:
					System.out.println("Invalid input. Usage Style: java -jar <jar_file_path> <input_file_path>");
			}
		}
		catch (ParkingException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if (bufferReader != null)
					bufferReader.close();
			}
			catch (IOException e)
			{
			}
		}
	}
	
	private static void printUsage()
	{
		StringBuffer buffer = new StringBuffer();
		buffer = buffer.append("Please Enter Commands to check. {variable} to be replaced").append("\n");
		buffer = buffer.append("A) Create Parking tickets for size n ---> create_parking_lot {capacity}").append("\n");
		buffer = buffer.append("B) That car you want to park   ---> park <<car_number>> {car_clour}").append("\n");
		buffer = buffer.append("C) Vacant parking slot after lever the car ---> leave {slot_number}").append("\n");
		buffer = buffer.append("D) To See Status of Parking slots ---> status").append("\n");
		buffer = buffer.append("E) Enter Color and get resitration numbers of cars which have that color ---> registration_numbers_for_cars_with_color {car_color}").append("\n");
		buffer = buffer.append("F) Enter color of the car and get which slot in that car is parked ---> slot_numbers_for_cars_with_color {car_color}").append("\n");
		buffer = buffer.append("G) Enter Registration number and find out slot in that car is parked---> slot_number_for_registration_number {car_number}").append("\n");
		System.out.println(buffer.toString());
	}
}
