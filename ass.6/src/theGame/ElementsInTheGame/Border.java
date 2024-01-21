// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
/**
 * the class Border create an object that his name is Border, that surrounded the
 * board of the game.
 */
public class Border extends Collide implements Collidable, Sprite {
    private static final int LEFT_BORDER = 1, UP_BORDER = 2, RIGHT_BORDER = 3;
    /**
     * the Border method is a builder, that create new border's object.
     * @param border the line where the broder assigned.
     */
    public Border(Line border) {
        super(border);
    }
    /**
     * the checkWhichBorder method find out which border we're handling now,
     * and return an integer that represent the type of the border.
     * @return an integer that represent the type of the border.
     */
    private int checkWhichBorder() {
        if (this.getBorder().start().getY() == this.getBorder().end().getY()) {
            return UP_BORDER;
        } else if (this.getBorder().start().equals(new Point(0, 0))) {
            return LEFT_BORDER;
        } else {
            return RIGHT_BORDER;
        }
    }
    /**
     * the hit method operate in case the ball will hit with one of
     * the borders of the collide object, and return a new velocity to the ball
     * according to which border the ball will intersect with.
     * @param hitter is ball how will hit the collide object.
     * @param collisionPoint is the point in which the ball will intersect
     *                       with the collide object's border.
     * @param currentVelocity is the current velocity of the ball how will
     *                        hit the collide object.
     * @return the method will return the new velocity according to which
     * border the ball will intersect with.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        switch (this.checkWhichBorder()) {
            case LEFT_BORDER, RIGHT_BORDER:
                return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
            case UP_BORDER:
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        return currentVelocity;
    }
    /**
     * the getCollisionPoint method find the collision point with the ball and
     * the border, and return the collision information.
     * @param trajectory the path of the ball.
     * @param hitter the ball.
     * @return the collision between the ball and the border's information.
     */
    public Point getCollisionPoint(Line trajectory, Ball hitter) {
        Point collisionPoint = null;
        switch (this.checkWhichBorder()) {
            case LEFT_BORDER:
                collisionPoint = new Line(this.getBorder().start().getX() + hitter.getSize(),
                        this.getBorder().start().getY() + hitter.getSize(),
                        this.getBorder().end().getX() + hitter.getSize(),
                        this.getBorder().end().getY() - hitter.getSize()).intersectionWith(trajectory);
                break;
            case UP_BORDER:
                collisionPoint = new Line(this.getBorder().start().getX() + hitter.getSize(),
                        this.getBorder().start().getY() + hitter.getSize(),
                        this.getBorder().end().getX() - hitter.getSize(),
                        this.getBorder().end().getY() + hitter.getSize()).intersectionWith(trajectory);
                break;
            case RIGHT_BORDER:
                collisionPoint = new Line(this.getBorder().start().getX() - hitter.getSize(),
                        this.getBorder().start().getY() + hitter.getSize(),
                        this.getBorder().end().getX() - hitter.getSize(),
                        this.getBorder().end().getY() - hitter.getSize()).intersectionWith(trajectory);
                break;
            default:
        }
    return collisionPoint;
    }
}
