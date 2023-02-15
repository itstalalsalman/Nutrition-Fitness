package MainAndSys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import Inheritance.Coach;
import Inheritance.Trainee;
import Inheritance.User;

public class TrainingSys {

	private static HashSet<User> userSet = new HashSet<>();
	private static TreeSet<Trainee> traineeSortedSetById = new TreeSet<Trainee>();
	private static TreeSet<Coach> coachSortedSetById = new TreeSet<Coach>();
	
	public static boolean readToSet() {
		Scanner sc;
		File file = new File("users.txt");
		
		try {
			sc = new Scanner(file);
			
			while (sc.hasNext()) {
				String type = sc.next();
				int id = sc.nextInt();
				String userName = sc.next();
				String password = sc.next();
				int height = sc.nextInt();
				double weight = sc.nextDouble();
				String sex = sc.next();
				int age = sc.nextInt();
				
				User newUser;
				
				if (type.equalsIgnoreCase("Trainee")) {
					String goal = sc.next();
					int coachId = sc.nextInt();
					newUser = new Trainee(id, userName, password, height, weight, sex, age, goal, coachId);
					traineeSortedSetById.add((Trainee) newUser);
				} else {
					String experience = sc.next();
					newUser = new Coach(id, userName, password, height, weight, sex, age, experience);
					coachSortedSetById.add((Coach) newUser);
				}
				userSet.add(newUser);
			}
			
			return true;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void addUser(String type, int id, String userName, String password, int height, double weight, String sex, int age, String experience, String goal, int coachId) {
		if (type.equalsIgnoreCase("Trainee")) {
			Trainee t = new Trainee(id, userName, password, height, weight, sex, age, goal, coachId);
			userSet.add(t);
			traineeSortedSetById.add(t);
		} else {
			Coach t = new Coach(id, userName, password, height, weight, sex, age, experience);
			coachSortedSetById.add(t);
			userSet.add(t);
		}
	}
	
	public static boolean readFromBinary() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.bin"));
			
			userSet = (HashSet<User>) ois.readObject();
			for (User u : userSet) {
				if (u instanceof Trainee)
					traineeSortedSetById.add((Trainee) u);
				else {
					coachSortedSetById.add((Coach) u);
				}
					
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean writeToBinary() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.bin"));
			oos.writeObject(userSet);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String displayTrainees() {
		String res = "";
		
		for (Trainee t : traineeSortedSetById) {
			res += t.toString() + "\n";
		}
		
		return res;
	}
	
	public static String[] getCoachIdSortedById() {
		String[] ids = new String[coachSortedSetById.size()];
		Iterator<Coach> coachIte = coachSortedSetById.iterator();
		for (int i = 0; i < coachSortedSetById.size(); i++) {
			ids[i] = coachIte.next().getId() + "";
		}
		
		return ids;
	}
	
	public static String[] getCoachTrainees(int coachId) {
		String[] coachTrainees = new String[traineeSortedSetById.size()];
		int i = 0;
		for (Trainee t : traineeSortedSetById) {
			if (t.getCoachId() == coachId)
				coachTrainees[i++] = t.getId() + "";
		}
		return coachTrainees;
	}
	
	public static String displayCoachTrainees(int coachId){
		String res = "";
		for (Trainee st : traineeSortedSetById)
			if (st.getCoachId() == coachId)
				res += st.toString() + "\n";
		
		return res;
	}
	
	public static Coach searchCoach(int id) {
		for (Coach c : coachSortedSetById)
			if (c.getId() == id)
				return c;
		return null;
	}
	
	public static Trainee searchTrainee(int id) {
		for (Trainee t : traineeSortedSetById)
			if (t.getId() == id)
				return t;
		return null;
	}
	
	public static HashSet<User> getUserSet(){
		return userSet;
	}
	
	public static User checkLogin(String username, String password) {
		for (User u : userSet)
			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		return null;
	}
	
}
