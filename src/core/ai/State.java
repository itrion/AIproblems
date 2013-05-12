package core.ai;

public interface State {

    public State getParent();

    public boolean equals(State otherState);
}
