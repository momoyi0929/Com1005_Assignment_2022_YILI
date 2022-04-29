import java.util.ArrayList;

public class EpuzzleState extends SearchState{

	@Override
	boolean goalPredicate(Search searcher) {
		
		return false;
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		
		return null;
	}

	@Override
	boolean sameState(SearchState n2) {
		
		return false;
	}
	
}