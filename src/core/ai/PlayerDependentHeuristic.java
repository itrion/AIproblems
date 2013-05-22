package core.ai;
public interface PlayerDependentHeuristic<Type extends State>{
    public double evaluate(Type state, boolean playerA);
}
