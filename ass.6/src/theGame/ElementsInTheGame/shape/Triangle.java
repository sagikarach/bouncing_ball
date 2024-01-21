// Sagi Karach 206863888.
package theGame.ElementsInTheGame.shape;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
import java.awt.*;
/**
 * The Triangle Class responsible for the triangle object.
 */
public class Triangle implements Sprite {
    private Point vertex1, vertex2, vertex3;
    private java.awt.Color color;
    /**
     * The Triangle method is constructor, that create a triangle
     * object, according to his vertexes.
     * @param vertex1 the triangle's first vertex.
     * @param vertex2 the triangle's second vertex.
     * @param vertex3 the triangle's third vertex.
     * @param color the triangle's color.
     */
    public Triangle(Point vertex1, Point vertex2, Point vertex3,
                    java.awt.Color color) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.color = color;
    }
    /**
     * The drawOn method draw the triangle on the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillPolygon(new Polygon(new int[]{(int) this.vertex1.getX(),
                (int) this.vertex2.getX(), (int) this.vertex3.getX()},
                new int[]{(int) this.vertex1.getY(), (int) this.vertex2.getY(),
                        (int) this.vertex3.getY()}, 3));
    }
    /**
     * The timePassed method let the triangle object know that
     * time has passed.
     */
    public void timePassed() {

    }
}
