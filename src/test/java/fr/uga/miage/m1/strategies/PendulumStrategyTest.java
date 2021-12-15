package fr.uga.miage.m1.strategies;

import fr.uga.maige.m1.strategies.PendulumStrategy;
import fr.uga.miage.m1.sharedstrategy.StrategyChoice;
import fr.uga.miage.m1.sharedstrategy.StrategyExecutionData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pendulum strategy test")
public class PendulumStrategyTest {

    @Test
    @DisplayName("have pendulum behavior")
    public void havePendulumBehavior(){
        PendulumStrategy pendulum = new PendulumStrategy();
        for(int i=0;i<100;i++){
            if (i % 2 == 0) {
                Assertions.assertEquals(StrategyChoice.COOPERATE, pendulum.execute(new StrategyExecutionData()));
            } else {
                Assertions.assertEquals(StrategyChoice.DEFECT, pendulum.execute(new StrategyExecutionData()));
            }
        }
    }
}
