// Sagi Karach 206863888.
package theGame.ElementsInTheGame;
import biuoop.DrawSurface;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.ProcessOfTheGame.GameEnvironment;
import theGame.ProcessOfTheGame.GameLevel;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Line;
import theGame.ElementsInTheGame.shape.Point;

import java.awt.*;
import java.util.ArrayList;
/**
 * the Ball class create an object that his name is ball,
 * with his board start and end points, his center point value,
 * his radios, his color, and his velocity.
 */
public class Ball implements Sprite, HitNotifier {
    private int timePassed = 0, r;
    private Point center;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private java.util.List<HitListener> hitListeners = new ArrayList<HitListener>();
    /**
     * the Ball function is a builder of the ball variable.
     * @param center the ball center point value.
     * @param r the radios ball value.
     * @param gameEnvironment a pointer to the game.
     */
    public Ball(Point center, int r, GameEnvironment gameEnvironment) {
        this.center = new Point(center.getX(), center.getY());
        this.r = Math.abs(r);
        this.gameEnvironment = gameEnvironment;
        this.color = Color.black;
    }
    /**
     * the Ball function is a builder of the ball variable.
     * @param x the ball center point horizontal value.
     * @param y the ball center point vertical value.
     * @param r the radios ball value.
     * @param gameEnvironment a pointer to the game.
     */
    public Ball(double x, double y, int r, GameEnvironment gameEnvironment) {
        this (new Point(x, y), r,  gameEnvironment);
    }
    /**
     * The setColor method set the color of the current ball.
     * @param color the color that the user want to set to the ball.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    /**
     * the addToGame method add the ball to the game.
     * @param g is a pointer to the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * the removeFromGame method remove a ball from the game.
     * @param g a pointer to the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
    /**
     * the getX function return the ball's center point horizontal value.
     * @return the function return the ball's center point horizontal value.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * the getY function return the ball's center point vertical value.
     * @return the function return the ball's center point vertical value.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * the getSize function return the ball's radios value.
     * @return the function return the ball's radios value.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * the getColor function return the ball's color.
     * @return the function return the ball's color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * the drawOn function draw the current ball on a surface.
     * @param surface the surface the function draw the ball on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }
    /**
     * the timePassed method tell the ball that the time is past,
     * and he needs to move one step.
     */
    public void timePassed() {
        moveOneStep();
    }
    /**
     * the function setVelocity change the current ball velocity.
     * @param v the new velocity that the user want to set to the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * the function setVelocity change the current ball velocity.
     * @param dx the new horizontal velocity that the user want to set to the ball.
     * @param dy the new vertical velocity that the user want to set to the ball.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * the getVelocity function return the current ball velocity.
     * @return the function return the current ball velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * the moveOneStep method move the current ball one step by his velocity,
     * but in case the ball next step is over the board's borders, then the function
     * call to other methods how find the intersection point of the ball, and send
     * the velocity accordingly.
     */
    public void moveOneStep() {
        CollisionInfo collision = this.gameEnvironment.getClosestCollision(
                new Line(this.center.getX(), this.center.getY(),
                        this.center.getX() + this.velocity.getDx(),
                        this.center.getY() + this.velocity.getDy()),
                      this, this.getVelocity());
        if (collision == null) {
            this.center = this.velocity.applyToPoint(this.center);
        } else {
            this.center = collision.collisionPoint();
            // in case the ball hit a corner of a collidable.
            if (checkIfInACorner(collision)) {
                this.velocity = new Velocity(this.velocity.getDx() * (-1),
                        this.velocity.getDy() * (-1));
            } else {
                this.velocity = collision.getNewVelocity();
            }
        }
    }
    /**
     * the checkIfInACorner method check if the intersection point of the ball is in a corner.
     * @param collision the info about the collision of the ball and the object.
     * @return true if the ball is in a corner, and false is he isn't.
     */
    public boolean checkIfInACorner(CollisionInfo collision) {
        return collision.collisionObject().getCollisionRectangle().checkIfTheBallWillHitACorner(
                collision.collisionPoint(), this.r);
    }
    /**
     * the addHitListener method adds to the ball a listener to notify.
     * @param hl a new listener to notify.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * the removeHitListener method remove one of the listener that the ball's
     * object needed to notify.
     * @param hl the listener that need to delete.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}