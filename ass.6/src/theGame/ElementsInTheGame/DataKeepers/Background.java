// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
/**
 * The Background class responsible for the background object.
 */
public class Background implements Sprite {
    private SpriteCollection elements;
    /**
     * The Background method is a constructor, how create a
     * background with a Sprite collection.
     * @param spriteCollection the background's Sprite collection.
     */
    public Background(java.util.List<Sprite> spriteCollection) {
        this.elements = new SpriteCollection(spriteCollection);
    }
    /**
     * The addElement method add a new element to the background.
     * @param newElement the new element the user want to add to
     *                   the background.
     */
    public void addElement(Sprite newElement) {
        this.elements.addSprite(newElement);
    }
    /**
     * The drawOn method draw all the elements of the background
     * on the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        this.elements.drawAllOn(d);
    }
    /**
     * The timePassed method notify all the elements in the
     * background that time has passed.
     */
    public void timePassed() {
        this.elements.notifyAllTimePassed();
    }
}
