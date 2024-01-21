// Sagi Karach 206863888.
package theGame.ProcessOfTheGame;
import biuoop.*;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.*;
import theGame.ProcessOfTheGame.Animation.*;
import theGame.interfaces.*;
import theGame.listeners.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;

import java.awt.*;
/**
 * the Game class responsible to initializing the level, and running him.
 */
public class GameLevel implements Animation {
    private static final int WIDTH_OF_THE_BOARD = 800, HEIGHT_OF_THE_BOARD = 600;
    private SpriteCollection sprites = new SpriteCollection(
            new java.util.ArrayList<Sprite>());
    private GameEnvironment gameEnvironment = new GameEnvironment(
            new java.util.ArrayList<Collidable>());
    private Counter remainingBlocks = new Counter(0), ballsCounter = new Counter(0);
    private BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
    private BallRemover ballRemover = new BallRemover(this, ballsCounter);
    private ScoreTrackingListener scoreTrackingListener;
    private boolean running;
    private GUI gui;
    private AnimationRunner runner;
    private KeyboardSensor keyboardSensor;
    private LevelInformation levelInformation;
    /**
     * The GameLevel method is a builder, that create GameLevel objects.
     * @param levelInfo is the information about the current level.
     * @param keyboardSensor is a keyboard sensor.
     * @param animationRunner is the object how run the animation.
     * @param gui is the graphic of the game.
     * @param scoreTrackingListener is a score tracking listener for the all game.
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, GUI gui,
                     ScoreTrackingListener scoreTrackingListener) {
        this.levelInformation = levelInfo;
        this.keyboardSensor = keyboardSensor;
        this.runner = animationRunner;
        this.gui = gui;
        this.scoreTrackingListener = scoreTrackingListener;
    }
    /**
     * the addCollidable method adds collidable to the level.
     * @param newCollidable the collidable that the user want to add to the level.
     */
    public void addCollidable(Collidable newCollidable) {
        this.gameEnvironment.addCollidable(newCollidable);
    }
    /**
     * the addSprite method add an object to the level.
     * @param newSprite the object that the user want to add to the level.
     */
    public void addSprite(Sprite newSprite) {
        this.sprites.addSprite(newSprite);
    }
    /**
     * the removeCollidable method removes collidable from the level.
     * @param collidableToDelete the collidable that we want to remove from the level.
     */
    public void removeCollidable(Collidable collidableToDelete) {
        this.gameEnvironment.removeCollidable(collidableToDelete);
    }
    /**
     * the removeSprite method remove an object from the level.
     * @param spriteToDelete the object that we want to remove from the level.
     */
    public void removeSprite(Sprite spriteToDelete) {
        this.sprites.removeSprite(spriteToDelete);
    }
    /**
     * the initialize method responsible to initialize the level.
     */
    public void initialize() {
        bordersCreator(ballRemover);
        for (int i = 0; i < this.levelInformation.blocks().size(); ++i) {
            this.blocksCreator(this.levelInformation.blocks().get(i));
        }
        for (int i = 0; i < this.levelInformation.numberOfBalls(); ++i) {
            this.ballCreator(this.levelInformation.initialBallLocations().get(i), 10,
                    this.levelInformation.initialBallVelocities().get(i),
                    this.levelInformation.ballsColor());
        }
        new ScoreIndicator(this.scoreTrackingListener.getScoreCounter()).addToGame(this);
        new Paddle(new Line(new Point(200, 580), new Point(200 + this.levelInformation.paddleWidth(), 580)),
                15, this.gui.getKeyboardSensor(), this.levelInformation.paddleSpeed(),
                this.levelInformation.paddleColor()).addToGame(this);
    }

    /**
     * the bordersCreator method creates border to the level.
     * @param ballRemover is a listener, that set to act in case a ball go through the down border.
     */
    private void bordersCreator(BallRemover ballRemover) {
        new Border(new Line(new Point(0, 0),
                new Point(0, HEIGHT_OF_THE_BOARD))).addToGame(this);
        new Border(new Line(new Point(0, 0),
                new Point(WIDTH_OF_THE_BOARD, 0))).addToGame(this);
        new Border(new Line(new Point(WIDTH_OF_THE_BOARD, 0),
                new Point(WIDTH_OF_THE_BOARD, HEIGHT_OF_THE_BOARD))).addToGame(this);
        DownBorder downBorder = new DownBorder(new Line(new Point(0, HEIGHT_OF_THE_BOARD),
                new Point(WIDTH_OF_THE_BOARD, HEIGHT_OF_THE_BOARD)));
        downBorder.addHitListener(ballRemover);
        downBorder.addToGame(this);
    }
    /**
     * the blocksCreator method creates blocks in the level.
     * @param block is the block how we want to create and add to the level.
     */
    private void blocksCreator(Block block) {
        block.addHitListener(this.blockRemover);
        block.addHitListener(this.scoreTrackingListener);
        this.remainingBlocks.increase(1);
        block.addToGame(this);
    }

    /**
     * the ballCreator methods creates balls in the level.
     * @param center the center point of the new ball.
     * @param radios the radios of the new ball.
     * @param velocity the velocity of the new ball.
     * @param color the color of the new ball.
     */
    private void ballCreator(Point center, int radios, Velocity velocity, Color color) {
        Ball ball = new Ball(center.getX(), center.getY(), radios, gameEnvironment);
        ball.setVelocity(velocity.getDx(), velocity.getDy());
        ball.addHitListener(this.ballRemover);
        ball.setColor(color);
        this.ballsCounter.increase(1);
        ball.addToGame(this);
    }
    /**
     * the run method is responsible to running the level.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites,
                this.levelInformation));
        this.running = true;
        this.runner.run(this);
    }
    /**
     * The doOneFrame method do one frame of the current level.
     * @param d is the draw surface of the game.
     */
    public void doOneFrame(DrawSurface d) {
        // Check if the player want to pause.
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "SPACE_KEY",
                    new PauseScreen()));
        }
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
        // In case the player finish the level.
        if (this.remainingBlocks.getValue() == 0) {
            this.running = false;
            this.scoreTrackingListener.getScoreCounter().increase(200);
        // In case the player lost in the game.
        } else if (this.ballsCounter.getValue() == 0) {
            this.running = false;
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "SPACE_KEY",
                    new GameOver(this.scoreTrackingListener.getScoreCounter())));
        }
    }
    /**
     * The shouldStop method tell if the level should stop, or not.
     * @return a boolean that tell if the level should stop, or not.
     */
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * The getBackground method return the background of the level.
     * @return the background of the level.
     */
    public Sprite getBackground() {
        return levelInformation.getBackground();
    }
    /**
     * The getLevelName method return the level's name.
     * @return the level's name.
     */
    public String getLevelName() {
        return this.levelInformation.levelName();
    }
    /**
     * The checkIfLost method check if the player lost the game.
     * @return true if the player lost the game, and false if not.
     */
    public boolean checkIfLost() {
        return (this.ballsCounter.getValue() == 0);
    }
}
