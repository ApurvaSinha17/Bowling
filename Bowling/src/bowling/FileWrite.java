package bowling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileWrite {

	void fileWrite(String fName) throws IOException{
		
		File file = new File("OutputFiles//"+fName);
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
	    
	}
	
}
