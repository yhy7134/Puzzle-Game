import java.awt.Color;

public class AkariConstraint extends Solver{
	
	private int[][] blackSpace;
	private int size;
	private int[] values = {0,1};
	
	public AkariConstraint(){
		AkariGame game = new AkariGame();
		
		blackSpace = game.importConstraintVal();
		size = game.getAkariLength();
	}
	
	public int[][] getBlackSpace() {
		return blackSpace; 
	}

	public int getSize() {
		return size; 
	}

	public int[] getPossibleValues() {
		return values; 
	}

	public boolean checkPartialConstraints(Spot[][] spot, int row, int column) {
		
		if (spot[row][column].getValue() == 1) {
		    for (int r = row; r >= 0; r--) {
			if (spot[r][column].getDark())
			    break; 
			if (spot[r][column].getValue() == 1 && r != row)  
			    return false; 
		    }
		    for (int r = row; r < size; r++) {
			if (spot[r][column].getDark())
			    break; 
			if (spot[r][column].getValue() == 1 && r != row) 
			    return false; 
		    }
		    for (int c = column; c >= 0; c--) {
			if (spot[row][c].getDark())
			    break; 
			if (spot[row][c].getValue() == 1 && c != column)
			    return false; 
		    }
		    for (int c = column; c < size; c++) {
			if (spot[row][c].getDark())
			    break; 
			if (spot[row][c].getValue() == 1 && c != column)
			    return false; 
		    }
		}

		for (int i = 0; i < blackSpace.length; i++) {
		    if (blackSpace[i][0] != -1) {
			int neighbor = 0; 
			int r = blackSpace[i][1]; 
			int col = blackSpace[i][2];
			if (r - 1 >= 0) {
			    if (spot[r - 1][col].getValue() == 1)
				neighbor = neighbor + 1; 
			}
			if (r + 1 < size) {
			    if (spot[r + 1][col].getValue() == 1)
				neighbor = neighbor + 1; 
			}
			if (col - 1 >= 0) {
			    if (spot[r][col - 1].getValue() == 1)
				neighbor = neighbor + 1; 
			}
			if (col + 1 < size) {
			    if (spot[r][col + 1].getValue() == 1)
				neighbor = neighbor + 1; 
			}

			if (neighbor > blackSpace[i][0])
			    return false; 
		    }
		}

		return true; 
	    }

    public boolean checkAllConstraints(Spot[][] spot) {

       	for (int i = 0; i < blackSpace.length; i++) {
	    if (blackSpace[i][0] != -1) {
	       	int neighbor = 0; 
	       	int row = blackSpace[i][1]; 
       		int column = blackSpace[i][2];
       		if (row - 1 >= 0) {
       		    if (spot[row - 1][column].getValue() == 1)
       			neighbor = neighbor + 1; 
       		}
       		if (row + 1 < size) {
       		    if (spot[row + 1][column].getValue() == 1)
       			neighbor = neighbor + 1; 
	       	}
	       	if (column - 1 >= 0) {
	       	    if (spot[row][column - 1].getValue() == 1)
	       		neighbor = neighbor + 1; 
	       	}
       		if (column + 1 < size) {
       		    if (spot[row][column + 1].getValue() == 1)
       			neighbor = neighbor + 1; 
       		}

       		if (neighbor != blackSpace[i][0])
       		    return false; 
       	   }
	}

       	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) { 
		if (spot[i][j].getValue() == 1) {
		    for (int r = i; r >= 0; r--) {
			if (spot[r][j].getDark())
			    break; 
			if (spot[r][j].getValue() == 1 && r != i)
			    return false; 
		    }
		    for (int r = i; r < size; r++) {
			if (spot[r][j].getDark())
			    break; 
			if (spot[r][j].getValue() == 1 && r != i)
			    return false; 
		    }
		    for (int c = j; c >= 0; c--) {
			if (spot[i][c].getDark())
			    break; 
			if (spot[i][c].getValue() == 1 && c != j)
			    return false; 
		    }
		    for (int c = j; c < size; c++) {
			if (spot[i][c].getDark())
			    break; 
			if (spot[i][c].getValue() == 1 && c != j)
			    return false; 
		    }
		}
		else {
		    boolean light = false; 
		    for (int r = i; r >= 0; r--) {
			if (spot[r][j].getDark())
			    break; 
			if (spot[r][j].getValue() == 1) {
			    light = true; 
			    break;
			}
		    }
		    if (light != true) {
			for (int r = i; r < size; r++) {
			    if (spot[r][j].getDark())
				break; 
			    if (spot[r][j].getValue() == 1) {
				light = true; 
				break;
			    }
			}
		    }
		    if (light != true) {
			for (int c = j; c >= 0; c--) {			    
			    if (spot[i][c].getDark())
				break; 
			    if (spot[i][c].getValue() == 1) {
				light = true; 
				break;
			    }
			}
		    }
		    if (light != true) {
			for (int c = j; c < size; c++) {
			    if (spot[i][c].getDark())
				break; 
			    if (spot[i][c].getValue() == 1) {
				light = true; 
				break;
			    }
			}
		    }
		    if (!light)
			return false; 
		}
	    }
	}
	return true; 
    }
    
    public void showOnFrame(FinalFrame frame, Spot[][] spot) {
	
	for (int i = 0; i < spot.length; i++) { 
	    for (int j = 0; j < spot.length; j++) { 
		if (spot[i][j].getValue() == 1)
		    spot[i][j].setBackground(Color.PINK);
		else
		    spot[i][j].setBackground(null); 
	    }
	}
	
	frame.validate(); 
	frame.repaint(); 
	
    }
}

