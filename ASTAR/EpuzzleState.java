import java.util.ArrayList;

public class EpuzzleState extends SearchState{

	private int[][] puzz;
        private final int size = 3; 
    
        EpuzzleState(int[][]puzz,int localCost,int estRemCost){
    	        this.puzz = new int[size][size];
    	        for(int i=0; i<size; i++) {
    		    for(int j=0; j<size; j++) {
    			    this.puzz[i][j]=puzz[i][j];
    		    }
    	        }
    	        this.localCost=localCost;
    	        this.estRemCost=estRemCost;
        }
    
        public int[][] getPuzz() {
    	        return puzz;
        }
    
        public int getSize() {
		return size;
        }
	
	
	@Override
	boolean goalPredicate(Search searcher) {
		EpuzzleSearch s = (EpuzzleSearch) searcher;
		int[][] tar = s.getGoal();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(tar[i][j] != this.puzz[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		
		return null;
	}

	@Override
	boolean sameState(SearchState n2) {
		EpuzzleState s = (EpuzzleState) n2;
		int[][] p = s.getPuzz();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(p[i][j] != this.puzz[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String toString() {
		String output = "8 puzzle state:\n";
		int count=0;
		for(int[] a:this.puzz) {
			for(int i:a) {
				count++;
				output+=" "+i+" ";
				if(count%3 == 0) {
					output+="\n";
				}
			}
			
		}
		return output;
	}
	
}
