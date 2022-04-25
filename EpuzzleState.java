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

    
    public boolean goalPredicate(Search searcher){
        EpuzzleSearch epSearcher = (EpuzzleSearch) searcher;
		for(int i=0; i<epSearcher.getSize(); i++) {
			if(epSearcher.getGoal()[i]!=puzzBoard[i]) {
				return false;
			}
		}
		return true;
    }

    
    public ArrayList<SearchState> getSuccessors(Search searcher){

    }

   
    public boolean sameState(SearchState n2){
        EpuzzleState epState = (EpuzzleState) s;
		for(int i=0; i<epState.getPuzzBoard().length; i++) {
			if(puzzBoard[i] != epState.getPuzzBoard()[i]) {
				return false;
			}
		}
		return true;
    }
}
