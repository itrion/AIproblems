package core.problems.jars;

import core.ai.Action;
import core.problems.jars.operators.EmptyFourLitersJar;
import core.problems.jars.operators.EmptyThreeLitersJar;
import core.problems.jars.operators.FillFourLitterJar;
import core.problems.jars.operators.FillThreeLitterJar;
import core.problems.jars.operators.TransferFromFourLitersJarToThreeLitersJar;
import core.problems.jars.operators.TransferFromThreeLitersJarToFourLitersJar;
import java.util.ArrayList;

public class OperatorList {
    private final ArrayList<Action> operators;

    public OperatorList() {
        this.operators = new ArrayList<>();
        operators.add(new EmptyFourLitersJar());
        operators.add(new EmptyThreeLitersJar());
        operators.add(new FillFourLitterJar());
        operators.add(new FillThreeLitterJar());
        operators.add(new TransferFromFourLitersJarToThreeLitersJar());
        operators.add(new TransferFromThreeLitersJarToFourLitersJar());
    }

    public ArrayList<Action> getOperators() {
        return operators;
    }
}
