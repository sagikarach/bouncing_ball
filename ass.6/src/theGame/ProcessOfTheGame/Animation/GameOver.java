// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Animation;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.Decorations.Text;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Point;
import java.awt.*;
/**
 * The GameOver class responsible for an animation that show when
 * the player lost the game.
 */
public class GameOver extends GenericAnimation implements Animation {
    private Background background = new Background(new java.util.ArrayList<Sprite>());
    /**
     * The GameOver method is a builder, that create a GameOver object.
     * @param countScore the game's score counter.
     */
    public GameOver(Counter countScore) {
        this.background.addElement(new Text("Game Over. Your score is " + countScore.getValue(),
                new Point(180, 280), 30, Color.black));
    }
    /**
     * The getBackground method return this animation background.
     * @return this animation background.
     */
    public Sprite getBackground() {
        return this.background;
    }
}
