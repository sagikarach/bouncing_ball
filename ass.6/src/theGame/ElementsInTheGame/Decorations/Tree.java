// Sagi Karach 206863888.
package theGame.ElementsInTheGame.Decorations;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
import theGame.ElementsInTheGame.shape.Rectangle;
import java.awt.*;
/**
 * The Tree class responsible for a tree object.
 */
public class Tree implements Sprite {
    private Rectangle rectangle;
    /**
     * The Tree method is a constructor, that create a tree, according to his trunk.
     * @param rectangle the tree's trunk.
     */
    public Tree(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    /**
     * The drawOn method draw the tree on the surface.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        Color brown = new Color(150, 100, 50);
        d.setColor(brown);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        Color darkGreen = new Color(40, 100, 40);
        d.setColor(darkGreen);
        d.fillPolygon(new Polygon(new int[]{
                (int) (this.rectangle.getUpperLeft().getX() - this.rectangle.getWidth()),
                (int) (this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 2)),
                (int) (this.rectangle.getUpperLeft().getX() + (2 * this.rectangle.getWidth()))},
                new int[]{(int) this.rectangle.getUpperLeft().getY(),
                        (int) (this.rectangle.getUpperLeft().getY() - (this.rectangle.getHeight() * 2)),
                        (int) this.rectangle.getUpperLeft().getY()}, 3));    }

    /**
     * The timePassed method tell the tree object that time has passed.
     */
    public void timePassed() {

    }
}
