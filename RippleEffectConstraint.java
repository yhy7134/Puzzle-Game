public class RippleEffectConstraint extends Solver{ 

    private int [][][] rooms = {{{0,0}, {1,0}, {2,0}}, {{0,1}}, {{0,2}, {1,1}, {1,2}}, {{0,3}}, {{0,4}, {1,4}, {2,4}}, {{0,5}}, {{0,6}, {0,7}, {0,8}}, {{0,9}}, {{1,3}, {2,2}, {2,3}}, {{2,1}}, {{1,5}, {1,6}}, {{1,7}, {2,6}, {2,7}}, {{1,8}}, {{1,9}, {2,8}, {2,9}}, {{2,5}}, {{3,0}, {3,1}, {4,0}}, {{3,2}}, {{3,3}, {3,4}, {3,5}}, {{3,6}}, {{3,7}, {4,6}, {4,7}}, {{3,8}}, {{3,9}, {4,9}, {5,9}}, {{4,1}}, {{4,2}, {5,1}, {5,2}}, {{4,3}, {4,4}}, {{4,5}}, {{4,8}, {5,7}, {5,8}}, {{5,0}}, {{5,3}, {5,4}, {5,5}}, {{5,6}}, {{6,0}, {7,0}, {8,0}}, {{6,1}, {6,2}, {7,1}}, {{6,3}, {6,4}, {7,3}}, {{6,5}}, {{6,6}, {6,7}, {6,8}}, {{6,9}}, {{7,2}}, {{7,4}}, {{7,5}, {8,4}, {8,5}}, {{7,6}}, {{7,7}, {7,8}, {7,9}}, {{8,1}, {8,2}, {9,1}}, {{8,3}}, {{8,6}, {8,7}, {8,8}}, {{8,9}}, {{9,0}}, {{9,2}}, {{9,3}, {9,4}, {9,5}}, {{9,6}}, {{9,7}, {9,8}, {9,9}}}; 
    private int size = 10; 
    private int[] values = {1,2,3}; 

    public RippleEffectConstraint () {

	RippleEffectGame game= new RippleEffectGame(); 
	
    }


    public int[][][] getRooms() {
	return rooms; 
    }

    public int getSize() {
	return size; 
    }

    public int[] getPossibleValues() {
	return values; 
    }

    public boolean checkPartialConstraints(Spot[][] spot, int row, int column) {

    	int roomNumber = spot[row][column].getRoom(); 
    	int[] countVal = new int[rooms[roomNumber].length]; 
    	for (int k = 0; k < countVal.length; k++)
    		countVal[k] = 0; 

    	if (spot[row][column].getValue() > rooms[roomNumber].length)
    		return false; 

    	for (int i = 0; i < rooms[roomNumber].length; i++) {
    		int val = spot[rooms[roomNumber][i][0]][rooms[roomNumber][i][1]].getValue();
    		if (val > 0)
    			countVal[val - 1] = countVal[val - 1] + 1; 
    	}
		
    	for (int j = 0; j < countVal.length; j++) {
    		if (countVal[j] > 1)
    			return false; 
    	}

    	int spotVal = spot[row][column].getValue(); 
    	for (int k = 1; k <= spotVal; k++) { 
    		if (row - spotVal >= 0) {
    			if (spotVal == spot[row - k][column].getValue())
    				return false; 
    		}
    		if (row + spotVal < size) {
    			if (spotVal == spot[row + k][column].getValue())
    				return false; 
    		}
    		if (column - spotVal >= 0) {
    			if (spotVal == spot[row][column - k].getValue())
    				return false; 
    		}
    		if (column + spotVal < size) {
    			if (spotVal == spot[row][column + k].getValue())
    				return false;
    		}
    	}

    	return true;

    }

    public boolean checkAllConstraints(Spot[][] spot) {

    	for (int i = 0; i < rooms.length; i++) {
    		int[] countVal = new int[rooms[i].length]; 
    		for (int k = 0; k < countVal.length; k++)
    			countVal[k] = 0; 
    		for (int j = 0; j < rooms[i].length; j++) {
    			int val = spot[rooms[i][j][0]][rooms[i][j][1]].getValue();
    			if (val == 0)
    				return false; 
    			countVal[val - 1] = countVal[val - 1] + 1;
    		}
    		for (int m = 0; m < countVal.length; m++) {
    			if (countVal[m] != 1)
    				return false; 
    		}
    	}

    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    			int val = spot[i][j].getValue(); 
    			for (int k = 1; k <= val; k++) { 
    				if (i - val >= 0) {
    					if (val == spot[i - k][j].getValue())
    						return false; 
    				}
    				if (i + val < size) {
    					if (val == spot[i + k][j].getValue())
    						return false; 
    				}
    				if (j - val >= 0) {
    					if (val == spot[i][j - k].getValue())
    						return false; 
    				}
    				if (j + val < size) {
    					if (val == spot[i][j + k].getValue())
    						return false;
    				}
    			}
    		}
    	}

    	return true; 

    }

    public void showFrame(FinalFrame frame, Spot[][] spot) {

    	for (int i = 0; i < spot.length; i++) { 
    		for (int j = 0; j < spot.length; j++)  
    			spot[i][j].setText(spot[i][j].getValue() + ""); 
    	}

    	frame.validate(); 
    	frame.repaint(); 
    }


}