package model;

public class Player {

    private int frame_index;

    private Frame[] frames;

    private String name;

    public Player(String name) {
        this.name = name;
        frames = new Frame[Game.DEFAULT_MAX_FRAME];
        this.frame_index = 0;
    }

    public int getFrame_index() {
        return frame_index;
    }

    public Game.State set_knocked_down(int knocked_down) throws GameRuleBreakException {
        if (this.frame_index < Game.DEFAULT_MAX_FRAME) {
            if (this.frames[frame_index] == null) {
                this.frames[frame_index]  =  ((this.frame_index != Game.DEFAULT_MAX_FRAME-1) ? new Frame() : new LastFrame(this));
            }
            Frame frame = this.frames[frame_index];
            frame.set_attempt(knocked_down);
            if (frame.getRemaining_standing()==0 || frame.has_finished_attempts()) {
                this.frame_index += 1;
            }
            return Game.State.RUNNING;
        } else {
            return Game.State.FINISHED;
        }
    }

    public Boolean has_done_spare_or_strike() {
        for (int i=0; i<frame_index; i++) {
            Frame frame = frames[i];
            if (frame.getRemaining_standing()==0 && frame.getAttempts()<=2) {
                return true;
            }
        }
        return false;
    }

    public int get_score() {
        int score = 0;
        for (int i=0; i< frames.length; i++) {
            Frame frame = frames[i];
            score += frame.get_score_without_bonus();
            if (frame.getRemaining_standing()==0) {
                // spare
                if (i<frames.length-1) {
                    score += frames[i+1].get_score_without_bonus();
                }
                if (frame.getAttempts()==1) {
                    if (i<frames.length-2) {
                        score += frames[i + 2].get_score_without_bonus();
                    }
                }
            }
        }
        return score;
    }
}
