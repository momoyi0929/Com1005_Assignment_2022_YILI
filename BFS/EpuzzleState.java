import java.util.ArrayList;
public class EpuzzleState extends SearchState {

    private int[] puzzBoard;
    private int space=0;

    public EpuzzleState(int[] puzzBoard) {
    	this.puzzBoard=new int [puzzBoard.length];
    	for(int i=0; i<puzzBoard.length; i++) {
    	    this.puzzBoard[i]=puzzBoard[i];
    	}
    }
    
    public int getSpace(int[] board) {
    	for(int i=0; i<9; i++) {
    	    if(board[i] == 0) {
    		space = i;
    	    }
    	}
    	return space;
    }
    
    public int[] getPuzzBoard() {
    	return puzzBoard;
    }

    @Override
    public boolean goalPredicate(Search searcher){
        EpuzzleSearch epSearcher = (EpuzzleSearch) searcher;
	for(int i=0; i<epSearcher.getSize(); i++) {
	    if(epSearcher.getGoal()[i]!=puzzBoard[i]) {
		return false;
	    }
	}
	return true;
    }

    
    @Override
    public ArrayList<SearchState> getSuccessors(Search searcher) {
	int size = ((EpuzzleSearch) searcher).getSize();
	int[] board = new int[size];
	for(int i=0; i<size; i++) {
    	    board[i]=puzzBoard[i];
    	}
	getSpace(board);
	ArrayList<EpuzzleState> zplist = new ArrayList<EpuzzleState>();
	ArrayList<SearchState> slist = new ArrayList<SearchState>();
		 
	switch(space) {
	case 0:
	    changePosition(space, 1, zplist);//space+1
	    changePosition(space, 3, zplist);//space+3
	case 1:
            changePosition(space, 0, zplist);//space-1
	    changePosition(space, 2, zplist);//space+1
	    changePosition(space, 4, zplist);//space+3
	case 2:
	    changePosition(space, 1, zplist);//space-1
	    changePosition(space, 5, zplist);//space+3
	case 3:
	    changePosition(space, 0, zplist);//space-3
	    changePosition(space, 4, zplist);//space+1
	    changePosition(space, 6, zplist);//space+3
	case 4:
	    changePosition(space, 1, zplist);//space-3
	    changePosition(space, 3, zplist);//space-1
	    changePosition(space, 5, zplist);//space+1
	    changePosition(space, 7, zplist);//space+3
	case 5:
	    changePosition(space, 2, zplist);//space-3
	    changePosition(space, 4, zplist);//space-1
	    changePosition(space, 8, zplist);//space+3
	case 6:
	    changePosition(space, 3, zplist);//space-3
	    changePosition(space, 7, zplist);//space+1
	case 7:
	    changePosition(space, 6, zplist);//space-1
	    changePosition(space, 4, zplist);//space-3
	    changePosition(space, 8, zplist);//space+1
	case 8:
	    changePosition(space, 7, zplist);//space-1
	    changePosition(space, 5, zplist);//space-3
	}
	    
	for (EpuzzleState z : zplist) {
		slist.add((SearchState) z);
	}
	return slist;
    }

    @Override   
    public boolean sameState(SearchState n2){
        EpuzzleState epState = (EpuzzleState) s;
	for(int i=0; i<epState.getPuzzBoard().length; i++) {
	    if(puzzBoard[i] != epState.getPuzzBoard()[i]) {
		return false;
	    }
	}
	return true;
    }
    public String toString() {
	String output = "8 puzzle state: ";
	for(int n:puzzBoard) {
		output+=n;
	}
	return output;
    }
}
