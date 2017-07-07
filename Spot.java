import javax.swing.JButton;

public class Spot extends JButton {

    private Solver game; 
    private FinalFrame frame; 
    private int row;
    private int column; 
    private int value; 
    private boolean filled = false; 
    private int room;
    private boolean dark = false;
    
    public Spot(Solver s, FinalFrame fr, int r, int c, int v) {
	
    	game = s; 
    	frame = fr; 
    	row = r; 
    	column = c; 
    	value = v; 
    	
    }

    public boolean getFilled() {
    	return filled;
    }

    public void setFilled(boolean isFilled) {
    	filled = isFilled; 
    }

    public int getValue() {
    	return value; 
    }

    public void setValue(int newValue) {
    	value = newValue; 
    }

    public int getRow() {
    	return row; 
    }

    public int getColumn() {
    	return column;
    }

	public Solver getGame() {
		return game;
	}

	public FinalFrame getFrame(){
		return frame;
	}
	
	public int getRoom(){
		return room;
	}
	
	public void setRoom(int number){
		room = number;
	}
	
	public boolean getDark(){
		return dark;
	}
	
	public void setDark(boolean dark){
		dark = dark;
	}

}

	