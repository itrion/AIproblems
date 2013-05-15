package core.ai;

import java.util.Comparator;
import java.util.List;

public interface Heuristic<Type extends State> extends Comparator<Type> {

    public double evaluate(Type state);

    public List<Type> sort(List<Type> openList);
}
