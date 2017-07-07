import java.awt.event.*; 

public class SolveListener implements ActionListener {

    private FinalFrame frame;
    private Solver solver;
    private Spot[][] spot; 
    private int[] possibleValues; 

    public SolveListener (FinalFrame fr, Solver s, Spot[][] spots, int[] possible) {
    	frame = fr;
    	solver = s;
    	spot = spots; 
    	possibleValues = possible; 
    }

    public void actionPerformed(ActionEvent e) {
    	solver.solvePuzzle(frame, spot, possibleValues); 
    }

}