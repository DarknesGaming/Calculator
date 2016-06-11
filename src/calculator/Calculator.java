/*------------------------------------------------
|                                                |
|           Core Calculator Class File           |
|                                                |
|            Created by DarknesGaming            |
|                                                |
|             Version 0.1.0 Build 3              |
|                                                |
------------------------------------------------*/

package calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	public static void main(String[] arguments) {
		Calculator c = new Calculator();
	}
	    // Modify this to add another row.
		JPanel[] row = new JPanel[6];
		// Modify this to add more buttons.
		JButton[] button = new JButton[24];
		// Modify this so the names of the buttons will be visible. All buttons need to be in order!
		String[] buttonString = {"7", "8", "9", "+",
				                 "4", "5", "6", "-",
				                 "1", "2", "3", "*",
				                 ".", "/", "C", "√",
				                 "+/-", "=", "0", 
				                 "sin", "cos", "tan", "PI", "%",
		};
		int[] dimW = {600, 90, 200, 180};
		int[] dimH = {70, 80};
		Dimension displayDimension = new Dimension(dimW[0], dimH[0]); // Display Window
		Dimension regularDimension = new Dimension(dimW[1], dimH[1]); // Button Size
		Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]); // Right Column
		Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]); // The Zero Button
		Dimension trigDimension = new Dimension(dimW[1], dimH[1]);
		boolean[] function = new boolean[4];
		double[] temporary = {0, 0};
		JTextArea display = new JTextArea(1,20);
		Font font = new Font("Times new Roman", Font.BOLD, 24);
		
		Calculator() {
			super("Calculator v0.1.0 Build 10"); // Program Title
			setDesign();
			setSize(760, 600); // Resolution of Calculator (Width, Height)
			setResizable(false); // Can we resize this window?
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			// Row, buttons per row. Edit the first digit to add more rows in GridLayout!
			GridLayout grid = new GridLayout(6,6); 
			setLayout(grid);
			
			for(int i = 0; i < 4; i++)
                function[i] = false;
			
			FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
			FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
			for(int i = 0; i < 6; i++) // The number after the < sign is the rows.
				row[i] = new JPanel();
		    for(int i = 0; i < 6; i++) // The number after the < sign is the rows.
				row[i].setLayout(f2);
		    
		    // Edit this to add more buttons and not run into errors!
			for(int i = 0; i < 24; i++) {
				button[i] = new JButton();
				button[i].setText(buttonString[i]);
				button[i].setFont(font);
				button[i].addActionListener(this);
			}
			
			// Display
			display.setFont(font);
			display.setEditable(false);
			display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			display.setPreferredSize(displayDimension);
			
			// Buttons
			for(int i = 0; i < 14; i++)
                button[i].setPreferredSize(regularDimension);
			for(int i = 14; i < 18; i++)
                button[i].setPreferredSize(rColumnDimension);
            button[18].setPreferredSize(zeroButDimension);
            for(int i = 19; i < 24; i++)
		        button[i].setPreferredSize(trigDimension);  
			
            // Row 0
            row[0].add(display);
            add(row[0]);
            
            // Row 1
            for(int i = 0; i < 4; i++)
            	row[1].add(button[i]);
            row[1].add(button[14]);
            add(row[1]);
            
            // Row 2
            for(int i = 4; i < 8; i++)
            	row[2].add(button[i]);
            row[2].add(button[15]);
            add(row[2]);
            
            // Row 3
            for(int i = 8; i < 12; i++)
            	row[3].add(button[i]);
            row[3].add(button[16]);
            add(row[3]);
            
            // Row 4
            row[4].add(button[18]);
            for(int i = 12; i < 14; i++)
            	row[4].add(button[i]);
            row[4].add(button[17]);
            add(row[4]);
            
            // Row 5 (Work in Progress)
            for(int i = 19; i < 23; i++)
            	row[5].add(button[i]);
            row[5].add(button[23]);
            add(row[5]);
            
            
            setVisible(true); // Required so you can see the buttons.
		}
	

	private static void setDesign() {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.Icons"); // Change this if you want a different look.
		} catch(Exception e) {
		}
	}
	
	// List of buttons and their functions.
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == button[0])
			display.append("7");
		if(ae.getSource() == button[1])
			display.append("8");
		if(ae.getSource() == button[2])
			display.append("9");
		if(ae.getSource() == button[3]) {
			// add function[0]
			temporary[0] = Double.parseDouble(display.getText());
			function[0] =  true;
			display.setText("");
		}
		if(ae.getSource() == button[4])
			display.append("4");
		if(ae.getSource() == button[5])
			display.append("5");
		if(ae.getSource() == button[6])
			display.append("6");
		if(ae.getSource() == button[7])  {
			// subtract function[1]
			temporary[0] = Double.parseDouble(display.getText());
		    function[1] = true;
		    display.setText("");
	    }
		if(ae.getSource() == button[8])
			display.append("1");
		if(ae.getSource() == button[9])
			display.append("2");
		if(ae.getSource() == button[10])
			display.append("3");
		if(ae.getSource() == button[11]) {
			// multiply function[2]
			temporary[0] = Double.parseDouble(display.getText());
		    function[2] = true;
		    display.setText("");
	    }
		if(ae.getSource() == button[12])
			display.append(".");
		if(ae.getSource() == button[13]) {
			//divide function[3]
			temporary[0] = Double.parseDouble(display.getText());
			function[3] = true;
			display.setText("");
		}
		if(ae.getSource() == button[14])
			clear();
		if(ae.getSource() == button[15])
			getSqrt();
		if(ae.getSource() == button[16])
			getPosNeg();
		if(ae.getSource() == button[17])
			getResult();
		if(ae.getSource() == button[18])
			display.append("0");	
		if(ae.getSource() == button[19])
			getSine();
		if(ae.getSource() == button[20])
			getCos();
		if(ae.getSource() == button[21])
			getTan();
		if(ae.getSource() == button[22])
			getPI();
		if(ae.getSource() == button[23])
			display.append("%");

	} // End of button list
	
	// Button functions (only for certain buttons)
	public void clear() {
		try {
			display.setText(""); // Sets the display blank
			for(int i = 0; i < 4; i++)
				function[i] = false; // Sets the functions back to false
			for(int i = 0; i < 2; i++)
				temporary[i] = 0; //Sets our temporary variables back to 0
		} catch(NullPointerException e) {
		}
	}
	public void getSqrt() {
		try {
			double value = Math.sqrt(Double.parseDouble(display.getText()));
			display.setText(Double.toString(value));
		} catch(NumberFormatException e) {
		}
	}
	public void getPosNeg() {
		try {
		double value = Double.parseDouble(display.getText());
		if(value != 0) {
			value = value * (-1);
			display.setText(Double.toString(value));
		}
		else {
		}
		
	} catch(NumberFormatException e) {
		}
	}
	public void getResult() {
		double result = 0; // variable for result
		temporary[1] = Double.parseDouble(display.getText());
		String temp0 = Double.toString(temporary[0]);
		String temp1 = Double.toString(temporary[1]);
		try {
			if(temp0.contains("-")) {
				String[] temp00 = temp0.split("-", 2);
				temporary[0] = (Double.parseDouble(temp00[1]) * -1);
			}
			if(temp1.contains("-")) {
				String[] temp11 = temp1.split("-", 2);
				temporary[1] = (Double.parseDouble(temp11[1]) * -1);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		}
		try {
			if(function[2] == true)
				result = temporary[0] * temporary[1]; //sets result to multiplication
			else if(function[3] == true) //now division
				result = temporary[0] / temporary[1];
			else if(function[0] == true) //now addition
				result = temporary[0] + temporary[1];
			else if(function[1] == true) //now subtraction
				result = temporary[0] - temporary[1];
			display.setText(Double.toString(result));
			for(int i = 0; i < 4; i++)
				function[i] = false;
		} catch(NumberFormatException e) {
		}
	}
	public void getSine() {
		try {
			double value = Math.sin(Double.parseDouble(display.getText()));
			display.setText(Double.toString(value));
		} catch(NumberFormatException e) {
		}
	}
	public void getCos() {
		try {
			double value = Math.cos(Double.parseDouble(display.getText()));
			display.setText(Double.toString(value));
		} catch(NumberFormatException e) {
		
		}
	}
	public void getTan() {
		try {
			double value = Math.tan(Double.parseDouble(display.getText()));
			display.setText(Double.toString(value));
		} catch(NumberFormatException e) {
			
		}
	}
    public void getPI() {
    	try {
    		double value = Math.PI;
    		display.setText(Double.toString(value));
    	} catch(NumberFormatException e) {
    		
    	}
    }

    /*public void get */
    
    
}
