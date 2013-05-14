package core.ai;

import java.util.List;

public interface Enviroment<Type extends State> {
    public List<Action> getApplicableActions(State state);
    public Type getFinalState();
    public Type getInitialState();
    public ActionList getActionList();
}
