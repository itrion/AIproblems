package core.ai.search;

import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.List;

public class Astar extends Search{

    public Astar(Enviroment enviroment) {
        super(enviroment);
    }

    @Override
    protected void updateCurrentState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void updateOpenList(List<State> childs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected double getOpenListSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected double getMaxOpenListSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
