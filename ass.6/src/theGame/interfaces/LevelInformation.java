// Sagi Karach 206863888.
package theGame.interfaces;
import theGame.ElementsInTheGame.*;
import java.awt.*;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.ElementsInTheGame.shape.Point;
/**
 * The LevelInformation interface represents all the level's
 * information objects.
 */
public interface LevelInformation {
    /**
     * The numberOfBalls method return the number of the ball
     * in the current level.
     * @return the number of the ball in the current level.
     */
    int numberOfBalls();
    /**
     * The initialBallVelocities method return a list of the ball's
     * velocity in the current level.
     * @return a list of the ball's velocity in this level.
     */
    java.util.ArrayList<Velocity> initialBallVelocities();
    /**
     * The initialBallLocations method return a list of the ball's
     * location in the current level.
     * @return a list of the ball's location in the current level.
     */
    java.util.ArrayList<Point> initialBallLocations();
    /**
     * The ballsColor method return the color of the balls in the
     * current level.
     * @return the color of the balls in the current level.
     */
    Color ballsColor();
    /**
     * The paddleSpeed method return the speed of the paddle in the
     * current level.
     * @return the speed of the paddle in the current level.
     */
    int paddleSpeed();
    /**
     * The paddleWidth method return the width of the paddle in the
     * current level.
     * @return the width of the paddle in the current level.
     */
    int paddleWidth();
    /**
     * The paddleColor method return the color of the paddle in the
     * current level.
     * @return the color of the paddle in the current level.
     */
    Color paddleColor();
    /**
     * The levelName method return the current level name.
     * @return the current level name.
     */
    String levelName();
    /**
     * The getBackground return the background of this current level,
     * how contain the current level decorations.
     * @return the background of the current level.
     */
    Sprite getBackground();
    /**
     * The blocks method return a list of the current level's blocks.
     * @return a list of the current level's blocks.
     */
    java.util.ArrayList<Block> blocks();
    /**
     * The numberOfBlocksToRemove method return the number of blocks,
     * that the player need to hit to win the current level.
     * @return the number of blocks, that the player need to hit to win
     * the current level.
     */
    int numberOfBlocksToRemove();
}
