// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Animation;
import theGame.ElementsInTheGame.DataKeepers.Background;
import theGame.ElementsInTheGame.Decorations.Text;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Point;
import java.awt.*;
import java.util.ArrayList;
/**
 * The PauseScreen class responsible for an animation that show when
 * the player want to pause the game.
 */
public class PauseScreen extends GenericAnimation implements Animation {
    private Background background = new Background(new ArrayList<Sprite>());
    /**
     * The PauseScreen method is a builder, that create a PauseScreen objects.
     */
    public PauseScreen() {
        this.background.addElement(new Text("paused -- press space to continue",
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
