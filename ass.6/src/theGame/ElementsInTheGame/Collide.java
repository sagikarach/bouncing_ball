// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import biuoop.DrawSurface;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.ProcessOfTheGame.GameLevel;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
import theGame.ElementsInTheGame.shape.Point;
import theGame.ElementsInTheGame.shape.Rectangle;

import java.awt.*;

/**
 * the Collide class contain a collision object's type, and his
 * methods.
 */
public class Collide implements Collidable, Sprite {
    private Rectangle rectangle;
    private Line line;
    private java.awt.Color color;
    private biuoop.KeyboardSensor keyboard;
    /**
     * the Collide method is a builder, that create a Collide object.
     * @param rectangle the shape of the collide object.
     * @param color is the collides color.
     */
    public Collide(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = new Rectangle(rectangle.getUpperLeft(),
                rectangle.getWidth(), rectangle.getHeight());
        this.color = color;
    }
    /**
     * the Collide method is a builder, that create a Collide object.
     * @param border the shape of the collide object.
     */
    public Collide(Line border) {
        this.line = border;
        this.rectangle = new Rectangle(border.start(), border.end().getX() - border.start().getX(),
                border.end().getY() - border.start().getY());
        this.color = Color.black;
    }
    /**
     * the Collide method is a builder, that create a Collide object.
     * @param paddle the shape of the collide object.
     * @param height is the height of the collide object.
     * @param keyboard is a keyboard sensor of the collide object.
     * @param color is the collides color.
     */
    public Collide(Line paddle, double height, biuoop.KeyboardSensor keyboard, Color color) {
        this.rectangle = new Rectangle(paddle.start(), paddle.end().getX()
                - paddle.start().getX(), height);
        this.keyboard = keyboard;
        this.line = paddle;
        this.color = color;
    }

    /**
     * The setColor method set the collides color.
     * @param color the new color for collide.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    /**
     * the getCollisionRectangle method return collide object's shape.
     * @return the block's shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * the getBorder return the border's shape.
     * @return the border's shape.
     */
    public Line getBorder() {
        return this.line;
    }
    /**
     * the getPaddle method return the paddle shape.
     * @return the paddle shape.
     */
    public Line getPaddle() {
        return this.line;
    }
    /**
     * the setPaddle method change the paddle location.
     * @param paddle the new paddle location.
     */
    public void setPaddle(Line paddle) {
        this.line = paddle;
        this.rectangle = new Rectangle(paddle.start(), this.rectangle.getWidth(),
                this.rectangle.getHeight());
    }
    /**
     * the getKeyboard method return the keyboard sensor of the paddle.
     * @return the keyboard sensor of the paddle.
     */
    public biuoop.KeyboardSensor getKeyboard() {
        return this.keyboard;
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
        if (this.line.checkIfTheIntersectionYInTheLine(collisionPoint.getY())) {
            return new Velocity(currentVelocity.getDx()  * (-1), currentVelocity.getDy());
        }
        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
    }
    /**
     * the method addToGame add a collides object to the field of the game.
     * @param g is a pointer to the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * the removeFromGame method remove a collides object from the field of the
     * game.
     * @param g is a pointer to the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }
    /**
     * the drawOn method drow the collides object on the game's board.
     * @param d is a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX() - 1,
                (int) this.rectangle.getUpperLeft().getY() - 1,
                (int) this.rectangle.getWidth() + 2, (int) this.rectangle.getHeight() + 2);
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    /**
     * the timePassed method tell the collides object that the time is passed.
     */
    public void timePassed() {
    }
    /**
     * the getCollisionPoint method find the collision point with the ball and
     * the collides object, and return the collision information.
     * @param trajectory the path of the ball.
     * @param hitter the ball.
     * @return the collision between the ball and the collides object's information.
     */
    public Point getCollisionPoint(Line trajectory, Ball hitter) {
          return trajectory.closestIntersectionToStartOfLine(this.rectangle, hitter);
    }
}
