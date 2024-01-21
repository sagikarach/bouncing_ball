// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import theGame.ElementsInTheGame.shape.Point;

/**
 * the class velocity is the ball's velocity.
 */
public class Velocity {
    private double dx, dy;
    /**
     * the function velocity is a builder of the velocity class.
     * @param dx the horizontal movement of the ball.
     * @param dy the vertical movement of the ball.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * the applyToPoint function is change the point's location by his velocity..
     * @param p the point how is location will change.
     * @return the point with the new location.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }
    /**
     * the function getDx return the horizontal movement.
     * @return the function return the horizontal movement.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * the function getDy return the vertical movement.
     * @return the function return the vertical movement.
     */
    public double getDy() {
        return this.dy;
    }
}