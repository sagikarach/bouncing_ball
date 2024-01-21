// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Levels;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.*;
import theGame.ElementsInTheGame.Decorations.House;
import theGame.ElementsInTheGame.Decorations.Text;
import theGame.ElementsInTheGame.Decorations.Tree;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Point;
import theGame.ElementsInTheGame.shape.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * The SunLight class responsible for one of the game's level.
 */
public class WideEasy implements LevelInformation {
    private ArrayList<Point> ballsLocations = new java.util.ArrayList<Point>();
    private ArrayList<Block> blocks = new java.util.ArrayList<Block>();
    private ArrayList<Velocity> ballVelocities = new java.util.ArrayList<Velocity>();
    private Background background = new Background(new java.util.ArrayList<Sprite>());
    /**
     * The SunLight method is a builder, how create a new SunLight level.
     */
    public WideEasy() {
        this.createBackground();
        this.createBlocks();
        this.createBalls();
    }
    /**
     * The createBackground create this level background.
     */
    private void createBackground() {
        Random location = new Random();
        this.background.addElement(new Rectangle(new Point(0, 0),
                800, 600, Color.green));
        this.background.addElement(new Rectangle(new Point(380, 0),
                40, 550, Color.yellow));
        for (int i = 0; i < 40; ++i) {
            this.background.addElement(new Tree(new Rectangle(new Point(
                    location.nextDouble(0, 330), location.nextDouble(
                    0, 250)), 5, 20)));
            this.background.addElement(new Tree(new Rectangle(new Point(
                    location.nextDouble(440, 800),
                    location.nextDouble(0, 250)), 5, 20)));
            this.background.addElement(new House(new Rectangle(new Point(
                    location.nextDouble(0, 330),
                    location.nextDouble(0, 250)), 40, 40)));
            this.background.addElement(new House(new Rectangle(new Point(
                    location.nextDouble(440, 800),
                    location.nextDouble(0, 250)), 40, 40)));
        }
        this.background.addElement(new Rectangle(new Point(0, 0),
                800, 30, Color.lightGray));
        this.background.addElement(new Text("Level Name: " + this.levelName(),
                new Point(550, 20), 15, Color.black));
    }
    /**
     * The createBackground create this level blocks.
     */
    private void createBlocks() {
        Color color;
        for (int i = 0; i < 7; ++i) {
            color = this.pickAColor(i);
            this.blocks.add(new Block(new Rectangle(new Point(0 + (i * 114.2), 300),
                    57.1, 30), color));
            this.blocks.add(new Block(new Rectangle(new Point(57.1 + (i * 114.2), 300),
                    57.1, 30), color));
        }
    }
    /**
     * The pickAColor method find which color will the block hove, according
     * to the block locations in the row.
     * @param i the block locations in the row.
     * @return the block's color according to his location in the row.
     */
    private Color pickAColor(int i) {
        switch (i) {
            case 0:
                return Color.red;
            case 1:
                return Color.orange;
            case 2:
                return Color.yellow;
            case 3:
                return Color.green;
            case 4:
                return Color.blue;
            case 5:
                return Color.pink;
            case 6:
                return new Color(0, 200, 250);
            default:
                return Color.black;
        }
    }
    /**
     * The createBackground create this level balls.
     */
    private void createBalls() {
        for (int i = 1; i < 6; ++i) {
            double dx = 7 - (i + Math.cos(Math.toRadians(20 / i))),
                    dy = (i + Math.cos(Math.toRadians(i * 20)));
            this.ballsLocations.add(new Point(400, 550));
            this.ballVelocities.add(new Velocity(dx * (-1), dy * (-1)));
            this.ballsLocations.add(new Point(400, 550));
            this.ballVelocities.add(new Velocity(dx, dy * (-1)));
        }
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
        return this.ballVelocities;
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
        return 30;
    }
    /**
     * The paddleWidth method return the width of the paddle in this level.
     * @return the width of the paddle in this level.
     */
    public int paddleWidth() {
        return 500;
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
        return "Wide Easy";
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
