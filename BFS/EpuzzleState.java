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

    //change the position between n1 and n2
    public void changePosition(int n1, int n2, ArrayList<EpuzzleState> eps) {
    	int[] board = new int[9];
    	for(int i=0; i<9; i++) {
    		board[i]=puzzBoard[i];
    	}
    	int temp = board[n1];
    	board[n1] = puzzBoard[n2];
    	board[n2] = temp;
    	eps.add(new EpuzzleState(board));
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

    @Override   
    public boolean sameState(SearchState s){
        EpuzzleState epState = (EpuzzleState) s;
	for(int i=0; i<epState.getPuzzBoard().length; i++) {
	    if(puzzBoard[i] != epState.getPuzzBoard()[i]) {
		return false;
	    }
	}
	return true;
    }
    public String toString() {
	String output = "8 puzzle state:\n";
	int count=0;
	for(int n:puzzBoard) {
		output+=n+" ";
		count++;
		if(count%3 == 0){
			output+="\n";
	}
	return output;
    }
}
