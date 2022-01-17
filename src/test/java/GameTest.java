import model.Game;
import model.GameRuleBreakException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    int run_game_get_score(int [] knocked) throws GameRuleBreakException {
        Game game = new Game("Test");
        for (int knock : knocked) {
            game.set_knocked_down(knock);
        }
        return game.get_score();
    }

    @Test
    void test_all_strike() throws GameRuleBreakException {
        int[] knocked = new int[]{10,10,10,10,10,10,10,10,10,10};
        assertEquals(270,run_game_get_score(knocked));
    }

    @Test
    void test_general() throws GameRuleBreakException{
        int[] knocked = new int[]{1,2,4,6,10,5,1,3,3,10,10,1,1,4,6,6,2};
        assertEquals(129,run_game_get_score(knocked));
    }

    @Test
    void test_last_frame_rule() throws GameRuleBreakException{
        // with a spare
        int[] knocked = new int[]{1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,5,5,2,3,5};
        assertEquals(54,run_game_get_score(knocked));
        // without a spare
        knocked = new int[]{1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,5,4,2,3};
        assertEquals(38,run_game_get_score(knocked));
    }

}
