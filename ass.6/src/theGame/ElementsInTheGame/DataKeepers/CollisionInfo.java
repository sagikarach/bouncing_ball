// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import theGame.interfaces.Collidable;
import theGame.ElementsInTheGame.shape.Point;
/**
 * the CollisionInfo class is hold the data of the collision between the ball and an object.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    private Velocity newVelocity;
    /**
     * the CollisionInfo is a builder, that create a collisionInfo according the collision point,
     * and the object that the ball collided with.
     * @param collisionPoint the point that the ball and the object collided.
     * @param collisionObject the object that the ball collided with.
     * @param newVelocity the new velocity after the ball will collide.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject, Velocity newVelocity) {
        this.collisionPoint = new Point(collisionPoint.getX(), collisionPoint.getY());
        this.collisionObject = collisionObject;
        this.newVelocity = new Velocity(newVelocity.getDx(), newVelocity.getDy());
    }
    /**
     * the collisionPoint method return the collision point of the ball and the object.
     * @return the collision point of the ball and the object.
     */
    public Point collisionPoint() {
        return new Point(this.collisionPoint.getX(), this.collisionPoint.getY());
    }
    /**
     * the collisionObject method return the object that the ball collided with.
     * @return the object that the ball collided with.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
    /**
     * the getNewVelocity method return the ball new velocity.
     * @return the ball new velocity.
     */
    public Velocity getNewVelocity() {
        return new Velocity(this.newVelocity.getDx(), this.newVelocity.getDy());
    }
}
