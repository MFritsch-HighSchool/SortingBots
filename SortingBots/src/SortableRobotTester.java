import java.util.ArrayList;
import java.util.List;
import kareltherobot.Robot;
import kareltherobot.World;


public class SortableRobotTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.setVisible(true);
		World.setDelay(4);
		int x = (int) (Math.random()*50);
		
		SortableRobot sr = new SortableRobot(1,1,6),
				      sr1 = new SortableRobot(1,2,5),
				      sr2 = new SortableRobot(1,3,2);
		List<SortableRobot> botList = new ArrayList<SortableRobot>();
		testComparable(sr1,sr);
		
		System.out.println("Sr has "+ sr.getNumBeeps() +" beeps");
		System.out.println("Sr1 has "+sr1.getNumBeeps());
		System.out.println("Sr2 has "+sr2.getNumBeeps());
		botList.add(sr2);
		botList.add(sr1);
		botList.add(sr);
		
		
		
//		for(int i = 0; i < 10; i++){
//			sr = new SortableRobot(3,5,90);
//			botList.add(sr);
//		}
		
		
		
		for(SortableRobot r:botList){
			r.dropBeepsInLine();
		}
		sr1.swapLoc(sr);
		
		
		testComparable(sr1,sr);
		sr.moveTo(9, 2);
		sr.moveTo(4, 8);
		System.out.println("Swapping Loc!");
		
		
	}

	private static void testComparable(SortableRobot sr1, SortableRobot sr) {
		// TODO Auto-generated method stub

		if(sr1.compareTo(sr)<0){
			System.out.println(sr + " is bigger than "+sr1);
		}
		else if(sr1.compareTo(sr)>0){
			System.out.println(sr1 + " is bigger than "+sr);
		}
		else
			System.out.println(sr1 + " is equal to "+sr);
			
	}

}
