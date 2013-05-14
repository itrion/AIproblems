package core.ai.search;

import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BreadthFirst extends Search {

    private Queue<State> openList;
    
    public BreadthFirst(Enviroment enviroment) {
        super(enviroment);
        this.openList = new ArrayDeque<>();
    }

    @Override
    protected void updateCurrentState() {
        this.setCurrentState(openList.poll());
    }

    
    @Override
    protected void updateOpenList(List<State> childs) {
        openList.addAll(childs);
    }
}
