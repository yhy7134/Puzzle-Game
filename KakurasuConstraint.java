import java.awt.Color;

public class KakurasuConstraint extends Solver{ 

    private int[][] sum; 
    private int size; 
    private int[] values = {0,1}; 

    public KakurasuConstraint () {
	
    	KakurasuGame game = new KakurasuGame(); 

    	sum = game.importConstraintVal();
    	size = sum[0].length; 

    }

    public int[][] getSums() {	
    	return sum; 
    }

    public int getSize() {
    	return size; 
    }

    public int[] getPossibleValues() {
    	return values; 
    }

    public boolean checkPartialConstraints(Spot[][] spot, int row, int column) {
    	int rowSum = 0; 
    	int colSum = 0; 

    	for (int i = 0; i < spot.length; i++) {
    		if (spot[i][column].getValue() == 1) 
    			colSum = colSum + spot[i][column].getRow();
    		if (spot[row][i].getValue() == 1)
    			rowSum = rowSum + spot[row][i].getColumn();    		
    	}

    	if (column == spot.length - 1 && !(checkRow(spot,row)))
    		return false;
    	if (row == spot.length - 1 && !(checkColumn(spot,column)))
    		return false;
    	if (rowSum <= sum[0][row] && colSum <= sum[1][column])
    		return true;
    	else
    		return false; 
    }

    public boolean checkAllConstraints(Spot[][] spot) {
    	
    	for (int i = 0; i < spot.length; i++){
    		if (!(checkRow(spot,i) && checkColumn(spot,i)))
    			return false;
    	}
    	return true;
    }

    public void showFrame (FinalFrame frame, Spot[][] spot){
    	
    	for (int i = 0; i < spot.length; i++){
    		for (int j = 0; j < spot.length; j++){
    			if (spot[i][j].getValue() == 1)
    				spot[i][j].setBackground(Color.PINK);
    			else
    				spot[i][j].setBackground(null); 			
    		}
    	}
    	frame.validate();
    	frame.repaint();
    }
    
    public boolean checkRow(Spot[][] spot, int row) {
	
    	int rowTotal = 0; 

    	for (int i = 0; i < size; i++) {
    		if (spot[row][i].getValue() == 1)
    			rowTotal = rowTotal + spot[row][i].getColumn(); 
    	}

    	if (rowTotal == sum[0][row])
    		return true; 
    	else 
    		return false; 
    }
    
    public boolean checkColumn(Spot[][] spot, int column) {
	
    	int columnTotal = 0; 

    	for (int i = 0; i < size; i++) {
    		if (spot[i][column].getValue() == 1)
    			columnTotal = columnTotal + spot[i][column].getRow();
		}
		
    	if (columnTotal == sum[1][column])
    		return true; 
    	else 
    		return false; 
    }

}