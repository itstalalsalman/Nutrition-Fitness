package Trainee_HasA;

import java.io.Serializable;

public class Food implements Serializable {
	 
	private String name;
	private int calories;
	private double protein;
	private double carbs;
	private double fats;

	public Food(String name, int calories, double protein, double carbs, double fats)
	{
		this.name = name;
		this.calories = calories;
		this.protein = protein;
		this.carbs = carbs;
		this.fats = fats;
	}

	public int getCalories() {
		return calories;
	}

	public double getProtein() {
		return protein;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getFats() {
		return fats;
	}

	@Override
	public String toString() {
		return "Food\nName= " + name + "\nCalories= " + calories + "\nProtein= " + protein + "\nCarbs= " + carbs + "\nFats= " + fats;
	}	 
	
}
