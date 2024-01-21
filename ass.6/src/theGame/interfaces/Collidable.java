// Sagi Karach 206863888.
package theGame.interfaces;
import theGame.ElementsInTheGame.Ball;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.ElementsInTheGame.shape.*;

/**
 * the Collidable interface represents all the objects on the board,
 * that the ball can hit.
 */
public interface Collidable {
    /**
     * the getCollisionRectangle method return the shape of the collidable.
     * @return the shape of the collidable.
     */
    Rectangle getCollisionRectangle();
    /**
     * the hit function change the velocity of the ball, according the collidable
     * that the ball hits, and where he hit him.
     * @param collisionPoint is the point that the ball hit the collidable.
     * @param currentVelocity is the current velocity of the ball how hit the collidable.
     * @param hitter is the radios of the ball how hit the collidable.
     * @return the new velocity of the ball, according the collidable that the ball hits,
     * and where he hit him.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
    /**
     * the getCollisionPoint method find the collision of the ball with the collodable.
      * @param trajectory the path of the ball.
     * @param hitter the ball.
     * @return the collision info between the ball and the cllidable.
     */
    Point getCollisionPoint(Line trajectory, Ball hitter);
}
