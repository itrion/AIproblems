package problems.tictactoe;

import core.ai.Heuristic;

public class TicTacToeHeuristic implements Heuristic<TicTacToeState> {
    private TicTacToeState state;
    
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
        return counter;
    }

    public double countFirstRow(String symbol) {
        for (int i = 0; i < 3; i++)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double countSecondRow(String symbol) {
        for (int i = 3; i < 6; i++)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double countThirdRow(String symbol) {
        for (int i = 6; i < 9; i++)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double countFirstColumn(String symbol) {
        for (int i = 0; i < 7; i += 3)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double countSecondColum(String symbol) {
        for (int i = 1; i < 8; i += 3)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double countThirdColumn(String symbol) {
        for (int i = 2; i < 9; i += 3)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double firstDiagonal(String symbol) {
        for (int i = 0; i < 9; i += 4)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    public double secondDiagonal(String symbol) {
        for (int i = 2; i < 9; i += 2)
            if (boardAtcontainsOpositeAgentSymbol(i, symbol))
                return 0;
        return 1;
    }

    private boolean boardAtcontainsOpositeAgentSymbol(int i, String symbol) {
        return state.getBoard()[i].equals(getOtherAgentSymbol(symbol));
    }

    private String getOtherAgentSymbol(String symbol) {
        return (symbol.equals("X")) ? "O" : "X";
    }
}
