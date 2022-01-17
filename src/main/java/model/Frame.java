package model;

public class Frame {

    public int MAX_ATTEMPTS = 2;
    private int remaining_standing;
    private int attempts;

    public Frame() {
        this.remaining_standing = Game.NUMBER_OF_PINS;
        this.attempts = 0;
    }

    public int getRemaining_standing() {
        return remaining_standing;
    }

    public int getAttempts(){
        return this.attempts;
    }

    public Boolean has_finished_attempts() {
        return (attempts>=MAX_ATTEMPTS);
    }

    public int get_score_without_bonus() {
        return Game.NUMBER_OF_PINS-this.remaining_standing;
    }

    public void set_attempt(int knockedDown) throws GameRuleBreakException {
        if (knockedDown<0) throw new GameRuleBreakException();
        if (remaining_standing-knockedDown>=0) {
            remaining_standing -= knockedDown;
        } else{
            // revert
            remaining_standing += knockedDown;
            throw new GameRuleBreakException();
        }
        this.attempts += 1;
    }
}
