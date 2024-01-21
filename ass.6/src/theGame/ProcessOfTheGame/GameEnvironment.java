// Sagi Karach 206863888.
package theGame.ProcessOfTheGame;
import theGame.ElementsInTheGame.DataKeepers.CollisionInfo;
import theGame.ElementsInTheGame.DataKeepers.Velocity;
import theGame.ElementsInTheGame.Ball;
import theGame.interfaces.*;
import theGame.ElementsInTheGame.shape.*;
/**
 * The GameEnvironment class contain all the collidables in the game,
 * and the methods that implicate them.
 */
public class GameEnvironment {
    private java.util.List<Collidable> collidables;
    /**
     * the GameEnvironment function is a builder,
     * that the user can use to build GameEnvironment class.
     * @param collidables is a pointer to a start of a collidables list.
     */
    public GameEnvironment(java.util.List<Collidable> collidables) {
        this.collidables = collidables;
    }
    /**
     * the addCollidable method add a collidable to the game environment.
     * @param newCollidable is the new collidable that the user want to
     *                      add to the game environment.
     */
    public void addCollidable(Collidable newCollidable) {
        this.collidables.add(newCollidable);
    }
    /**
     * The removeCollidable method removes a collidable from the environment.
     * @param collidableToDelete the collidable we want to delete.
     */
    public void removeCollidable(Collidable collidableToDelete) {
        this.collidables.remove(collidableToDelete);
    }
    /**
     * the getClosestCollision method find the closest collision and return his info.
     * @param trajectory is a line of the path the ball move.
     * @param hitter the ball.
     * @param currentVelocity the current velocity of the ball.
     * @return the closest collision's info.
     */
    public CollisionInfo getClosestCollision(Line trajectory, Ball hitter, Velocity currentVelocity) {
        boolean flag = false;
        CollisionInfo theClosestCollision = null, equel = null;
        for (int i = 0;  i < this.collidables.size(); ++i) {
            Point collision = this.collidables.get(i).getCollisionPoint(trajectory, hitter);
            if (collision != null) {
                if (!trajectory.start().equals(collision)) {
                    if (!flag) {
                        theClosestCollision = new CollisionInfo(collision, this.collidables.get(i),
                                this.collidables.get(i).hit(hitter, collision, hitter.getVelocity()));
                        flag = true;
                    } else {
                        if (new Line(trajectory.start(), theClosestCollision.collisionPoint()).length()
                                > (new Line(trajectory.start(), collision).length())) {
                            theClosestCollision = new CollisionInfo(collision, this.collidables.get(i),
                                    this.collidables.get(i).hit(hitter, collision, hitter.getVelocity()));
                        } else if (theClosestCollision.collisionPoint().equals(collision)) {
                            equel = new CollisionInfo(collision, this.collidables.get(i),
                                    this.collidables.get(i).hit(hitter, collision, hitter.getVelocity()));
                        }
                    }
                }
            }
        }
        if ((equel != null) & (theClosestCollision != null)) {
            if (equel.collisionPoint().equals(theClosestCollision.collisionPoint())) {
                return new CollisionInfo(theClosestCollision.collisionPoint(),
                        theClosestCollision.collisionObject(),
                        new Velocity(currentVelocity.getDx() * (-1),
                                currentVelocity.getDy() * (-1)));
            }
        }
        return theClosestCollision;
    }
    /**
     * the getSize method return the collidables list's size.
     * @return the collidables list's size.
     */
    public int getSize() {
        return this.collidables.size();
    }
}
