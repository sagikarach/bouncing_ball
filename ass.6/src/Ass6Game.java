//Sagi Karach 206863888.
import biuoop.*;
import theGame.ProcessOfTheGame.*;
import theGame.ProcessOfTheGame.Levels.*;
import theGame.interfaces.*;
import java.util.ArrayList;
/**
 * the Ass6Game class create a new game, add the game's levels, and run him.
 */
public class Ass6Game {
    private static final int WIDTH_OF_THE_BOARD = 800, HEIGHT_OF_THE_BOARD = 600;
    /**
     * the main function create a new game, add the game's levels, and run him.
     * @param args an array of strings that contain the user's desire order to play.
     *             the levels of the game.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", WIDTH_OF_THE_BOARD, HEIGHT_OF_THE_BOARD);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui,
                30), keyboardSensor, gui);
        ArrayList<LevelInformation> levels = new ArrayList<>();
        // In case the user didn't enter desire order of the game's levels.
        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "1":
                    levels.add(new WideEasy());
                    break;
                case "2":
                    levels.add(new DirectHit());
                    break;
                case "3":
                    levels.add(new Green3());
                    break;
                // In case the user enter a level that don't exist in the game.
                default:
            }
        }
        if (levels.size() == 0) {
            levels.add(new WideEasy());
            levels.add(new DirectHit());
            levels.add(new Green3());
        }
        gameFlow.runLevels(levels);
    }
}
