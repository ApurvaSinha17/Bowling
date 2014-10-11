package bowling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Calculation {
	
	private static int firstColumnMaxLength = 0;
	private static int maxGameScoreLength = 66;

	void scoreCalculation(ArrayList<Person> inputData){
		
		Collections.sort(inputData, new CustomComparator());
		
		nameColumnMaxLength(inputData);
		
		for(Person person : inputData){
			scoreDisplay(person);
			int finalGameScore = cummulativeScoreDisplay(person);
			person.setFinalGameScore(finalGameScore);
		}
		allDashes();
		
		System.out.println("");
		System.out.println("");
		Collections.sort(inputData, new ScoreComparator());
		finalScoreDisplay(inputData);
	}
	
	private void scoreDisplay(Person person){
			
			allDashes();
			System.out.println("");
			int frameCummScore = 0;
			System.out.print("| ");
			System.out.print(person.getFirstName()+" ");
			System.out.print(person.getLastName()+" ");
			for(int i=0;i<firstColumnMaxLength-person.getName().trim().length();i++){
				System.out.print(" ");
			}
			System.out.print("| ");
			int scoreLength = person.getScore().size();
			int j=0;
			while(j<scoreLength-1){
				
				if(j+2==scoreLength-1 && person.getScore().get(j)==10){
					System.out.print("X ");
					if(person.getScore().get(j+1)==10 && person.getScore().get(j+2)==10){
						System.out.print("X X |");					
					}
					else if(person.getScore().get(j+1)+person.getScore().get(j+2)==10){
						System.out.print(person.getScore().get(j+1)+" / |");						
					}
					else if(person.getScore().get(j+1)==10 && person.getScore().get(j+2)!=10){
						if(person.getScore().get(j+2)==0){
							System.out.print("X - |");
						}
						else{
							System.out.print("X "+person.getScore().get(j+2)+" |");
						}												
					}
					else{
						if(person.getScore().get(j+1)==0){
							System.out.print("- ");
						}
						else{
							System.out.print(person.getScore().get(j+1)+" ");
						}
						if(person.getScore().get(j+2)==0){
							System.out.print("- |");
						}
						else{
							System.out.print(person.getScore().get(j+2)+" |");
						}
					}
					System.out.println("");
					break;
				}				
				
				if(j+2==scoreLength-1 && person.getScore().get(j)+person.getScore().get(j+1)==10){
					System.out.print(person.getScore().get(j)+" / ");
					if(person.getScore().get(j+2)==10)
					{
						System.out.print("X |");
					}
					else{
						if(person.getScore().get(j+2)==0){
							System.out.print("- |");
						}
						else{
							System.out.print(person.getScore().get(j+2)+" |");
						}
					}
					System.out.println("");
					break;
				}
				
				if(j+1==scoreLength-1){
						if(person.getScore().get(j)==0){
							System.out.print("- ");
						}
						else{
							System.out.print(person.getScore().get(j)+" ");
						}
						if(person.getScore().get(j+1)==0){
							System.out.print("-   | ");
						}
						else{
								System.out.print(person.getScore().get(j+1)+"   | ");					
						}
						System.out.println("");
						break;
				}
				
					if(person.getScore().get(j)==10){
						System.out.print("  X | ");
						j=j+1;
					}
					else{
						if(person.getScore().get(j)==0){
							System.out.print("- ");
						}
						else{
							System.out.print(person.getScore().get(j)+" ");
						}
						if(person.getScore().get(j+1)==0){
							System.out.print("- | ");
						}
						else{
							if(person.getScore().get(j)+person.getScore().get(j+1)==10){
								System.out.print("/ | ");
							}
							else{
								System.out.print(person.getScore().get(j+1)+" | ");
							}					
						}
						j=j+2;
					}
					
				if(j>scoreLength-1){
					System.out.println("");
					break;
				}
			}
	}
	
	private int cummulativeScoreDisplay(Person person){
		
		System.out.print("| ");
		for(int i=0;i<=firstColumnMaxLength;i++)
			System.out.print(" ");
		System.out.print(" | ");
		
		int gameScoreLength = person.getScore().size();
		int j=0;
		int cummGameScore = 0;
		boolean endFlag = false;
		
		//j+3 exceeds array limits; check for last two scores in a game
		while(j<gameScoreLength-2){
			
			if(j+2==gameScoreLength-1 && ((person.getScore().get(j) == 10) || (person.getScore().get(j) + person.getScore().get(j+1) == 10) )){
				cummGameScore = cummGameScore + person.getScore().get(j) + person.getScore().get(j+1) + person.getScore().get(j+2);
				endFlag = true;
				cummScoreDisplay(cummGameScore,endFlag);
				break;
			}
			
			if(person.getScore().get(j)==10){
				cummGameScore = cummGameScore + person.getScore().get(j) + person.getScore().get(j+1) + person.getScore().get(j+2);
				cummScoreDisplay(cummGameScore,endFlag);
				j=j+1;
			}
			else if(person.getScore().get(j)+person.getScore().get(j+1)==10){
				cummGameScore = cummGameScore + person.getScore().get(j) + person.getScore().get(j+1) + person.getScore().get(j+2);
				cummScoreDisplay(cummGameScore,endFlag);
				j=j+2;
			}
			else{
				cummGameScore = cummGameScore + person.getScore().get(j) + person.getScore().get(j+1);
				cummScoreDisplay(cummGameScore,endFlag);
				j=j+2;
			}
		}
				
		if(!endFlag){
			cummGameScore = cummGameScore + person.getScore().get(j) + person.getScore().get(j+1);
			endFlag = true;
			cummScoreDisplay(cummGameScore,endFlag);
		}
		
		System.out.println("");
		return cummGameScore;
	}
	
	private void nameColumnMaxLength(ArrayList<Person> inputData){
		
		for(Person person : inputData){
			int nameLength = person.getName().trim().length();
			if(nameLength > firstColumnMaxLength){
				firstColumnMaxLength = nameLength;
			}
			
		}
	}
	
	private void allDashes(){
		
		for(int k=0;k<=firstColumnMaxLength+maxGameScoreLength;k++){
			System.out.print("-");
		}
	}
	
	private void cummScoreDisplay(int cummGameScore, boolean endFlag){
		if(endFlag){
			if(cummGameScore>=100){
				System.out.print("  "+cummGameScore+" | ");
			}
			else if(cummGameScore>=10){
				System.out.print("   "+cummGameScore+" | ");
			}
			else{
				System.out.print("    "+cummGameScore+" | ");
			}
		}
		else{
			if(cummGameScore>=100){
				System.out.print(cummGameScore+" | ");
			}
			else if(cummGameScore>=10){
				System.out.print(" "+cummGameScore+" | ");
			}
			else{
				System.out.print("  "+cummGameScore+" | ");
			}
		}				
	}
	
	private void finalScoreDisplay(ArrayList<Person> inputData){
		
		for(Person person : inputData){
			System.out.print(person.getFirstName()+" "+person.getLastName()+" ");
			for(int i=0;i<firstColumnMaxLength-person.getName().trim().length();i++){
				System.out.print(" ");
			}
			if(person.getFinalGameScore()>=100){
				System.out.println(person.getFinalGameScore());
			}
			else if(person.getFinalGameScore()>=10){
				System.out.println(" "+person.getFinalGameScore());
			}
			else{
				System.out.println("  "+person.getFinalGameScore());
			}
		}		
	}
}

class CustomComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class ScoreComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		Integer person1Score = o1.getFinalGameScore();
		Integer person2Score = o2.getFinalGameScore();
		return person2Score.compareTo(person1Score);
	}
	
}