package core.ai;

public abstract class Action<Type extends State> {

    public abstract Type execute(Type state);

    public abstract boolean isApplicable(Type state);
    
}
