import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import kareltherobot.*;
import kareltherobot.World;
import kareltherobot.WorldBuilder;


public class SearchNSortThing {

	String message = "Here are the stats:  ";
	
	
	List<SortableRobot> botList = new ArrayList<SortableRobot>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SearchNSortThing().start();
//		new WorldBuilder(true).setVisible(true);
		World.setVisible(true);
	}

	private void start() {
		makeListOfBots();
		findMax();
		//findMin();
		//selectionSort();
		bubbleSort();
		showStats();
		
		System.out.println(message);
		//JOptionPane.showMessageDialog(null, message);
	}

	private void bubbleSort() {
		for(int looper = 1; looper<botList.size()-1; looper++){
			if(botList.get(looper-1).compareTo(botList.get(looper)) == 1){
				System.out.println(botList.get(looper-1).getNumBeeps());
				System.out.println("returning");
			}
			else if(botList.get(looper-1).compareTo(botList.get(looper)) == -1){
				botList.get(looper-1).swapLoc(botList.get(looper));
				botList.set(looper-1, botList.get(looper));
				botList.set(looper, botList.get(looper-1));
				looper = 0;
			}
			else if(botList.get(looper-1).compareTo(botList.get(looper)) == 0){
				System.out.println("Even, returning");
			}
		}
		
	}

	private void selectionSort() {
		
		// find minPos starting with "front"
		
		//String str = JOptionPane.showin
		
		for(int front = 0; ;front++){
			
			botList.get(0).swapLoc(botList.get(3));
		}
		
		
	}
//	private void swap(int left, int right) {
//		SortableRobot lbot = botList.get(left),
//					  rbot = botList.get(right);
//		botList.set(right, lbot);
//		botList.set(left, rbot);
//		// now, swap on screen
//		int lst = lbot.street(),lav = lbot.avenue();
//		lbot.moveTo(rbot.street(), rbot.avenue());
//		rbot.moveTo(lst, lav);
//		
//		
//	}

	private void showStats(){
		
		System.out.println(botList);
	//	System.out.println("The area was : "+ len*wid);
		//message+="The area was : "+ len*wid+"\n";
		
	}
	
	private int findMax(int front) {
		int maxIndex = front;
		for(int looper = 1; looper < botList.size()-1; looper++){
			if(botList.get(maxIndex).compareTo(botList.get(looper))==-1)
				maxIndex = looper;
		}
		return maxIndex;
	}
	private int findMax() {
		// returns index where "Max" robot is found
		//int maxIndex = 0;
		return findMax(0);
	}

	private void makeListOfBots() {
		int numBots = 10;
		
		
		
		
		
		
		
		
		
		
		
		
		
		SortableRobot sr = null;
		Random wheel = new Random();
		World.setVisible(true);
		World.setDelay(5);
		for(int x = 0; x < numBots; x++){
			int beeps = wheel.nextInt(15)+17;
			sr = new SortableRobot(1, x+1, beeps);
			botList.add(sr);
		}
		for(int x = 0; x < botList.size(); x++){
			botList.get(x).move();
		}
		for(int x = botList.size()-1; x >=0 ; x--){
			botList.get(x).move();
		}
		
	}

}
