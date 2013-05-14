package core.ai;

public abstract class State implements Comparable<State> {

    private State parent;

    public State(State parent) {
        this.parent = parent;
    }

    public State getParent() {
        return parent;
    }

    public abstract boolean equals(State otherState);
}
