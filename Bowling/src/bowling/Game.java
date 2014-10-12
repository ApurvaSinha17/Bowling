package bowling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {

	public static void main(String[] args){
	try{
		String inputFile = args[0];
		String outputFile = args[1];
		FileRead inputData = new FileRead();
		ArrayList<Person> inputList = inputData.readData(inputFile);
		FileWrite outputWrite = new FileWrite();
		PrintStream orig = System.out;
		outputWrite.fileWrite(outputFile);
        Calculation calculation = new Calculation();
        calculation.scoreCalculation(inputList);
        System.setOut(orig);
        System.out.println("Done");
		}
	catch(FileNotFoundException fe){
		System.out.println("File Not Found");
	}
	catch(Exception e){
		System.out.println(e.getStackTrace());
	}
	}

}
