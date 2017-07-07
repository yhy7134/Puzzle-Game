import java.util.Scanner;

public class AkariGame {

	public static Scanner keyboard = new Scanner(System.in); 
    private String fileName; 
    private int AkariLength = 0;
    
    public AkariGame() {
 
    }

    //Read a file for Kakurasu Set Up
    public int[][] importConstraintVal() {
     
        fileName = "Akari.dat";
               
        try{
	    Scanner file = new Scanner(new java.io.FileReader(fileName));
            
	    AkariLength = file.nextInt();

            int size = file.nextInt();
            
            int[][] blackSpace = new int[size][3];
            
            for (int i = 0; i < size; i++){
        	    for (int j = 0; j < 3; j++){
        	    	if (file.hasNextInt()) {
        	    		blackSpace[i][j] = file.nextInt(); 
        	    	}
        	    }
        	}

	    return blackSpace;
        	
        } catch (java.io.FileNotFoundException e) {
        	System.out.println("File not found."); 
        	System.exit(1);
        	return null;
    	}
        
    }
    
    public int getAkariLength() {
    	return AkariLength;
    }

}
