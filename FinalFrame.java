import java.awt.*;
import javax.swing.*;


public class FinalFrame extends JFrame {
    
    private JLabel message1;
    private JLabel checked = new JLabel("");
    
    //Initial Frame
    public void init() { 

    	// Exit when window is closed
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	Container ct = getContentPane();	

        ct.setLayout(new GridLayout(0,4)); 

        
        JButton firstGame = new JButton();
        firstGame.setText("Kakurasu"); 
        ct.add(firstGame); 
        firstGame.addActionListener(new KakurasuSwitcher(this)); 

        JButton secondGame = new JButton(); 
        secondGame.setText("Akari"); 
        ct.add(secondGame); 
        secondGame.addActionListener(new AkariSwitcher(this)); 

        JButton thirdGame = new JButton(); 
        thirdGame.setText("Ripple Effect"); 
        ct.add(thirdGame); 
        thirdGame.addActionListener(new RippleEffectSwitcher(this)); 

        message1 = new JLabel("Choose a game.");
        ct.add(message1);

    }

    //Kakurasu Frame
    public void initKak() { 

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	Container ct = getContentPane();	

    	KakurasuConstraint game = new KakurasuConstraint(); 

    	int size = game.getSize(); 
		int sums[][] = game.getSums(); 

        ct.setLayout(new GridLayout(0,size + 2)); 
	
        Spot[][] spots = new Spot[size][size]; 
        Spot[][] unfilled; 

        for (int i = 0; i < size + 2; i++) { 
        	for (int j = 0; j < size + 2; j++) {
        		if (i == 0 && j >= 1 && j <= size) {
        			JLabel number = new JLabel(j + ""); 
        			ct.add(number); 
        		}

        		else if (j == 0 && i >= 1 && i <= size) {
        			JLabel number = new JLabel(i + ""); 
        			ct.add(number); 
        		}
        		
        		else if (j == 6 && i >= 1 && i <= size) {
        			JLabel sum = new JLabel(sums[0][i-1] + ""); 
        			ct.add(sum); 
        		}

        		else if (i == 6 && j >= 1 && j <= size) {
        			JLabel sum = new JLabel(sums[1][j-1] + ""); 
        			ct.add(sum); 
        		}

        		else if (i > 0 && i < (size + 1) && j > 0 && j < (size + 1)) {
        			Spot s = new Spot (game, this, i, j, 0); 
        			ct.add(s); 
        			spots [i-1][j-1] = s; 
        			s.addActionListener(new SpotListener(this, s)); 
        		}
		
        		else {
        			JLabel blank = new JLabel(""); 
        			ct.add(blank); 
        		}		
        	}
        }

        unfilled = spots; 
        addSolve(ct, game, unfilled, game.getPossibleValues());
        addMenu(ct, game, unfilled, game.getPossibleValues());
        addCheck(ct, game, spots);
        ct.add(checked);
    }

    //RippleEffect Frame
    public void initRe() {

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	Container ct = getContentPane();

    	RippleEffectConstraint game = new RippleEffectConstraint(); 

    	int size = game.getSize(); 
    	int[][][] rooms = game.getRooms(); 

    	ct.setLayout(new GridLayout(0,size)); 

    	Spot[][] spots = new Spot[size][size]; 
    	Spot[][] unfilled; 

    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) { 
    			Spot s = new Spot (game, this, i, j, 0); 
    			ct.add(s); 
    			spots [i][j] = s; 
    			s.addActionListener(new RippleSpotMenu(this, s)); 
    		}
    	}

    	for (int i = 0; i < rooms.length; i++) { 
    		Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)); 
    		for (int j = 0; j < rooms[i].length; j++) {		
    			spots[rooms[i][j][0]][rooms[i][j][1]].setBackground(c);
			spots[rooms[i][j][0]][rooms[i][j][1]].setRoom(i);    		}
    	}

    	unfilled = spots; 
    	addSolve(ct, game, unfilled, game.getPossibleValues());
        addMenu(ct, game, unfilled, game.getPossibleValues());
        addCheck(ct, game, spots);
        ct.add(checked);
    }
    
    //Akari Frame
    public void initAkari() {

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	Container ct = getContentPane();

    	AkariConstraint game = new AkariConstraint(); 
    	int size = game.getSize(); 
    	int[][] blackSpace = game.getBlackSpace(); 

    	ct.setLayout(new GridLayout(0,size)); 

    	Spot[][] spots = new Spot[size][size]; 
    	Spot[][] unfilled; 

    	for (int i = 0; i < size; i++) {
    	    for (int j = 0; j < size; j++) { 
    		boolean isBlack = false; 
    		Spot s = new Spot(game, this, i, j, 0); 
    		for (int k = 0; k < blackSpace.length; k++) {
    		    if (blackSpace[k][1] == i && blackSpace[k][2] == j) {
    			s.setFilled(true);  
    			s.setDark(true); 
    			isBlack = true; 
    			if (blackSpace[k][0] != -1) {
    			    JLabel howFar = new JLabel(blackSpace[k][0] + "");
    			    ct.add(howFar);
    			}
    			else {
    			    JLabel howFar = new JLabel("");
    			    ct.add(howFar);
    			}
    		    }
    		}
    		if (!isBlack) 
    		    ct.add(s); 
    		spots [i][j] = s; 
    		s.addActionListener(new SpotListener(this, s));
    	    }
    	}
    	
    	unfilled = spots; 
    	addSolve(ct, game, unfilled, game.getPossibleValues());
        addMenu(ct, game, unfilled, game.getPossibleValues());
        addCheck(ct, game, spots);
        ct.add(checked);

    }
    
    public void addSolve(Container ct, Solver game, Spot[][] spot, int[] possibleValues) {
    	
    	JButton solve = new JButton(); 
    	solve.setText("Solve"); 
    	ct.add(solve); 
    	solve.addActionListener(new SolveListener(this, game, spot, possibleValues)); 
    }

    public void addMenu(Container ct, Solver game, Spot[][] spot, int[] possibleValues){
    	
    	JButton menu = new JButton();
    	menu.setText("Menu");
    	ct.add(menu);
    	menu.addActionListener(new MenuListener(this));   	
    }
    
    public void addCheck(Container ct, Solver game, Spot[][] spot){
    	
    	JButton check = new JButton();
    	check.setText("Check");
    	ct.add(check);
    	check.addActionListener(new CheckListener(this, game, spot, checked));
    }
}