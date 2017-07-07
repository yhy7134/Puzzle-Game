import java.util.*;

public class KakurasuGame {
	
	public static Scanner keyboard = new Scanner(System.in); 
    private String fileName; 
    
    public KakurasuGame() {
 
    }

    //Read a file for Kakurasu Set Up
    public int[][] importConstraintVal() {
     
        fileName = "Kakurasu.dat";
               
        try{
        	Scanner file = new Scanner(new java.io.FileReader(fileName));
            
            int size = file.nextInt();
            
            int[][] sums = new int[2][size];
                    	
        	for (int i = 0; i < 2; i++){
        		for (int j = 0; j < size; j++){
        			if (file.hasNextInt()) {
        				sums[i][j] = file.nextInt(); 
        			}
        		}
        	}
        	
        	file.close();
        	return sums;
        	
        } catch (java.io.FileNotFoundException e) {
        	System.out.println("File not found."); 
        	System.exit(1);
        	return null;
    	}
        
    }
}