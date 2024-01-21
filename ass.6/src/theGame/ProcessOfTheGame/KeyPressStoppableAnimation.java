// Sagi Karach 206863888.
package theGame.ProcessOfTheGame;
import biuoop.*;
import theGame.interfaces.*;
/**
 * The KeyPressStoppableAnimation class is responsible for all the animation
 * how wait for key press to stop it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean shouldStop = false, isAlreadyPressed = true;
    /**
     * The KeyPressStoppableAnimation method is builder, how create KeyPressStoppableAnimation
     * objects.
     * @param sensor is the keyboard sensor that check if the user press a key.
     * @param key the key that the user need to press to stop the animation.
     * @param animation the animation that stopped after the user press the right key.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key,
                                      Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
    }
    /**
     * The doOneFrame method check if the user press the right key.
     * @param d the draw surface of the game.
     */
    public void doOneFrame(DrawSurface d) {
        if (this.key.equals("SPACE_KEY")) {
            if (!this.isAlreadyPressed) {
                if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
                    this.shouldStop = true;
                }
            }
        }
        this.isAlreadyPressed = false;
    }
    /**
     * The shouldStop method tell if the animation should stop, or not.
     * @return a boolean that tell if the animation should stop, or not.
     */
    public boolean shouldStop() {
        return this.shouldStop;
    }
    /**
     * The getBackground method return the background of the animation.
     * @return the background of the animation.
     */
    public Sprite getBackground() {
        return this.animation.getBackground();
    }
    /**
     * The getLevelName method return the animation's name.
     * @return the animation's name.
     */
    public String getLevelName() {
        return this.animation.getLevelName();
    }
}
