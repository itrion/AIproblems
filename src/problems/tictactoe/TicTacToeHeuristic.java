package problems.tictactoe;

import core.ai.Heuristic;

public class TicTacToeHeuristic implements Heuristic<TicTacToeState> {

    private TicTacToeState state;
    private int myLines;
    private int enemyLines;

    @Override
    public double evaluate(TicTacToeState state) {
        this.state = state;
        return calcultePosibleTreeLines(getOtherAgentSymbol(state.getTurnSymbol()));
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
        return myLines - enemyLines;
    }

    public double countFirstRow(String symbol) {
        return countWith(0, 3, 1, symbol);
    }

    public double countSecondRow(String symbol) {
        return countWith(3, 6, 1, symbol);
    }

    public double countThirdRow(String symbol) {
        return countWith(6, 9, 1, symbol);
    }

    public double countFirstColumn(String symbol) {
        return countWith(0, 7, 3, symbol);
    }

    public double countSecondColum(String symbol) {
        return countWith(1, 8, 3, symbol);
    }

    public double countThirdColumn(String symbol) {
        return countWith(2, 9, 3, symbol);
    }

    public double firstDiagonal(String symbol) {
        return countWith(0, 9, 4, symbol);
    }

    public double secondDiagonal(String symbol) {
        return countWith(2, 7, 2, symbol);
    }

    private boolean boardAtcontainsOpositeAgentSymbol(int i, String symbol) {
        return state.getBoard()[i].equals(getOtherAgentSymbol(symbol));
    }

    private String getOtherAgentSymbol(String symbol) {
        return (symbol.equals(TicTacToeState.X_SYMBOL)) ? TicTacToeState.O_SYMBOL : TicTacToeState.X_SYMBOL;
    }

    private double countWith(int min, int max, int increment, String symbol) {
        int otherCounter = 0;
        int myCounter = 0;
        for (int i = min; i < max; i += increment)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                otherCounter++;
            else if (boardAtIsFree(i)) {
                otherCounter++;
                myCounter++;
            } else
                myCounter++;
        if (otherCounter == 3)
            enemyLines++;
        if (myCounter == 3)
            myLines++;
        return (otherCounter == 0) ? 1 : 0;

    }

    private boolean boardAtIsFree(int i) {
        return (state.getBoard()[i].equals(TicTacToeState.EMPTY_SYMBOL));
    }
}
