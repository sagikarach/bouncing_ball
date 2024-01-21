// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;

import java.awt.*;

/**
 * the Paddle class create a type of collidable in the game, how called paddle.
 */
public class Paddle extends Collide implements Collidable, Sprite {
    private double paddleSpeed;
    /**
     * the Paddle method is a builder, how create a paddle in the game.
     * @param paddle   is the line of the paddle.
     * @param height   is the height of the paddle.
     * @param keyboard is a keyboard sensor of the paddle.
     * @param paddleSpeed is then speed that the paddle will move.
     * @param color    is the color of the paddle.
     */
    public Paddle(Line paddle, double height, biuoop.KeyboardSensor keyboard, double paddleSpeed, Color color) {
        super(paddle, height, keyboard, color);
        this.paddleSpeed = paddleSpeed;
    }
    /**
     * the moveLeft method operate in case the user press the left key in the
     * keyboard, and move the paddle to the left according to his speed.
     */
    public void moveLeft() {
        // in case the paddle got to the edge of the board.
        if (this.getPaddle().start().getX() - paddleSpeed < 0) {
            this.setPaddle(new Line(new Point(0, this.getPaddle().start().getY()),
                    new Point(this.getCollisionRectangle().getWidth(),
                            this.getPaddle().end().getY())));
        } else {
            this.setPaddle(new Line(new Point(this.getPaddle().start().getX()
                    - paddleSpeed, this.getPaddle().start().getY()),
                    new Point(this.getPaddle().end().getX() - paddleSpeed,
                            this.getPaddle().end().getY())));
        }
    }

    /**
     * the moveRight method operate in case the user press the right key in the
     * keyboard, and move the paddle to the right according to his speed.
     */
    public void moveRight() {
        // in case the paddle got to the edge of the board.
        if (this.getPaddle().end().getX() + paddleSpeed > 800) {
            this.setPaddle(new Line(new Point(800 - this.getCollisionRectangle().getWidth(),
                    this.getPaddle().start().getY()), new Point(800, this.getPaddle().end().getY())));
        } else {
            this.setPaddle(new Line(new Point(this.getPaddle().start().getX()
                    + paddleSpeed, this.getPaddle().start().getY()),
                    new Point(this.getPaddle().end().getX() + paddleSpeed,
                            this.getPaddle().end().getY())));
        }
    }
    /**
     * the timePassed method notify the paddle that the time passed, and check if the user press
     * the left or the right key in the keyboard.
     */
    public void timePassed() {
        if (this.getKeyboard().isPressed(this.getKeyboard().LEFT_KEY)) {
            moveLeft();
        } else if (this.getKeyboard().isPressed(this.getKeyboard().RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * the hit method operate in case the ball will intersect with one of
     * the borders of the paddle, and return a new velocity to the ball
     * according to which section of the paddle the ball intersect with.
     * @param hitter          is the ball how will hit the paddle.
     * @param collisionPoint  is the point in which the ball will intersect
     *                        with the paddle's border.
     * @param currentVelocity is the current velocity of the ball how will
     *                        hit the paddle.
     * @return the method will return the new velocity according to which
     * section of the paddle the ball intersect with.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // dividing the paddle to five section
        double width = this.getCollisionRectangle().getWidth() + hitter.getSize(),
                startOfSection1 = this.getPaddle().start().getX() - hitter.getSize(),
                startOfSection2 = startOfSection1 + (width / 5),
                startOfSection3 = startOfSection1 + (width / 5 * 2),
                startOfSection4 = startOfSection1 + (width / 5 * 3),
                startOfSection5 = startOfSection1 + (width / 5 * 4);
        if (((collisionPoint.getX() >= startOfSection1) & (collisionPoint.getX() < startOfSection2))
                | (collisionPoint.getX() >= startOfSection5)) {
            return new Velocity(currentVelocity.getDx(),
                    Math.abs(currentVelocity.getDx() * Math.tan(Math.toRadians(300))) * (-1));
        } else if ((collisionPoint.getX() >= startOfSection2) & (collisionPoint.getX() < startOfSection3)
                | ((collisionPoint.getX() >= startOfSection4) & (collisionPoint.getX() < startOfSection5))) {
            return new Velocity(currentVelocity.getDx(),
                    Math.abs(currentVelocity.getDx() * Math.tan(Math.toRadians(330))) * (-1));
        } else {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
    }
    /**
     * the getCollisionPoint method find the collision point with the ball and
     * the collides object, and return the collision information.
     * @param trajectory the path of the ball.
     * @param hitter the ball.
     * @return the collision between the ball and the collides object's information.
     */
    public Point getCollisionPoint(Line trajectory, Ball hitter) {
        Point start = new Point(this.getPaddle().start().getX()
                - hitter.getSize(), this.getPaddle().start().getY() - hitter.getSize());
        Point end = new Point(this.getPaddle().end().getX() + hitter.getSize(),
                this.getPaddle().end().getY() - hitter.getSize());
        Line line = new Line(start, end);
        return line.intersectionWith(trajectory);
    }
}
