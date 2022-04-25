public class EpuzzleSearch extends Search {
	private int[] goal;
	private final int size = 9;
	public EpuzzleSearch(int[]goal){
		this.goal = new int[goal.length];
		for(int i=0; i<goal.length; i++) {
			this.goal[i] = goal[i];
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int[] getGoal(){
		return goal;
	}
	
	
}