package model;

public class Game {

    enum State {
        RUNNING,
        FINISHED
    }

    public static int DEFAULT_MAX_FRAME = 10;
    public static int NUMBER_OF_PINS = 10;


    public State state;

    private Player player;


    public Game(String playerName) {
        this.player = new Player(playerName);

    }

    public int get_frame_index() {
        return player.getFrame_index();
    }

    public Boolean is_finished () {
        return (this.state == State.FINISHED);
    }

    public void set_knocked_down(int knocked) throws GameRuleBreakException {
        if (state!= State.FINISHED) {
            State newGameState = player.set_knocked_down(knocked);
            this.state = newGameState;
        } else {
            throw new GameRuleBreakException();
        }
    }

    public int get_score() {
        return player.get_score();
    }



}
