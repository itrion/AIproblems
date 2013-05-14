package core.ai;
public interface HeuristicFunction<Type extends State> {
    public double evaluate(Type state);
}
