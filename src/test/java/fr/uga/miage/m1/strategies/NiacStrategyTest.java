package fr.uga.miage.m1.strategies;

import fr.uga.maige.m1.strategies.NiacStrategy;
import fr.uga.miage.m1.sharedstrategy.StrategyChoice;
import fr.uga.miage.m1.sharedstrategy.StrategyExecutionData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Niac strategy test")
public class NiacStrategyTest {
    NiacStrategy niacStrat;
    StrategyExecutionData s;
    @BeforeEach
    public void before(){
        niacStrat = new NiacStrategy();
        s= new StrategyExecutionData();
    }


    @Test
    @DisplayName("DEFECT while have a niac")
    public void defectWhileHaveANiac(){
        s.setGameCurrentTurnCount(10);
        s.setMainPlayerScore(10);
        s.setOpposingPlayerScore(20);
        int nb_coup_jouer=0;
        while(s.getOpposingPlayerScore()-s.getMainPlayerScore()>0){
            Assertions.assertEquals(StrategyChoice.DEFECT,niacStrat.execute(s));
            s.setOpposingPlayerScore(s.getOpposingPlayerScore()+2);
            s.setMainPlayerScore(s.getMainPlayerScore()+3);
            nb_coup_jouer++;
        }
        Assertions.assertEquals(nb_coup_jouer,10);
    }

    @Test
    @DisplayName("Cooperate when not have a niac")
    public void cooperateWhenNotHaveANiac(){
        s.setMainPlayerScore(10);
        s.setOpposingPlayerScore(10);
        while(s.getOpposingPlayerScore()-s.getMainPlayerScore()<10){
            Assertions.assertEquals(StrategyChoice.COOPERATE,niacStrat.execute(s));
            s.setOpposingPlayerScore(s.getOpposingPlayerScore()+3);
            s.setMainPlayerScore(s.getMainPlayerScore()+2);
        }
        Assertions.assertEquals(StrategyChoice.DEFECT,niacStrat.execute(s));
    }
}
