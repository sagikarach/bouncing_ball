// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import biuoop.DrawSurface;
import theGame.ProcessOfTheGame.GameLevel;
import theGame.interfaces.*;

import java.awt.*;

/**
 * the ScoreIndicator class create an object that contain the score of the game,
 * and the methods that can apply on them.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    /**
     * the ScoreIndicator method is builder, that create a ScoreIndicator object.
     * @param score is a counter how contain the score of the game.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    /**
     * the addToGame method add the ScoreIndicator object to the game.
     * @param g a pointer to the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * the drawOn method draw the score of the game on the board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(370, 20, "Score: " + this.score.getValue(), 15);
    }
    /**
     * the timePassed method activate when we need to inform the ScoreIndicator object
     * that a time has passed.
     */
    public void timePassed() {
    }
}
