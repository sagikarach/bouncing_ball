// Sagi Karach 206863888.
package theGame.ProcessOfTheGame;
import biuoop.*;
import theGame.interfaces.*;
/**
 * The AnimationRunner class responsible for running the animation
 * if the game.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    /**
     * The AnimationRunner method is a builder, that create an
     * AnimationRunner objects.
     * @param gui the graphic of the game.
     * @param framesPerSecond is the speed of the frames in the game.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }
    /**
     * The run method run an animation and draw him in the game graphic.
     * @param animation the animation that the method need to run.
     */
    public void run(Animation animation) {
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = this.gui.getDrawSurface();
            animation.getBackground().drawOn(d);
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = this.framesPerSecond - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
