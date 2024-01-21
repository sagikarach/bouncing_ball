// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Levels;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.*;
import theGame.ElementsInTheGame.Decorations.Text;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;
import theGame.ElementsInTheGame.shape.Rectangle;
import java.awt.*;
import java.util.ArrayList;
/**
 * The DirectHit class responsible for one of the game's level.
 */
public class DirectHit implements LevelInformation {
    private ArrayList<Block> blocks = new java.util.ArrayList<Block>();

    private ArrayList<Point> ballsLocations = new java.util.ArrayList<Point>();
    private Background background = new Background(new java.util.ArrayList<Sprite>());
    /**
     * The DirectHit method is a builder, how create a new DirectHit level.
     */
    public DirectHit() {
        // Adding decorations to the level.
        this.background.addElement(new Rectangle(new Point(0, 0),
                800, 600, Color.black));
        for (int i = 0; i < 3; ++i) {
            this.background.addElement(new Circle(new Point(400, 100),
                    40 + 30 * i, Color.blue, false));
        }
        this.background.addElement(new Line(400, 70, 400, 0,
                Color.blue));
        this.background.addElement(new Line(400, 130, 400, 220,
                Color.blue));
        this.background.addElement(new Line(370, 100, 280, 100,
                Color.blue));
        this.background.addElement(new Line(430, 100, 520, 100,
                Color.blue));
        this.background.addElement(new Rectangle(new Point(0, 0), 800,
                30, Color.lightGray));
        this.background.addElement(new Text("Level Name: " + this.levelName(),
                new Point(550, 20), 15, Color.black));
        // Adding ball's location to the level.
        this.ballsLocations.add(new Point(400, 500));
        // Adding blocks to the level.
        this.blocks.add(new Block(new Rectangle(new Point(380, 80), 40,
                40), Color.red));
    }
    /**
     * The numberOfBalls method return the number of the ball in this level.
     * @return the number of the ball in this level.
     */
    public int numberOfBalls() {
        return this.ballsLocations.size();
    }
    /**
     * The initialBallVelocities method return a list of the ball's velocity
     * in this level.
     * @return a list of the ball's velocity in this level.
     */
    public ArrayList<Velocity> initialBallVelocities() {
        ArrayList<Velocity> ballVelocities = new java.util.ArrayList<Velocity>();
        ballVelocities.add(new Velocity(0, -10));
        return ballVelocities;
    }
    /**
     * The initialBallLocations method return a list of the ball's location
     * in this level.
     * @return a list of the ball's location in this level.
     */
    public ArrayList<Point> initialBallLocations() {
        return this.ballsLocations;
    }
    /**
     * The ballsColor method return the color of the balls in this level.
     * @return the color of the balls in this level.
     */
    public Color ballsColor() {
        return Color.WHITE;
    }
    /**
     * The paddleSpeed method return the speed of the paddle in this level.
     * @return the speed of the paddle in this level.
     */
    public int paddleSpeed() {
        return 30;
    }
    /**
     * The paddleWidth method return the width of the paddle in this level.
     * @return the width of the paddle in this level.
     */
    public int paddleWidth() {
        return 100;
    }
    /**
     * The paddleColor method return the color of the paddle in this level.
     * @return the color of the paddle in this level.
     */
    public Color paddleColor() {
        return Color.white;
    }
    /**
     * The levelName method return this level name.
     * @return this level name.
     */
    public String levelName() {
        return "Direct Hit";
    }
    /**
     * The getBackground return the background of this level, how contain
     * this level decorations.
     * @return the background of this level.
     */
    public Sprite getBackground() {
        return this.background;
    }
    /**
     * The blocks method return a list of this level's blocks.
     * @return a list of this level's blocks.
     */
    public ArrayList<Block> blocks() {
        return this.blocks;
    }
    /**
     * The numberOfBlocksToRemove method return the number of blocks,
     * that the player need to hit to win the level.
     * @return the number of blocks, that the player need to hit to win
     * the level.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
