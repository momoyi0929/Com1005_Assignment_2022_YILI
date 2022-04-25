public class RunEpuzzleBFS {
    public static void main(String[] arg) {
        final int[] goal = {1,2,3,4,5,6,7,8,0};
	int[] example1 = {1,0,3,4,2,6,7,5,8};
	int[] example2 = {4,1,3,7,2,5,0,8,6};
	int[] example3 = {2,3,6,1,5,8,4,7,0};
	EpuzzleSearch searcher1 = new EpuzzleSearch(goal);
	SearchState initState = (SearchState) new EpuzzleState(example3);
	String resd = searcher1.runSearch(initState, "breaththFirst");
	System.out.println(resd);
    }
}
