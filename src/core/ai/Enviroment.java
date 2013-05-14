package core.ai;

import java.util.List;

public interface Enviroment {
    public List<Action> getApplicableActions(State state);
    public State getFinalState();
    public State getInitialState();
    public ActionList getActionList();
}
