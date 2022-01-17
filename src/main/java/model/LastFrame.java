package model;

public class LastFrame extends Frame{

    public LastFrame(Player player){
        super();
        if (player.has_done_spare_or_strike()) {
            this.MAX_ATTEMPTS = 3;
        }
    }
}
