/**
 * EpuzzleState class extends SearchState class 
 * 
 * It is responsible for what each nodes need to including getSucessors, goalPreidcate,sameState 
 * and some other necessary support methods
 * 
 * author YI LI
 */

import java.util.ArrayList;

public class EpuzzleState extends SearchState {
    
	private int[] puzzBoard; //puzzBoard stores the Epuzzle numbers
    private int space=0; // space stores the index of 0 in an Epuzzle array
    
    //Constructor
    public EpuzzleState(int[] puzzBoard) {
    	this.puzzBoard=new int [puzzBoard.length];
    	for(int i=0; i<puzzBoard.length; i++) {
    		this.puzzBoard[i]=puzzBoard[i];
    	}
    }
    
    /**
     * accessor for puzzBoard
     * @return puzzBoard
     */
    public int[] getPuzzBoard() {
    	return puzzBoard;
    }

    /**
     * get the index of 0 in the Epuzzle array
     * @return space
     */
    public int getSpace(int[] board) {
    	for(int i=0; i<9; i++) {
    		if(board[i] == 0) {
    			space = i;
    		}
    	}
    	return space;
    }
    
    /**
     * change the index position from n1 to n2 in the Epuzzle array
     * and add the next successors with the Epuzzle with changing number order
     */
    public void changePosition(int n1, int n2, ArrayList<EpuzzleState> eps) {
    	//copy a new one Epuzzle so as to avoid changing the old one  
    	int[] board = new int[9];
    	for(int i=0; i<9; i++) {
    		board[i]=puzzBoard[i];
    	}
    	int temp = board[n1];
    	board[n1] = puzzBoard[n2];
    	board[n2] = temp;
    	//add s successor
    	eps.add(new EpuzzleState(board));
    }
    
    /**
     * determine if the parameter is the goal
     * @return boolean
     */
	@Override
	public boolean goalPredicate(Search searcher) {
		EpuzzleSearch epSearcher = (EpuzzleSearch) searcher;
		for(int i=0; i<epSearcher.getSize(); i++) {
			if(epSearcher.getGoal()[i]!=puzzBoard[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * check where 0 number is and exchange 
	 * the position of 0 with which pposition is near 0 
	 * @return  ArrayList<SearchState>
	 */
	@Override
	public ArrayList<SearchState> getSuccessors(Search searcher) {
	
		
		getSpace(puzzBoard);
		
		ArrayList<EpuzzleState> zplist = new ArrayList<EpuzzleState>();
		ArrayList<SearchState> slist = new ArrayList<SearchState>();
		
		if (space != 0 && space != 3 && space != 6) {
		    changePosition(space-1, space, zplist);
        }

        if (space != 6 && space != 7 && space != 8) {
        	changePosition(space+3, space, zplist);
        }

        if (space != 0 && space != 1 && space != 2) {
        	changePosition(space-3, space, zplist);
        }
        
        if (space != 2 && space != 5 && space != 8) {
        	changePosition(space+1, space, zplist);
        }
		
		for (EpuzzleState z : zplist) {
			slist.add((SearchState) z);
		}
		return slist;
	}

	/**
     * determine if the parameter is the same with older one 
     * @return boolean
     */
	@Override
	public boolean sameState(SearchState s) {
		EpuzzleState epState = (EpuzzleState) s;
		for(int i=0; i<9; i++) {
			if(puzzBoard[i] != epState.getPuzzBoard()[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * convert the data stored in the array into the 3 by 3 matrix of ints 
	 * @return statement of Epuzzle
	 */
	public String toString() {
		String output = "8 puzzle state:\n\n";
		int count=0;
		for(int n:puzzBoard) {
			count++;
			output+=" "+n+" ";
			if(count%3 == 0) {
				output+="\n";
			}
		}
		return output;
	}
}
