import java.util.ArrayList;

import java.util.ArrayList;

public class EpuzzleState extends SearchState{
    
	private int[][] puzz;
    private final int size = 3; 
    private int spaceOfLine;
    private int spaceOfColumn;
    
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

    public void setSpace(int[][] board) {
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			if(board[i][j] == 0) {
        			spaceOfLine=i;
        			spaceOfColumn=j;
        		}
    		}	
    	}
    }
    
	public int Hamming(int[][] arr) {
		int count=0;
		int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(arr[i][j]!=goal[i][j] ) {
					count++;
				}
			}
		}
		this.estRemCost=count;
		return count;
	}
	
	public int Manhattan(int[][] arr) {
		int output=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				switch(arr[i][j]) {
			    case 1:
			    	output+=Math.abs(i+j);
			    case 2,4:
			    	output+=Math.abs(i+j-1);
			    case 3,5,7:
			    	output+=Math.abs(i+j-2);
			    case 6,8:
			    	output+=Math.abs(i+j-3);
			    case 0:
			    	output+=Math.abs(0);
				}
			}
		}
		this.estRemCost=output;
		return output;
	}

	public void changePosition(int i1,int j1, int i2,int j2, ArrayList<EpuzzleState> eps) {
	   	int[][] board = new int[3][3];
	   	for(int i=0; i<size; i++) {
	   		for(int j=0; j<size; j++) {
	   			board[i][j]=puzz[i][j];
	   		}
	   	}
	   	int temp = board[i1][j1];
	   	board[i1][j1] = puzz[i2][j2];
	   	board[i2][j2] = temp;
	   	eps.add(new EpuzzleState(board,1,Hamming(board)));
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
		
		setSpace(puzz);
		ArrayList<EpuzzleState> zplist = new ArrayList<EpuzzleState>();
		ArrayList<SearchState> slist = new ArrayList<SearchState>();
		
		if(spaceOfLine==0) {		
			if(spaceOfColumn==0) {
				changePosition(0,1,0,0,zplist);
				changePosition(1,0,0,0,zplist);
			}else if(spaceOfColumn==1){
				changePosition(0,0,0,1,zplist);
				changePosition(0,2,0,1,zplist);
				changePosition(1,1,0,1,zplist);
			}else if(spaceOfColumn==2) {
				changePosition(0,1,0,2,zplist);
				changePosition(1,2,0,2,zplist);
			}
		}else if(spaceOfLine==1) {
			if(spaceOfColumn==0) {
				changePosition(0,0,1,0,zplist);
				changePosition(1,1,1,0,zplist);
				changePosition(2,0,1,0,zplist);
			}else if(spaceOfColumn==1){
				changePosition(0,1,1,1,zplist);
				changePosition(1,0,1,1,zplist);
				changePosition(1,2,1,1,zplist);
				changePosition(2,1,1,1,zplist);
			}else if(spaceOfColumn==2) {
				changePosition(0,1,1,2,zplist);
				changePosition(1,2,1,2,zplist);
			}
		}else if(spaceOfLine==2) {
			if(spaceOfColumn==0) {
				changePosition(1,0,2,0,zplist);
				changePosition(2,1,2,0,zplist);
			}else if(spaceOfColumn==1){
				changePosition(2,0,2,1,zplist);
				changePosition(2,2,2,1,zplist);
				changePosition(1,1,2,1,zplist);
			}
		}
		for (EpuzzleState z : zplist) {
			slist.add((SearchState) z);
		}
		return slist;
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
