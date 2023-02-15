package Inheritance;

import java.io.Serializable;
import java.util.Objects;

import Interface.UserInterface;

public abstract class User implements Comparable<User>, Serializable, UserInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4038185952909986941L;
	protected int id;
	protected String userName;
	protected String password;
	protected int height;
	protected double weight;
	protected String sex;
	protected int age;
	
	public String getSex() {
		return sex;
	}
	
	public User(int id, String userName, String password, int height, double weight, String sex, int age)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.age = age;
		
	}
	
	public User(User a) {
		this.id = a.getId();
		this.userName = a.getUsername();
		this.password = a.getPassword();
		this.height = a.getHeight();
		this.weight = a.getWeight();
		this.sex = a.getSex();
		this.age = a.getAge();
	}

	public boolean login(String userName, String password) {
		if (this.userName.equals(userName) && this.password.equals(password))
			return true;
		return false;
	}

	public void setNameSurname(String nameSurname) {
		this.userName = userName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.userName;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override 
	public int compareTo(User b)
	{
		return this.id - b.id;
	}

	public String getPassword() {
		return password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	@Override  
	public String toString()
	{
		return "Id= " + id + 
				"\nName Surname= " + userName + 
				"\nHeight = " + height + 
				"\nWeight= " + weight;
	}
	
	
	
}
