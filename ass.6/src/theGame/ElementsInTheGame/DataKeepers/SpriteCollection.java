// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import biuoop.DrawSurface;
import theGame.interfaces.Sprite;
/**
 * the SpriteCollection class contain all the objects in the game.
 */
public class SpriteCollection {
    private java.util.List<Sprite> spriteCollection;
    /**
     * the SpriteCollection method is a builder, that create a sprite collection.
     * @param spriteCollection a pointer to a list of sprite objects.
     */
    public SpriteCollection(java.util.List<Sprite> spriteCollection) {
        this.spriteCollection = spriteCollection;
    }
    /**
     * the addSprite method add a sprite object to the list of the sprites.
     * @param newSprite the sprite object that we want to add to the list of the sprites.
     */
    public void addSprite(Sprite newSprite) {
        this.spriteCollection.add(newSprite);
    }
    /**
     * the removeSprite method removes a sprite object from the list of the sprites.
     * @param spriteToRemove the sprite object that we want to remove from the list of the sprites.
     */
    public void removeSprite(Sprite spriteToRemove) {
        this.spriteCollection.remove(spriteToRemove);
    }
    /**
     * the notifyAllTimePassed method notify all the sprite in the sprite collection.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteCollection.size(); ++i) {
            spriteCollection.get(i).timePassed();
        }
    }
    /**
     * the drawAllOn method draw all the sprite in the sprite collection in the
     * game's board.
     * @param d a pointer to the game's board.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spriteCollection.size(); ++i) {
            spriteCollection.get(i).drawOn(d);
        }
    }
    /**
     * the getSize method return the size of the sprite collection.
     * @return the size of the sprite collection.
     */
    public int getSize() {
        return spriteCollection.size();
    }
}
