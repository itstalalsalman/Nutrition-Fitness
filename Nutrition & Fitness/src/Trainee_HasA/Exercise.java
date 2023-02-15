package Trainee_HasA;

import java.io.Serializable;

public class Exercise implements Serializable{
	
	private String name;
	private int numOfSets;
	private int numOfReps;
	private double weightUsed;
	
	
	public Exercise(String name, int numOfSets, int numOfReps, double weightUsed)
	{
		this.name = name;
		this.numOfSets = numOfSets;
		this.numOfReps = numOfReps;
		this.weightUsed = weightUsed;
	}


	@Override
	public String toString() {
		return "Exercise\nName= " + name + "\nNumber Of Sets= " + numOfSets + "\nNumber Of Reps= " + numOfReps
				+ "\nWeight Used= "
				+ weightUsed;
	}
	
	
	
}	
