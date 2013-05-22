package core.ai;
public interface TwoAgentsEnviroment extends Enviroment{
    public Agent getAgentA();
    public Agent getAgentB();
    public boolean isAgentATurn();
    public boolean isAgentBTurn();
}
