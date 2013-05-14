package problems.eightpuzzle;

import core.ai.Enviroment;
import core.ai.HeuristicFunction;

public class EigthPuzzleGoodplacedFunction implements HeuristicFunction<EightPuzzleState> {

    private Enviroment<EightPuzzleState> enviroment;

    public EigthPuzzleGoodplacedFunction(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double evaluate(EightPuzzleState state) {
        EightPuzzleState finalState = enviroment.getFinalState();
        int[] finalBoard = finalState.getBoard();
        int goodplacedCounter = 0;
        for (int i = 0; i < state.getBoard().length; i++)
            if (finalBoard[i] == state.getBoard()[i]) goodplacedCounter++;
        return goodplacedCounter;
    }
}
