package core.ai;

public abstract class Search {

    private Enviroment enviroment;

    public abstract State searchFinalState();

    public Search(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    public Enviroment getEnviroment() {
        return enviroment;
    }
}
