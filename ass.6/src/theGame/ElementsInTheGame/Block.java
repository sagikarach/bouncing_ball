// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Point;
import theGame.ElementsInTheGame.shape.Rectangle;

import java.util.ArrayList;

/**
 * the Block class create a type of collidable on the game that call block.
 * in this class we will find the methods of this block.
 */
public class Block extends Collide implements Collidable, Sprite, HitNotifier {
    private java.util.List<HitListener> hitListeners = new ArrayList<HitListener>();
    /**
     * the Block method is a builder how create blocks.
     * @param rectangle is a Rectangle variable how represent the shape of the blocks.
     * @param color is the block's color.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        super(rectangle, color);
    }
    /**
     * the hit method operate in case the ball will intersect with one of
     * the borders of the block, and return a new velocity to the ball
     * according to which border the ball will intersect with.
     * @param hitter is the ball how will hit the block.
     * @param collisionPoint is the point in which the ball will intersect
     *                       with the block's border.
     * @param currentVelocity is the current velocity of the ball how will
     *                        hit the block.
     * @return the method will return the new velocity according to which
     * border the ball will intersect with.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        // find out if the ball will hit the up or down of the blocks.
        if (this.getCollisionRectangle().checkIfTheBallWillHitUpOrDownBorder(collisionPoint, hitter.getSize())) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
    }
    /**
     * the notifyHit method notify all the block's listeners, that a ball hits the block.
     * @param hitter the ball that hit the block.
     */
    private void notifyHit(Ball hitter) {
        if (this.hitListeners != null) {
            // Make a copy of the hitListeners before iterating over them.
            java.util.List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
            // Notify all listeners about a hit event:
            for (HitListener hl : listeners) {
                hl.hitEvent(this, hitter);
            }
        }
    }
    /**
     * the addHitListener method adds to the block a listener to notify.
     * @param hl a new listener to notify.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * the removeHitListener method remove one of the listener that the block's
     * object needed to notify.
     * @param hl the listener that need to delete.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
