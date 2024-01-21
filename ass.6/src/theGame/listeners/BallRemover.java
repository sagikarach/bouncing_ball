// Sagi Karach 206863888.
package theGame.listeners;
import theGame.ElementsInTheGame.DataKeepers.Counter;
import theGame.ProcessOfTheGame.GameLevel;
import theGame.interfaces.HitListener;
import theGame.ElementsInTheGame.*;
/**
 * the BallRemover class is a type of listener, that responsible to
 * delete a ball from the game when he went through the down border.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * the BallRemover method is a builder, that create the ball remover
     * listener.
     * @param game a pointer to the game which contain all the balls.
     * @param remainingBalls a counter the hold the number of the balls
     *                       in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }
    /**
     * the hitEvent method is where the listener activate, and the ball will
     * be deleted from the game.
     * @param beingHit the block that the ball hit.
     * @param hitter the ball that we want to delete.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
