package bowling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileWrite {
	
	private File file;

	public void fileWrite(String fName) throws IOException{
		
		file = new File("OutputFiles//"+fName);
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
	    
	}
	
	public void fileClose(){
		
		file.close();
	}
	
}
