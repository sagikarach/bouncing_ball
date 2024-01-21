// Sagi Karach 206863888.
package theGame.ElementsInTheGame.shape;
import biuoop.DrawSurface;
import theGame.ElementsInTheGame.Ball;
import theGame.interfaces.Sprite;

/**
 * the Rectangle class hold the data on a rectangle,
 * and find out if the ball is going to hit him.
 */
public class Rectangle implements Sprite {
    private static final int UP_LEFT_CORNER = 1, UP_RIGHT_CORNER = 2,
            DOWN_LEFT_CORNER = 3, DOWN_RIGHT_CORNER = 4, NO_INTERSECTION = 0;
    private Point upperLeft;
    private double width, height;
    private java.awt.Color color;
    /**
     * the Rectangle method is a builder that create rectangle according
     * to his up and left point, his width and height.
     * @param upperLeft is the up and left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height)  {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }
    /**
     * the Rectangle method is a builder that create rectangle according
     * to his up and left point, his width and height.
     * @param upperLeft is the up and left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     * @param color is the rectangle's color.
     */
    public Rectangle(Point upperLeft, double width, double height,
                     java.awt.Color color) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /**
     * the intersectionPoints method find and return all the intersection
     * points of the ball with the border of the rectangle.
     * @param line the line that connect the present location of the ball,
     *             and his location after he will move.
     * @param hitter is the ball.
     * @return return a list of points that the ball will intersect with the rectangle.
     */
    public java.util.List<Point> intersectionPoints(Line line, Ball hitter) {
        java.util.List<Point> intersections = new java.util.ArrayList<>();
        intersections.addAll(this.findIntersectionWithTheSides(line, hitter));
        intersections.addAll(this.findIntersectionWithTheCorners(line, hitter));
        // return all the interactions that the ball will have with the rectangle.
        return intersections;
    }
    /**
     * the findIntersectionWithTheSides methods find the intersection point of the
     * ball with the sides of the rectangle.
     * @param line the line that connect the present location of the ball, and his
     *             location after he will move.
     * @param hitter the ball that hit the rectangle.
     * @return a list of intersection points with the sides of the rectangle.
     */
    private java.util.List<Point> findIntersectionWithTheSides(Line line, Ball hitter) {
        java.util.List<Point> intersections = new java.util.ArrayList<>();
        double r = hitter.getSize();
        Point intersection;
        // find intersection with the up line of the rectangle.
        intersection = new Line(this.upperLeft.getX(), this.upperLeft.getY() - r,
                this.upperLeft.getX() + this.width, this.upperLeft.getY() - r)
                .intersectionWith(line);
        if ((intersection != null) & (hitter.getY() < this.upperLeft.getY())) {
            intersections.add(intersection);
        }
        // find intersection with the down line of the rectangle.
        intersection = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height + r,
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height + r)
                .intersectionWith(line);
        if ((intersection != null) & (hitter.getY() > this.upperLeft.getY() + this.height)) {
            intersections.add(intersection);
        }
        // find intersection with the right line of the rectangle.
        intersection = new Line(this.upperLeft.getX() + this.width + r, this.upperLeft.getY(),
                this.upperLeft.getX() + this.width + r, this.upperLeft.getY() + this.height)
                .intersectionWith(line);
        if ((intersection != null) & (hitter.getX() > this.upperLeft.getX() + this.width)) {
            intersections.add(intersection);
        }
        // find intersection with the left line of the rectangle.
        intersection = new Line(this.upperLeft.getX() - r, this.upperLeft.getY(),
                this.upperLeft.getX() - r, this.upperLeft.getY() + this.height)
                .intersectionWith(line);
        if ((intersection != null) & (hitter.getY() < this.upperLeft.getY())) {
            intersections.add(intersection);
        }
        return intersections;
    }
    /**
     * the findIntersectionWithTheCorners method find the intersection point of the
     * ball with the corners of the rectangle.
     * @param line the line that connect the present location of the ball, and his location
     *             after he will move.
     * @param hitter the ball that hit the rectangle.
     * @return a list of intersection points with the corners of the rectangle.
     */
    private java.util.List<Point> findIntersectionWithTheCorners(Line line, Ball hitter) {
        java.util.List<Point> intersections = new java.util.ArrayList<>();
        double r = hitter.getSize();
        switch (checkWhichCornerCollided(line, r)) {
            case UP_LEFT_CORNER ->
                // add the point that corner of the ball only touch the corner.
                    intersections.add(new Point(this.upperLeft.getX()
                            - (r / new Line(this.upperLeft, line.end()).length()
                            * (this.upperLeft.getX() - line.end().getX())),
                            this.upperLeft.getY() - (r / new Line(this.upperLeft, line.end()).length()
                                    * (this.upperLeft.getY() - line.end().getY()))));
            case UP_RIGHT_CORNER ->
                // add the point that corner of the ball only touch the corner.
                    intersections.add(new Point(this.upperLeft.getX() + this.width
                            + (r / new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
                            line.end().getX(), line.end().getY()).length()
                            * (line.end().getX() - this.upperLeft.getX() - this.width)),
                            this.upperLeft.getY() - (r / new Line(this.upperLeft.getX() + this.width,
                                    this.upperLeft.getY(), line.end().getX(), line.end().getY()).length()
                                    * (this.upperLeft.getY() - line.end().getY()))));
            case DOWN_LEFT_CORNER ->
                // add the point that corner of the ball only touch the corner.
                    intersections.add(new Point(this.upperLeft.getX() + (r / new Line(
                            this.upperLeft.getX(), this.upperLeft.getY()
                            + this.height, line.end().getX(), line.end().getY()).length()
                            * (line.end().getX() - this.upperLeft.getX())),
                            this.upperLeft.getY() + this.height + (r / new Line(
                                    this.upperLeft.getX(), this.upperLeft.getY()
                                    + this.height, line.end().getX(), line.end().getY()).length()
                                    * (line.end().getY() - this.upperLeft.getY() - this.height))));
            case DOWN_RIGHT_CORNER ->
                // add the point that corner of the ball only touch the corner.
                    intersections.add(new Point(this.upperLeft.getX() + this.width + (r / new Line(
                            this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height,
                            line.end().getX(), line.end().getY()).length() * (line.end().getX()
                            - this.upperLeft.getX() - this.width)),
                            this.upperLeft.getY() + this.height + (r / new Line(this.upperLeft.getX()
                                    + this.width, this.upperLeft.getY() + this.height, line.end().getX(),
                                    line.end().getY()).length() * (line.end().getY() - this.upperLeft.getY()
                                    - this.height))));
            default -> {
            }
        }
        return intersections;
    }
    /**
     * the checkWhichCornerCollided method fid out which corner of the rectangle the ball hits.
     * @param line the line that connect the present location of the ball, and his location
     *             after he will move.
     * @param r the radios of the ball.
     * @return an integer that represent which of the corners been hit.
     */
    private int checkWhichCornerCollided(Line line, double r) {
        // find intersection with the up and left corner of the rectangle.
        if (new Line(this.upperLeft, line.end()).length() <= Math.sqrt(r * r / 2)) {
            return UP_LEFT_CORNER;
        // find intersection with the up and right corner of the rectangle.
        } else if (new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
            line.end().getX(), line.end().getY()).length() <= Math.sqrt(r * r / 2)) {
            return UP_RIGHT_CORNER;
        // find intersection with the down and left corner of the rectangle.
        } else if (new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
            line.end().getX(), line.end().getY()).length() <= Math.sqrt(r * r / 2)) {
            return DOWN_LEFT_CORNER;
        // find intersection with the down and right corner of the rectangle.
        } else if (new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height,
                line.end().getX(), line.end().getY()).length() <= Math.sqrt(r * r / 2)) {
            return DOWN_RIGHT_CORNER;
        }
        return NO_INTERSECTION;
    }
    /**
     * the checkIfTheBallWillHitUpOrDownBorder method check if the collision point
     * is in the up or down border of the rectangle.
     * @param collisionPoint is the point which the ball will hit the rectangle.
     * @param r is the radios of the ball how will hit the rectangle.
     * @return true if the collision point is in the up or down border of the rectangle.
     */
    public boolean checkIfTheBallWillHitUpOrDownBorder(
            Point collisionPoint, double r) {
        // find out if the ball will hit the up or down of the rectangle.
        return ((new Line(this.upperLeft.getX(), this.upperLeft.getY() - r,
                this.upperLeft.getX(), this.upperLeft.getY() - Math.sqrt(r * r / 2))
                .checkIfTheIntersectionYInTheLine(collisionPoint.getY()))
                | (new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height + r,
                this.upperLeft.getX(), this.upperLeft.getY() + this.height + Math.sqrt(r * r / 2))
                .checkIfTheIntersectionYInTheLine(collisionPoint.getY()))
                & (new Line(this.upperLeft.getX() - Math.sqrt(r * r / 2), this.upperLeft.getY(),
                this.upperLeft.getX() + this.width + Math.sqrt(r * r / 2), this.upperLeft.getY())
                .checkIfTheIntersectionXInTheLine(collisionPoint.getX())));
    }
    /**
     * the checkIfTheBallWillHitACorner method check if the intersection point of the ball
     * with the rectangle occur at a corner.
     * @param collisionPoint the point that the ball hit the rectangle.
     * @param r the radios of the ball how hit the rectangle.
     * @return true if the ball hit the rectangle at a corner, and false is he don't.
     */
    public boolean checkIfTheBallWillHitACorner(Point collisionPoint, double r) {
        return (((Math.abs(collisionPoint.getX() - this.upperLeft.getX() - this.width
                - Math.sqrt(r * r / 2)) < 0.0000001)
                & (Math.abs(collisionPoint.getY() - this.upperLeft.getY() - this.height
                - Math.sqrt(r * r / 2)) < 0.0000001))
                | ((Math.abs(collisionPoint.getX() - this.upperLeft.getX() - this.width
                - Math.sqrt(r * r / 2)) < 0.0000001)
                & (Math.abs(collisionPoint.getY() - this.upperLeft.getY()
                + Math.sqrt(r * r / 2)) < 0.0000001))
                | ((Math.abs(collisionPoint.getX() - this.upperLeft.getX()
                + Math.sqrt(r * r / 2)) < 0.0000001)
                & (Math.abs(collisionPoint.getY() - this.upperLeft.getY() - this.height
                - Math.sqrt(r * r / 2)) < 0.0000001))
                | ((Math.abs(collisionPoint.getX() - this.upperLeft.getX()
                + Math.sqrt(r * r / 2)) < 0.0000001)
                & (Math.abs(collisionPoint.getY() - this.upperLeft.getY()
                + Math.sqrt(r * r / 2)) < 0.0000001)));
    }
    /**
     * the getWidth method return the rectangle's width.
     * @return the rectangle's width.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * the getHeight method return the rectangle's height.
     * @return the rectangle's height.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * the getUpperLeft method return the rectangle's up and left corner.
     * @return the rectangle's up and left corner.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * The drawOn method print the rectangle in the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
    }
    /**
     * The timePassed method tell the rectangle object that time has passed.
     */
    public void timePassed() {

    }
}
