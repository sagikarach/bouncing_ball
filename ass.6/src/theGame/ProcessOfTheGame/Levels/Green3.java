// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Levels;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.Decorations.*;
import theGame.ElementsInTheGame.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;
import theGame.ElementsInTheGame.shape.Rectangle;
import theGame.interfaces.*;

import java.awt.*;
import java.util.*;

/**
 * The BringTheWallDown class responsible for one of the game's level.
 */
public class Green3 implements LevelInformation {
    private ArrayList<Point> ballsLocations = new java.util.ArrayList<Point>();
    private Background background = new Background(new java.util.ArrayList<Sprite>());
    private ArrayList<Block> blocks = new java.util.ArrayList<Block>();
    /**
     * The BringTheWallDown method is a builder, how create a new
     * BringTheWallDown level.
     */
    public Green3() {
        this.createBackground();
        this.createBlocks();
        this.createBalls();
    }
    /**
     * The createBackground create this level background.
     */
    private void createBackground() {
        this.background.addElement(new Rectangle(new Point(0, 0),
                800, 600, Color.green));
        this.background.addElement(new Circle(new Point(180, 260), 150,
                Color.yellow, true));
        this.background.addElement(new Triangle(new Point(200, 260),
                new Point(330, 360), new Point(330, 200), Color.green));
        this.background.addElement(new Circle(new Point(210, 190), 20,
                Color.black, true));
        this.background.addElement(new Rectangle(new Point(0, 0), 800,
                30, Color.lightGray));
        this.background.addElement(new Text("Level Name: " + this.levelName(),
                new Point(550, 20), 15, Color.black));
    }
    /**
     * The createBackground create this level blocks.
     */
    private void createBlocks() {
        int width = 45, height = 25, yPlace = 200, xPlace = 800 - width - 1;
        for (int i = 0; i < 5; ++i) {
            Color rowColor = pickAColor(i);
            for (int j = 0; j < 10 - i; ++j) {
                this.blocks.add(new Block(new Rectangle(new Point(xPlace - j,
                        yPlace + i), width, height), rowColor));
                xPlace -= width;
            }
            xPlace = 800 - width - 1;
            yPlace += height;
        }
    }
    /**
     * The pickAColor method find which color will the block hove, according
     * to the block row.
     * @param rowNumber the block's row number.
     * @return the block's color according to his row.
     */
    private Color pickAColor(int rowNumber) {
        switch (rowNumber) {
            case 0:
                return Color.gray;
            case 1:
                return Color.red;
            case 2:
                return Color.yellow;
            case 3:
                return Color.blue;
            case 4:
                return Color.white;
            default:
                return Color.black;
        }
    }
    /**
     * The createBackground create this level balls.
     */
    private void createBalls() {
        this.ballsLocations.add(new Point(400, 500));
        this.ballsLocations.add(new Point(400, 500));
    }
    /**
     * The numberOfBalls method return the number of the ball in this level.
     * @return the number of the ball in this level.
     */
    public int numberOfBalls() {
        return ballsLocations.size();
    }
    /**
     * The initialBallVelocities method return a list of the ball's velocity
     * in this level.
     * @return a list of the ball's velocity in this level.
     */
    public ArrayList<Velocity> initialBallVelocities() {
        ArrayList<Velocity> ballVelocities = new java.util.ArrayList<Velocity>();
        ballVelocities.add(new Velocity(5, -5));
        ballVelocities.add(new Velocity(-5, -5));
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
        return Color.white;
    }
    /**
     * The paddleSpeed method return the speed of the paddle in this level.
     * @return the speed of the paddle in this level.
     */
    public int paddleSpeed() {
        return 20;
    }
    /**
     * The paddleWidth method return the width of the paddle in this level.
     * @return the width of the paddle in this level.
     */
    public int paddleWidth() {
        return 400;
    }
    /**
     * The paddleColor method return the color of the paddle in this level.
     * @return the color of the paddle in this level.
     */
    public Color paddleColor() {
        return Color.orange;
    }
    /**
     * The levelName method return this level name.
     * @return this level name.
     */
    public String levelName() {
        return "Green 3";
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
