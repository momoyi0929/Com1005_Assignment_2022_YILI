/**
 * RunEpuzzleASTAR class has the main method and
 * provides different data example to test
 * 
 * The 8-puzzle numbers are stored in the array
 * 
 * @author YI LI
 */

public class RunEpuzzleBFS {
	 public static void main(String[] arg) {
		 //goal
		 final int[] goal = {1,2,3,4,5,6,7,8,0};
		 //data example
		 int[] example1 = {1,0,3,4,2,6,7,5,8};
		 int[] example2 = {4,1,3,7,2,5,0,8,6};
		 int[] example3 = {2,3,6,1,5,8,4,7,0};
		 int[] puzz = {4,3,6,1,2,5,7,8,0};
		 //run programming
		 EpuzzleSearch searcher1 = new EpuzzleSearch(goal);
		 SearchState initState = (SearchState) new EpuzzleState(puzz);
		 String resd = searcher1.runSearch(initState, "breathFirst");
		 System.out.println(resd);
	}
}
