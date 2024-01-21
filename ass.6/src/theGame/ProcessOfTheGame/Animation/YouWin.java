// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Animation;
import theGame.ElementsInTheGame.DataKeepers.*;
import theGame.ElementsInTheGame.Decorations.Text;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.Point;
import java.awt.*;
/**
 * The YouWin class responsible for an animation that show when
 * the player win the game.
 */
public class YouWin extends GenericAnimation implements Animation {
    private Background background = new Background(new java.util.ArrayList<Sprite>());
    /**
     * The GameOver method is a builder, that create a GameOver objects.
     * @param countScore the game's score counter.
     */
    public YouWin(Counter countScore) {
        Color color = new Color(200, 150, 0);
        this.background.addElement(new Text("You Win! Your score is "
                + countScore.getValue(), new Point(90, 280), 50, color));
    }
    /**
     * The getBackground method return this animation background.
     * @return this animation background.
     */
    public Sprite getBackground() {
        return this.background;
    }
}
