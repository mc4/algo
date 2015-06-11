import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		
		File file;
		BufferedReader br;
		String line;
		
	
		file = new File(args[0]);
		br = new BufferedReader(new FileReader(file));
			
		while ((line = br.readLine()) != null){
		    
			int power = 1; //multiple of 16
	        int factor = 0; 
	        int dec = 0; //decimal value of hex number
	   	    int m = 0;
			    
		    for(int i = line.length()-1; i>=0; i--){
		        //get power of 16
		        power = (int)Math.pow(16, m);
		        m++;
			        
		        //get factor
		        if(Character.isLetter(line.charAt(i))){
		            factor = converter(line.charAt(i));
		        } else{
		            factor = Character.getNumericValue(line.charAt(i));
		        }
			        
			     dec += factor*power;
			        
			 }
			    System.out.println(dec);
		
			}
			br.close();
		} 
	
	public static int converter(char c){
	    switch(c){
	        case 'a':
	            return 10;
	        case 'b':
	            return 11;
	        case 'c':
	            return 12;
	        case 'd':
	            return 13;
	        case 'e':
	            return 14;
	        case 'f':
	            return 15;
	        default:
	            return -1;
	    }
	}
	
}
