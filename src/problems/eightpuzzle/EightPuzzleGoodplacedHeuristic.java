package problems.eightpuzzle;

import core.ai.Enviroment;
import core.ai.Heuristic;
import java.util.Collections;
import java.util.List;

public class EightPuzzleGoodplacedHeuristic implements Heuristic<EightPuzzleState> {

    private Enviroment<EightPuzzleState> enviroment;

    public EightPuzzleGoodplacedHeuristic(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double evaluate(EightPuzzleState state) {
        EightPuzzleState finalState = enviroment.getFinalState();
        int[] finalBoard = finalState.getBoard();
        int goodplacedCounter = 0;
        for (int i = 0; i < state.getBoard().length; i++)
            if (finalBoard[i] == state.getBoard()[i]) goodplacedCounter++;
        state.setEvaluationValue(goodplacedCounter);
        return goodplacedCounter;
    }

    @Override
    public int compare(EightPuzzleState stateA, EightPuzzleState stateB) {
        double evaluationValueA = stateA.getEvaluationValue();
        double evaluationValueB = stateB.getEvaluationValue();
        return (evaluationValueA >= evaluationValueB) ? 1 : -1;
    }

    @Override
    public List<EightPuzzleState> sort(List<EightPuzzleState> openList) {
        Collections.sort(openList, this);
        return openList;

    }
}
