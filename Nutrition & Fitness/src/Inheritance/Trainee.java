package Inheritance;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import Trainee_HasA.Food;
import Trainee_HasA.Workout;

public class Trainee extends User{

	private String goal;
	private int coachId;
	private Workout workout;
	private LinkedHashSet<Food> meals = new LinkedHashSet<Food>(); 
	private double[] macros = new double[4];
	
	public Trainee(int id, String nameSurname, String password, int height, double weight, String sex, int age, String goal, int coachId) {
		super(id, nameSurname, password, height, weight, sex, age);
		this.goal = goal;
		this.coachId = coachId;
	}
	
	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Workout getWorkout() {
		return this.workout;
	}
	
	@Override
	public double calculateBMI() {
		return this.weight / (this.height*this.height);
	}
	
	@Override
	public String toString() {
		return "Trainee\n" + super.toString() + "\nGoal= " + goal + "\nBMI= " + calculateBMI() * 10000;
	}

	public void addMeal(String name, int calories, double protein, double carbs, double fats) {
		this.meals.add(new Food(name, calories, protein, carbs, fats));
	}

	public String displayMeals() {
		String res = "";
		
		for (Food f : meals)
			res += f.toString() + "\n";
		
		return res;
	}
	
	public void calculateMacros() {
		int factor = 0;
		if (this.getGoal().equalsIgnoreCase("Lose weight")) {
			factor = 0 - 400;
		} else if (this.getGoal().equalsIgnoreCase("Gain weight"))
			factor = 400;
		
		if (this.getSex().equals("Male"))
			this.macros[0] = (10 * this.weight + 6.25 * this.height - 5 * this.age + 5) * 1.6 + factor;
		else 
			this.macros[0] = (10 * this.weight + 6.25 * this.height - 5 * this.age - 161) * 1.6 + factor;
		this.macros[1] = 0.8 * this.weight;
		this.macros[2] = (this.macros[0] * 0.55) / 4;
		this.macros[3] = (this.macros[0] - this.macros[1] * 4 - this.macros[2] * 4) / 9;
		
	}
	
	public double calculateCaloriesLeft() {
		double calories = 0;
		for (Food meal : meals)
			calories += meal.getCalories();
		
		return this.macros[0] - calories;
	}

	public double calculateProteinLeft() {
		double protein = 0;
		for (Food meal : meals)
			protein += meal.getProtein();
		
		return this.macros[1] - protein;
	}
	
	public double calculateCarbsLeft() {
		double carbs = 0;
		for (Food meal : meals)
			carbs += meal.getCarbs();
		
		return this.macros[2] - carbs;
	}
	
	public double calculateFatsLeft() {
		double fats = 0;
		for (Food meal : meals)
			fats += meal.getFats();
		
		return this.macros[3] - fats;
	}
	
	public String calculateMacrosLeft() {
		return "Macros Left:\nCalories: " + Math.round(calculateCaloriesLeft()) + "\nProtein: " + Math.round(calculateProteinLeft())
		+ "\nCarbs: " + Math.round(calculateCarbsLeft()) + "\nFats: " + Math.round(calculateFatsLeft());
	}
}
