// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;
import java.awt.*;
import java.util.ArrayList;
/**
 * the DownBorder class contain the object DownBorder, and all his methods.
 */
public class DownBorder extends Border implements Collidable, Sprite, HitNotifier {
    private java.util.List<HitListener> hitListeners = new ArrayList<HitListener>();
    /**
     * the DownBorder method is a builder, that create new DownBorder's object.
     * @param border the line where the broder assigned.
     */
    public DownBorder(Line border) {
        super(border);
    }
    /**
     * the hit method act when one of the ball go through the down border.
     * @param hitter is the radios of the ball how go through the down border.
     * @param collisionPoint is the point that the ball go through the down border.
     * @param currentVelocity is the current velocity of the ball how hit the down border.
     * @return the current velocity of the ball after he went through the down border.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        return currentVelocity;
    }
    /**
     * the addHitListener method adds to the down border a listener to notify.
     * @param hl a new listener to notify.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * the removeHitListener method remove one of the listener that the down border's
     * object needed to notify.
     * @param hl the listener that need to delete.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * the notifyHit method notify all the down border's listeners, that a ball went
     * through the down border.
     * @param hitter the ball that went through the down border.
     */
    private void notifyHit(Ball hitter) {
        if (this.hitListeners != null) {
            // Make a copy of the hitListeners before iterating over them.
            java.util.List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
            // Notify all listeners about a hit event:
            for (HitListener hl : listeners) {
                hl.hitEvent(new Block(this.getCollisionRectangle(), Color.red), hitter);
            }
        }
    }
    /**
     * the getCollisionPoint method find the collision point of the ball and the down border,
     * and return the collision's information.
     * @param trajectory the path of the ball.
     * @param hitter the ball.
     * @return the collision between the ball and the down border's information.
     */
    public Point getCollisionPoint(Line trajectory, Ball hitter) {
        return new Line(new Point(this.getCollisionRectangle().
                getUpperLeft().getX() - hitter.getSize(), this.getCollisionRectangle().getUpperLeft().getY()
                + hitter.getSize()), new Point(this.getCollisionRectangle().getUpperLeft().getX()
                + this.getCollisionRectangle().getWidth() + hitter.getSize(), this.getCollisionRectangle().
                getUpperLeft().getY() + hitter.getSize())).intersectionWith(trajectory);
    }
}
