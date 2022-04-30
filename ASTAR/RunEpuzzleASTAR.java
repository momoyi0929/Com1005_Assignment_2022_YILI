public class RunEpuzzleASTAR {
	// generator given seed
	int seed = 23456;
	EpuzzGen gen = new EpuzzGen(seed);
	
	// generate puzzle providing difficulty
	int d = 6;
	int[][] puzz = gen.puzzGen(d);
	
}
