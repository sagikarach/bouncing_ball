// Sagi Karach 206863888.
package theGame.ElementsInTheGame.shape;

/**
 * the Point class create a variable that his name is point,
 * with his location's value in the board with x and y parameters,
 * x reparent the horizontal location, y reparent the vertical location.
 */
public class Point {
    private double x, y;
    /**
     * the Point function is a builder of the point variable.
     * @param x is a number how represent the horizontal location of the point in the board.
     * @param y is a number how represent the vertical location of the point in the board.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the distance function find the distance between the current point and other point,
     * and return his value.
     * @param other is another point, that the user want to find out what is the distance
     *             between her and the current point.
     * @return the distance function return the distance between this two points.
     */
    public double distance(Point other) {
        // check if this two points is the same point.
        if (other.equals(new Point(this.x, this.y))) {
            return 0;
        }
        // calculate the distance between this two points.
        return Math.sqrt((this.x - other.getX()) * (this.x - other.getX())
                + (this.y - other.getY()) * (this.y - other.getY()));
    }

    /**
     * the equals function check if the current point is identical to other point.
     * @param other other point that the user want to check if the current point is identical to her.
     * @return the function return true if the current point is identical to the other point,
     * and false if she isn't.
     */
    public boolean equals(Point other) {
        return ((Math.abs(this.x - other.getX()) < 0.001)
                & ((Math.abs(this.y - other.getY())) < 0.001));
    }

    /**
     * the function getX return the horizontal location of the current point.
     * @return the function return the horizontal location of the current point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * the function getX return the vertical location of the current point.
     * @return the function return the vertical location of the current point.
     */
    public double getY() {
        return this.y;
    }
}