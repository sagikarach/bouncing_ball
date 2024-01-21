// Sagi Karach 206863888
package theGame.listeners;
import theGame.ElementsInTheGame.DataKeepers.Counter;
import theGame.ProcessOfTheGame.GameLevel;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.*;
/**
 * the BlockRemover class is a type of listener, that will
 * be activated when one of the blocks need to delete.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * the BlockRemover method is a builder, that create a
     * block remover listener.
     * @param game a pointer to the game, that hold all the
     *             blocks.
     * @param remainingBlocks a counter of the blocks in the
     *                        game.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }
    /**
     * the hitEvent method is an activation of the block remover
     * listener, delete the block that been hit, and decrease by one
     * the blocks counter.
     * @param beingHit the block that we want to delete.
     * @param hitter the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}
