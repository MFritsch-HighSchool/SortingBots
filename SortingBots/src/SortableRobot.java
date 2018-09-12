import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
public class SortableRobot extends Robot implements Comparable<SortableRobot> {
	
	Direction dir = North; private int st; private int ave; private int beeps;
	public int steps = 0;
	public SortableRobot(int st, int ave, int beeps) {
		super(st, ave, North, beeps);
		this.st = st; this.ave = ave; this.beeps = beeps;
		this.beeps = beeps;
	}
	
	@Override
	public int compareTo(SortableRobot o) {
		if(o.getNumBeeps()<this.getNumBeeps())
			//if original robot is bigger
			return 1;
		else if(o.getNumBeeps()>this.getNumBeeps())
			//if original robot is smaller
			return -1;
		//if robots are equal
		return 0;
	}

	public void moveTo(int newStreet, int newAvenue) {
		System.out.println("new street = "+newStreet);
		System.out.println("new ave = "+newAvenue);
		System.out.println("current street is "+super.street());
		System.out.println("current ave is "+super.avenue());
		if(avenue()<newAvenue){
			while(dir!=West)
				turnLeft();
			while(avenue()<newAvenue)
				move();
		}
		if(street()<newStreet){
			while(dir!=North)
				turnLeft();
			while(street()<newStreet)
				move();
		}
		if(avenue()>newAvenue){
			while(dir!=East)
				turnLeft();
			while(avenue()>newAvenue)
				move();
		}
		if(street()>newStreet){
			while(dir!=South)
				turnLeft();
			while(street()>newStreet)
				move();
		}
	}
	public void swapLoc(SortableRobot o){
		int aSt = this.street();
		int aAve = this.avenue();
		this.moveTo(o.street(), o.avenue());
		o.moveTo(aSt, aAve);
	}

	public void dropBeepsInLine() {
		while(beepers()>0){
			putBeeper();
			move();
		}
	}

	public int getNumBeeps() {
		//System.out.println("DOOPA DOOPA DOOP "+beeps);
		return beeps;
	}
	
	public void turnLeft(){
		
	}
	
	public void move(){
		super.move();
		steps++;
	}


}
