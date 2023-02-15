package Trainee_HasA;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable{ 
	
	private String cardioType;
	private int cardioLength;
	private ArrayList<Exercise> exercises = new ArrayList<>();


	public Workout(String cardioType, int cardioLength) {
		this.cardioType = cardioType;
		this.cardioLength = cardioLength;
	}

	
	
	public String getCardioType() {
		return cardioType;
	}

	public void setCardioType(String cardioType) {
		this.cardioType = cardioType;
	}


	public int getCardioLength() {
		return cardioLength;
	}


	public ArrayList<Exercise> getExercises(){
		return exercises;
	}
	
	public void setCardioLength(int cardioLength) {
		this.cardioLength = cardioLength;
	}


	public String displayExercises() {
		String res = "";
		for (Exercise e : exercises)
			res += e.toString() + "\n";
		
		return res;
	}

	public void addExercise(String name, int numOfSets, int numOfReps, double weightUsed) {
		this.exercises.add(new Exercise(name, numOfSets, numOfReps, weightUsed));
	}
	
	@Override
	public String toString() {
		String res = "Workout\nCardio Type= " + cardioType + "\nCardio Length= " + cardioLength + "\nExercises= ";
		for (Exercise e : exercises)
			res += e.toString() + "\n";
		
		return res;
	}
	
	
	
}
