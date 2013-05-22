package core.ai;

public abstract class MiniMaxState extends InformedState {

    private boolean maxState;

    public MiniMaxState(boolean maxState, State parent) {
        super(parent);
        this.maxState = maxState;
    }

    public boolean isMaxState() {
        return maxState;
    }

    public void setMaxState(boolean maxState) {
        this.maxState = maxState;
    }
}
