package fr.uga.maige.m1.strategies;

import fr.uga.miage.m1.sharedstrategy.IStrategy;
import fr.uga.miage.m1.sharedstrategy.StrategyChoice;
import fr.uga.miage.m1.sharedstrategy.StrategyExecutionData;

final public class PendulumStrategy implements IStrategy {
    boolean pendulum = false;

    @Override
    public String getUniqueId() {
        return "PENDULUM";
    }

    @Override
    public String getFullName() {
        return "Balancier";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData data) {
        pendulum = !pendulum;
        return pendulum ? StrategyChoice.COOPERATE : StrategyChoice.DEFECT;
    }
}
