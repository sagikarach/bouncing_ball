// Sagi Karach 206863888.
package theGame.ElementsInTheGame.Decorations;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
import theGame.ElementsInTheGame.shape.Rectangle;
import java.awt.*;
/**
 * The House class responsible for a house object.
 */
public class House implements Sprite {
    private Rectangle rectangle;
    /**
     * The House method is a constructor, that create a house, according to his location.
     * @param rectangle the house's location.
     */
    public House(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    /**
     * The drawOn method draw the house on the surface.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.red);
        d.fillPolygon(new Polygon(new int[]{(int) this.rectangle.getUpperLeft().getX(),
                (int) (this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 2)),
                (int) (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())},
                new int[]{(int) this.rectangle.getUpperLeft().getY(),
                        (int) (this.rectangle.getUpperLeft().getY() - (this.rectangle.getHeight() / 2)),
                        (int) this.rectangle.getUpperLeft().getY()}, 3));
        d.setColor(Color.black);
        d.fillRectangle((int) (this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 2) - 5),
                (int) (this.rectangle.getUpperLeft().getY() + (this.rectangle.getHeight() / 3 * 2)),
                10, (int) (this.rectangle.getHeight() / 3));
    }
    /**
     * The timePassed method tell the house object that time has passed.
     */
    public void timePassed() {

    }
}
