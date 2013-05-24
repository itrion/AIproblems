package problems.eightpuzzle;

import core.ai.Enviroment;
import core.ai.Heuristic;

public class EightPuzzleMissplacedHeuristic implements Heuristic<EightPuzzleState> {

    private Enviroment<EightPuzzleState> enviroment;

    public EightPuzzleMissplacedHeuristic(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double evaluate(EightPuzzleState state) {
        int[] finalBoard = enviroment.getFinalState().getBoard();
        int missplacedCounter = 0;
        for (int i = 0; i < state.getBoard().length; i++)
            if (finalBoard[i] != state.getBoard()[i]) missplacedCounter++;
        return missplacedCounter;
    }
}
