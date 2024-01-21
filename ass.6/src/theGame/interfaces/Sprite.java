// Sagi Karach 206863888.
package theGame.interfaces;
import biuoop.DrawSurface;
/**
 * the Sprite interface is represents all the objects on the board,
 * including the ball.
 */
public interface Sprite {
    /**
     * the drawOn method draw the object on the game's board.
     * @param d a pointer to the game's board.
     */
    void drawOn(DrawSurface d);
    /**
     * the timePassed method notify the object that time passed.
     */
    void timePassed();
}
