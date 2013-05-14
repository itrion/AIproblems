package core.ai.search;

import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.List;
import java.util.Stack;

public class DepthFirst extends Search {

    private Stack<State> openList;
    public DepthFirst(Enviroment enviroment) {
        super(enviroment);
        this.openList = new Stack<>();
    }

    @Override
    protected void updateCurrentState() {
        setCurrentState(openList.pop());
    }

    @Override
    protected void updateOpenList(List<State> childs) {
        for (State state : childs)
            openList.push(state);
    }
}
