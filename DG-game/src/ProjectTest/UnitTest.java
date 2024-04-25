package ProjectTest;
import Project.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class UnitTest {


    Player player;
    Enemy monster;
    Trap trap;

    @Before
    public void set_up(){


        monster = new Monster('s', "Lannister Soldier", 80, 8, 3, 25, 3);
        player =  new Warrior('@',"John Snow",300,300,30,4,0,1,3);
        trap = new Trap('B',"Bonus Trap",1,1,1,250,1,5);



    }
    @Test
    public void playerInteractwithMonster(){
        player.interact(monster);
        //if print is succsses

    }

    @Test
    public void playerInteractwithTrap(){
        player.interact(trap);
        //if print is succsses

    }
    @Test
    public void monsterInteractwithMonster(){
        Monster monster1 = new Monster('s', "Lannister Soldier", 80, 8, 3, 25, 3);
        monster1.interact(monster);
        //if print nothing is succsses

    }



    @Test
    public void isVisiabilityTest(){
        trap.IncrementTick();
        assertEquals(trap.isVisibile(),false);
    }

}
