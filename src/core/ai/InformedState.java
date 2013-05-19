package core.ai;

public abstract class InformedState extends State {

    private double heuristicValue;
    private double costValue;
    private boolean evaluated;
    private boolean costCalculated;

    public InformedState(State parent) {
        super(parent);
        this.evaluated = false;
        this.costCalculated = false;
        this.costValue = 0;
    }

    public double getHeuristicAndCostValue() {
        return heuristicValue + costValue;
    }

    public void setHeuristicValue(double evaluationValue) {
        this.heuristicValue = evaluationValue;
        this.evaluated = true;
    }

    public void setCostValue(double costValue) {
        this.costValue = costValue;
        this.costCalculated = true;
    }

    public double getHeuristicValue() {
        return heuristicValue;
    }

    public double getCostValue() {
        return costValue;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public boolean isCostCalculated() {
        return costCalculated;
    }
}
