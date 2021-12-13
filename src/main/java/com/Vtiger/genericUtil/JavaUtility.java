package com.Vtiger.genericUtil;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtility {
	
	private JavaUtility() {
		
	}
	
	public static JavaUtility objForJavaUtility()
	{
		JavaUtility ju = new JavaUtility();
		return ju;
	}
	/**
	 * author:P.anusha
	 * this method generates random numbers 
	 */
	public int generateRandomNumber()
	{
		Random rr = new Random();
		return rr.nextInt(2000);

	}
	public String getFirstName()
	{
		Faker faker =  new Faker();
		return faker.name().firstName();

	}
	public String getLastName()
	{
		Faker faker= new Faker();
		return faker.name().lastName();
	}
	public String getFullName()
	{
		Faker faker = new Faker();
		return faker.name().fullName();
	}
public String getphonenumber()
{
	Faker faker = new Faker();
	return faker.phoneNumber().cellPhone();
}	
}

