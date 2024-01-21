// Sagi Karach 206863888.
package theGame.ElementsInTheGame.Decorations;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
import theGame.ElementsInTheGame.shape.Point;
import java.awt.*;
/**
 * The Text class is responsible for the text object.
 */
public class Text implements Sprite {
    private String sentence;
    private Point location;
    private int size;
    private Color color;
    /**
     * The Text method is a constructor, that create a
     * text object, according to the text's sentence,
     * size, color and location on the game's board.
     * @param sentence the string of the text.
     * @param location the text's location on the game's
     *                 board.
     * @param size the text's size.
     * @param color the text's color.
     */
    public Text(String sentence, Point location, int size, Color color) {
        this.sentence = sentence;
        this.location = location;
        this.size = size;
        this.color = color;
    }
    /**
     * The drawOn method draw the text on the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawText((int) this.location.getX(), (int) this.location.getY(),
                this.sentence, this.size);
    }
    /**
     * The timePassed method notify the text object that time passed.
     */
    public void timePassed() {

    }
}
