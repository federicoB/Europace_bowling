import model.Game;
import model.GameRuleBreakException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        Game game = new Game(in.nextLine());
        while (!game.is_finished()) {
            String frame_index = String.valueOf(game.get_frame_index());
            System.out.println("Frame "+frame_index+": How many pin have you knocked down?");
            try {
                game.set_knocked_down(in.nextInt());
            } catch (GameRuleBreakException e) {
                System.out.println("Breaking rules!!!");
            }
        }
        int score = game.get_score();
        System.out.println("THe score is "+String.valueOf(score));
    }
}
