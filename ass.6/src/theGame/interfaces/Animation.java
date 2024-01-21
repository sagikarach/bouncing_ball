// Sagi Karach 206863888.
package theGame.interfaces;
import biuoop.*;
/**
 * The Animation interface represents all the animation in the game.
 */
public interface Animation {
    /**
     * The doOneFrame method run one frame of the animation.
     * @param d the draw surface that the game run on.
     */
    void doOneFrame(DrawSurface d);
    /**
     * The shouldStop method find out if the animation should stop.
     * @return true if the animation should stop, and false if not.
     */
    boolean shouldStop();
    /**
     * The getBackground method return the animation's background.
     * @return the animation's background.
     */
    Sprite getBackground();
    /**
     * The getLevelName method return the animation name.
     * @return the animation name.
     */
    String getLevelName();
}
