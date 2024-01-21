// Sagi Karach 206863888.
package theGame.interfaces;
import theGame.ElementsInTheGame.Ball;
import theGame.ElementsInTheGame.Block;
/**
 * the HitListener interface is type of listener than been activated
 * during the game.
 */
public interface HitListener {
    /**
     * the hitEvent method is an activation of the listener during the
     * game.
     * @param beingHit the block that been hit.
     * @param hitter the ball that hit the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
