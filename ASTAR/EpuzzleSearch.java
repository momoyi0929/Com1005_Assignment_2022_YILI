public class EpuzzleSearch extends Search {
	private int[][] puzz;
	private int[][] goal;
	
	EpuzzleSearch(int[][]puzz,int[][]goal){
		this.puzz=puzz;
		this.goal=goal;
	}
	
	public int[][] getPuzz(){
		return puzz;
	}
	
	public int[][] getGoal(){
		return goal;
	}
	
}
