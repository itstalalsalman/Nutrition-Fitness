package Inheritance;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import Trainee_HasA.Exercise;
import Trainee_HasA.Workout;

public class Coach extends User{
	
	private String experience;
	private double price;
	
	public Coach(int id, String nameSurname, String password, int height, double weight, String sex, int age, String experience)
	{
		super(id, nameSurname, password, height, weight, sex, age);
		this.experience = experience;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public void createWorkout(Trainee t, String cardioType, int cardioLength) {
		
		t.setWorkout(new Workout(cardioType, cardioLength));
		
	}
	
	@Override 
	public String toString() {
		return "Coach\n" + super.toString() + "\nExperience= " + experience + "\nBMI= " + calculateBMI() * 10000;
	}

	@Override
	public double calculateBMI() {
		return this.weight / (this.height*this.height) - 2;
	}
	
}
