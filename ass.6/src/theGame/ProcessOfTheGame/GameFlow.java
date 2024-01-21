// Sagi Karach 206863888.
package theGame.ProcessOfTheGame;
import biuoop.*;
import theGame.ElementsInTheGame.DataKeepers.Counter;
import theGame.ProcessOfTheGame.Animation.YouWin;
import theGame.interfaces.*;
import theGame.listeners.ScoreTrackingListener;
/**
 * The GameFlow class is responsible for running the game's level.
 */
public class GameFlow {
    private Counter countScore = new Counter(0);
    private ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(countScore);
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    /**
     * The GameFlow method is builder, create a GameFlow objects.
     * @param animationRunner is an animation runner of the game.
     * @param keyboardSensor is a keyboard sensor.
     * @param gui is the graphic of the game.
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor keyboardSensor, GUI gui) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.gui = gui;
    }
    /**
     * The runLevels method responsible for running the levels of the game.
     * @param levels a list of the game's levels.
     */
    public void runLevels(java.util.List<LevelInformation> levels) {
        boolean lost = false;
        for (LevelInformation levelInfo : levels) {
            // Check if the player didn't lose the game.
            if (!lost) {
                GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                        this.animationRunner, this.gui, this.scoreTrackingListener);
                level.initialize();
                while (level.shouldStop()) {
                    level.run();
                    if (level.shouldStop()) {
                        lost = level.checkIfLost();
                        break;
                    }
                }
            }
        }
        // Check if the player didn't lose the game.
        if (!lost) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                    "SPACE_KEY", new YouWin(this.countScore)));
        }
        gui.close();
    }
}
