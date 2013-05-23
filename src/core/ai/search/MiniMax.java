package core.ai.search;

import core.ai.Action;
import core.ai.Heuristic;
import core.ai.InformedState;
import core.ai.PlayersEnviroment;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    private Heuristic heuristic;
    private PlayersEnviroment enviroment;
    private State newState;

    public MiniMax(Heuristic heuristic, PlayersEnviroment enviroment) {
        this.heuristic = heuristic;
        this.enviroment = enviroment;
    }

    public State getNewState() {
        return newState;
    }

    public InformedState searchNextState(InformedState state, int maxDepth) {
        double alpha = -Double.MAX_VALUE;
        double beta = Double.MAX_VALUE;
        double bestEvaluation = -Double.MAX_VALUE;
        InformedState bestMove = null;
        for (InformedState child : getChilds(state)) {
            if (bestMove == null)
                bestMove = child;
            alpha = Math.max(alpha, minimax(child, maxDepth, alpha, beta));
            if (alpha > bestEvaluation) {
                bestMove = child;
                bestEvaluation = alpha;
            }

        }
        return bestMove;
    }

    private double minimax(InformedState state, int maxDepth, double alpha, double beta) {
        if (maxDepth <= 0 || isTerminalState(state))
            return heuristic.evaluate(state);
        if (isMyTurn(state)) {
            for (InformedState child : getChilds(state)) {
                alpha = Math.max(alpha, minimax(child, maxDepth - 1, alpha, beta));
                if (alpha >= beta)
                    return beta;
            }
            return alpha;
        } else {
            for (InformedState child : getChilds(state)) {
                beta = Math.min(beta, minimax(child, maxDepth - 1, alpha, beta));
                if (alpha >= beta)
                    return alpha;
            }
            return beta;
        }
    }

    private List<InformedState> getChilds(InformedState state) {
        List<Action> applicableActions = enviroment.getApplicableActions(state);
        List<InformedState> childs = new ArrayList<>();
        for (Action action : applicableActions)
            childs.add((InformedState) action.execute(state));
        return childs;
    }

    private boolean isTerminalState(InformedState state) {
        return enviroment.isFinalState(state);
    }

    private boolean isMyTurn(InformedState state) {
        return enviroment.isIsTurnOf(state);
    }
}
