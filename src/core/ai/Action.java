package core.ai;

public abstract class Action {

    public abstract State execute(State state);

    public abstract boolean isApplicable(State state);
    
}
