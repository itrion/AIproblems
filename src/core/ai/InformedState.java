package core.ai;

public abstract class InformedState extends State {

    private double evaluationValue;

    public InformedState(State parent) {
        super(parent);
    }

    public double getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(double evaluationValue) {
        this.evaluationValue = evaluationValue;
    }

    @Override
    public int compareTo(State o) {
        InformedState otherState = (InformedState) o;
        return (int) (this.getEvaluationValue() - otherState.getEvaluationValue());
    }
}
