package core.ai;

public abstract class InformedState extends State {

    private double evaluationValue;
    private boolean isEvaluated;

    public InformedState(State parent) {
        super(parent);
        this.isEvaluated = false;
    }

    public double getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(double evaluationValue) {
        this.evaluationValue = evaluationValue;
        this.isEvaluated = true;
    }

    public boolean isEvaluated() {
        return isEvaluated;
    }
}
