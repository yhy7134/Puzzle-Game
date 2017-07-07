public class Solver {

    public void solvePuzzle(FinalFrame frame, Spot[][] spot, int[] possibleValues) {

    	boolean correct = label(frame, spot, this, possibleValues, 0, 0); 

    }

    public boolean label(FinalFrame frame, Spot[][] spot, Solver game, int[] possibleValues, int row, int column) {
    	
    	int nextCol;
    	int nextRow;
    	
    	if (row == spot.length){
    		if (game.checkAllConstraints(spot)){
    			game.showFrame(frame,spot);
			System.out.println("Solution");
    			return true;
    		}
    		else{
		    System.out.println("No Solution");
    			return false;
    		}
    	}
    	
    	if (spot[row][column].getFilled()){
    		if (game.checkPartialConstraints(spot,row,column)){
    			nextCol = column + 1;
    			nextRow = row;
    			if (nextCol == spot[row].length){
    				nextCol = 0;
    				nextRow = row + 1;
    			}
    			if (label(frame, spot, game, possibleValues, nextRow, nextCol))
    				return true;
    		}
    	}
    	for (int v : possibleValues) {
    		spot[row][column].setValue(v);
    		spot[row][column].setFilled(true);
    		if (game.checkPartialConstraints(spot,row,column)){
    			nextCol = column + 1;
    			nextRow = row;
    			if (nextCol == spot.length){
    				nextCol = 0;
    				nextRow = row +1;
    			}
    			if (label(frame, spot, game, possibleValues, nextRow, nextCol))
    				return true;
    		}
    		else {
    			spot[row][column].setValue(0);
    			spot[row][column].setFilled(false);
    		}
    	}
    	return false;
    }
    
    public boolean checkPartialConstraints(Spot[][] spot, int row, int column){
    	return false;
    }
    
    public boolean checkAllConstraints(Spot[][] spot){
    	return false;
    }
    
    public void showFrame(FinalFrame frame, Spot[][] spot){
    	
    }
}