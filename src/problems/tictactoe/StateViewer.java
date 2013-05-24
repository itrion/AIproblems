package problems.tictactoe;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StateViewer extends JFrame implements Observer {

    private TicTacToeState state;
    private JPanel mainPanel;

    public StateViewer(TicTacToeState state) {
        this.state = state;
        this.mainPanel = new JPanel();
        configureWindow(state);
        drawBoard(state);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    @Override
    public void update(Observable o, Object o1) {
        drawBoard((TicTacToeState) o1);
        pack();
    }

    private void configureWindow(TicTacToeState state) {
        mainPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < state.getBoard().length; i++)
            mainPanel.add(new CellViewer());
        add(mainPanel);

    }

    private void drawBoard(TicTacToeState state) {
        String[] board = state.getBoard();
        for (int i = 0; i < board.length; i++)
            ((CellViewer) mainPanel.getComponent(i)).setText(board[i]);
    }
}
