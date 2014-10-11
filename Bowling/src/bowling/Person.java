package bowling;

import java.util.ArrayList;

public class Person {

	private String lastName;
	private String firstName;
	private String name;
	private int finalGameScore;
	
	public int getFinalGameScore() {
		return finalGameScore;
	}
	public void setFinalGameScore(int finalGameScore) {
		this.finalGameScore = finalGameScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private ArrayList<Integer> score;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public ArrayList<Integer> getScore() {
		return score;
	}
	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}
	
	
}
