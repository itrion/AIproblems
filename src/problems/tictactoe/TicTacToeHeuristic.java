package problems.tictactoe;

import core.ai.Heuristic;

public class TicTacToeHeuristic implements Heuristic<TicTacToeState> {
    private TicTacToeState state;
    
    @Override
    public double evaluate(TicTacToeState state) {
        this.state = state;
        return calcultePosibleTreeLines(state.getTurnSymbol());
    }

    private double calcultePosibleTreeLines(String symbol) {
        double counter = 0;
        counter += countFirstRow(symbol);
        counter += countSecondRow(symbol);
        counter += countThirdRow(symbol);
        counter += countFirstColumn(symbol);
        counter += countSecondColum(symbol);
        counter += countThirdColumn(symbol);
        counter += firstDiagonal(symbol);
        counter += secondDiagonal(symbol);
        return counter;
    }

    public double countFirstRow(String currentAgentSymbol) {
        for (int i = 0; i < 3; i++)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double countSecondRow(String currentAgentSymbol) {
        for (int i = 3; i < 6; i++)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double countThirdRow(String currentAgentSymbol) {
        for (int i = 6; i < 9; i++)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double countFirstColumn(String currentAgentSymbol) {
        for (int i = 0; i < 7; i += 3)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double countSecondColum(String currentAgentSymbol) {
        for (int i = 1; i < 8; i += 3)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double countThirdColumn(String currentAgentSymbol) {
        for (int i = 2; i < 9; i += 3)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double firstDiagonal(String currentAgentSymbol) {
        for (int i = 0; i < 9; i += 4)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    public double secondDiagonal(String currentAgentSymbol) {
        for (int i = 2; i < 9; i += 2)
            if (stateAtcontainsOtherAgentSymbol(i, currentAgentSymbol))
                return 0;
        return 1;
    }

    private boolean stateAtcontainsOtherAgentSymbol(int i, String currentAgentSymbol) {
        return state.getBoard()[i].equals(getOtherAgentSymbol(currentAgentSymbol));
    }

    private String getOtherAgentSymbol(String currentAgentSymbol) {
        return (currentAgentSymbol.equals("X")) ? "O" : "X";
    }
}
