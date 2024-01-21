// Sagi Karach 206863888.
package theGame.ElementsInTheGame.shape;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
/**
 * The Circle Class responsible for the circle object.
 */
public class Circle implements Sprite {
    private Point center;
    private double r;
    private java.awt.Color color;
    private boolean fill;
    /**
     * The Circle method is constructor, that create circle according to his
     * center, radios and color.
     * @param center the ball's center.
     * @param r the ball's radios.
     * @param color the ball's color.
     * @param fill a boolean that tell if the user want a fill circle or not.
     */
    public Circle(Point center, double r, java.awt.Color color, boolean fill) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.fill = fill;
    }
    /**
     * The drawOn method print the circle in the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        if (fill) {
            d.fillCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.r);
        } else {
            d.drawCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.r);
        }
    }
    /**
     * The timePassed method tell the circle object that time has passed.
     */
    public void timePassed() {

    }
}
