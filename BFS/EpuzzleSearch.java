/**
 * EpuzzleSearch extends Search
 * @author YI LI
 *
 */
public class EpuzzleSearch extends Search {
	private int[] goal;
	private final int size = 9;
	
	/**
	   * constructor
	   * 
	   * @param goal int[]
	   */
	public EpuzzleSearch(int[]goal){
		this.goal = new int[goal.length];
		for(int i=0; i<goal.length; i++) {
			this.goal[i] = goal[i];
		}
	}
	/**
	   * accessor for size
	   */
	public int getSize() {
		return size;
	}
	/**
	   * accessor for goal
	   */
	public int[] getGoal(){
		return goal;
	}	
}
