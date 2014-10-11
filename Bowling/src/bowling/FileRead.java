package bowling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FileRead {

	ArrayList<Person> readData (String fileName) throws Exception{		
		BufferedReader reader = new BufferedReader(new FileReader("InputFiles//"+fileName));
		String line = null;
		ArrayList<Person> inputList = new ArrayList<Person>();
		while((line = reader.readLine()) != null){
			String[] parts = line.split("\\s");			
			String firstName = parts[0];			
			String lastName = parts[1];
			StringBuilder nameParts = new StringBuilder();
			nameParts.append(parts[1]);
			nameParts.append(parts[0]);
			String name = nameParts.toString();
			ArrayList<Integer> score = new ArrayList<Integer>();
			for(int j=2;j<parts.length;j++){
				score.add(Integer.parseInt(parts[j]));
			}
			Person person = new Person();
			person.setLastName(lastName);
			person.setFirstName(firstName);
			person.setName(name);
			person.setScore(score);
			inputList.add(person);
		}		
		return inputList;
	}
}
