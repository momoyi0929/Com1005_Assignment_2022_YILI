public class EpuzzleSearch extends Search {
	private int[][] goal;
	
	EpuzzleSearch(int[][] goal){
		this.goal = new int[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.goal[i][j]=goal[i][j];
			}
		}
	}
	
	
	public int[][] getGoal(){
		return goal;
	}
	
	
}
