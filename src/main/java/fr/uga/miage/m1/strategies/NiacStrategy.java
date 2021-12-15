package fr.uga.maige.m1.strategies;

import fr.uga.miage.m1.sharedstrategy.IStrategy;
import fr.uga.miage.m1.sharedstrategy.StrategyChoice;
import fr.uga.miage.m1.sharedstrategy.StrategyExecutionData;

public final class NiacStrategy implements IStrategy {
    boolean hasTheNiac = false;

    @Override
    public String getUniqueId() {
        return "NIAC";
    }

    @Override
    public String getFullName() {
        return "Niaque";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData data) {
        int diff = data.getOpposingPlayerScore() - data.getMainPlayerScore();
        hasTheNiac = (hasTheNiac || diff >= 10) && diff != 0;
        return hasTheNiac ? StrategyChoice.DEFECT : StrategyChoice.COOPERATE;
    }
}
