// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Animation;
import biuoop.DrawSurface;
/**
 * The GenericAnimation class responsible for a generic animation.
 */
public class GenericAnimation {
    /**
     * The GenericAnimation method is a builder, that create a for
     * a GenericAnimation object.
     */
    public GenericAnimation() {
    }
    /**
     * The doOneFrame method run one frame of the animation.
     * @param d the draw surface that the game run on.
     */
    public void doOneFrame(DrawSurface d) {
    }
    /**
     * The shouldStop method find out if the animation should stop.
     * @return true if the animation should stop, and false if not.
     */
    public boolean shouldStop() {
        return false;
    }
    /**
     * The getLevelName method return the animation name.
     * @return the animation name.
     */
    public String getLevelName() {
        return null;
    }
}
