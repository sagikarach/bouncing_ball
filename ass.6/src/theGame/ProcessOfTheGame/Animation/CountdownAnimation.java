// Sagi Karach 206863888.
package theGame.ProcessOfTheGame.Animation;
import biuoop.*;
import theGame.ElementsInTheGame.DataKeepers.SpriteCollection;
import theGame.interfaces.*;
import java.awt.*;
/**
 * The CountdownAnimation class responsible for an animation that count
 * down in the beginning of every level.
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private long delay;
    private SpriteCollection gameScreen;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    private LevelInformation levelInformation;
    /**
     * The CountdownAnimation method is a builder, that create a
     * CountdownAnimation object.
     * @param numOfSeconds the num of second that the animation need
     *                     to run.
     * @param countFrom the number that the animation count from.
     * @param gameScreen the elements of the current level.
     * @param levelInformation the current level's information.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen,
                              LevelInformation levelInformation) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.delay = (long) (numOfSeconds / countFrom * 1000);
        this.levelInformation = levelInformation;
    }
    /**
     * The doOneFrame method run one frame of the countdown animation.
     * @param d the draw surface that the game run on.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        Color color = new Color(150, 50, 50);
        d.setColor(color);
        d.drawText((d.getWidth() / 2 - 30), (d.getHeight() / 2),
                String.valueOf(countFrom), 100);
        this.countFrom--;
    }
    /**
     * The shouldStop method find if the countdown is complete, and
     * make sure that between every number will be a delay.
     * @return true if the countdown is complete, and false if not.
     */
    public boolean shouldStop() {
        this.sleeper.sleepFor(this.delay);
        return  (countFrom == 0);
    }
    /**
     * The getBackground method return the current level's animation background.
     * @return the current level's background.
     */
    public Sprite getBackground() {
        return this.levelInformation.getBackground();
    }
    /**
     * The getLevelName method return the current level name.
     * @return the current level name.
     */
    public String getLevelName() {
        return this.levelInformation.levelName();
    }
}
