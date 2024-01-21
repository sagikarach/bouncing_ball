// Sagi Karach 206863888.
package theGame.listeners;
import theGame.ElementsInTheGame.DataKeepers.Counter;
import theGame.ElementsInTheGame.*;
import theGame.interfaces.*;
/**
 * the class ScoreTrackingListener is a type of listener,
 * that keep hold of the game's score.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter scoreCounter;
    /**
     * the ScoreTrackingListener method is a builder, that create
     * this listener that keep hold of the game's score.
     * @param scoreCounter is an integer number witch from him the
     *                     counter start to count.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }
    /**
     * the hitEvent method add to the score 5 points every time the
     * one of the balls hit a block.
     * @param beingHit the block that the ball hits.
     * @param hitter the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       this.scoreCounter.increase(5);
    }
    /**
     * The getScoreCounter method return the score counter.
     * @return the score counter.
     */
    public Counter getScoreCounter() {
        return this.scoreCounter;
    }
}