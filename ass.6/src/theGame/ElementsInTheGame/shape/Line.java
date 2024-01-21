// Sagi Karach 206863888.
package theGame.ElementsInTheGame.shape;
import biuoop.DrawSurface;
import theGame.ElementsInTheGame.DataKeepers.LineEquation;
import theGame.ElementsInTheGame.Ball;
import theGame.interfaces.Sprite;
import java.awt.*;
/**
 * the Line class create a variable that his name is line,
 * with his location in the board that represented by his start point
 * and his end point.
 */
public class Line implements Sprite {
    private Point start, end;
    private LineEquation lineEquation;
    private Color color;
    /**
     * the Line function is a builder of the line variable.
     * @param start is the start point of the line.
     * @param end   is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.lineEquation = new LineEquation(start, end);
    }
    /**
     * the Line function is a builder of the line variable.
     * @param start is the start point of the line.
     * @param end   is the end point of the line.
     * @param color is the line's color.
     */
    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.lineEquation = new LineEquation(start, end);
        this.color = color;
    }
    /**
     * the Line function is a builder of the line variable.
     * @param x1 is the start point of the line's horizontal location.
     * @param y1 is the start point of the line's vertical location.
     * @param x2 is the end point of the line's horizontal location.
     * @param y2 is the end point of the line's vertical location.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    /**
     * the Line function is a builder of the line variable.
     * @param x1 is the start point of the line's horizontal location.
     * @param y1 is the start point of the line's vertical location.
     * @param x2 is the end point of the line's horizontal location.
     * @param y2 is the end point of the line's vertical location.
     * @param color is the line's color.
     */
    public Line(double x1, double y1, double x2, double y2, Color color) {
        this(new Point(x1, y1), new Point(x2, y2), color);
    }
    /**
     * the length function calculate the length of the current line, and return it.
     * @return the function return the value of the current line length.
     */
    public double length() {
        double side1 = Math.abs(this.start.getX() - this.end.getX()),
                side2 = Math.abs(this.start.getY() - this.end.getY());
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
    /**
     * the middle function calculate the middle point of the current line, and return it.
     * @return the function return the middle point of the current line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
    }
    /**
     * the start function return the current line's start point.
     * @return the function return the current line's start point.
     */
    public Point start() {
        return this.start;
    }
    /**
     * the start function return the current line's end point.
     * @return the function return the current line's end point.
     */
    public Point end() {
        return this.end;
    }
    /**
     * the function inCaseParallelToYLine will check if a line is interacting with
     * another line how is parallel to the y line.
     * @param otherLine       the line that the user want to check if he interacts
     *                        with the parallel line.
     * @return the function will return true if the lines interacts, and false if
     *         they aren't.
     */
    private boolean inCaseParallelToYLine(Line otherLine) {
        // in case the parallel line's start point is bigger then the end.
        if (this.start.getX() > this.end.getX()) {
            // check if the lines interacts.
            return ((((otherLine.start.getX() < this.start.getX())
                    & (otherLine.start.getX() > this.end.getX()))
                    | ((otherLine.end.getX() < this.start.getX())
                    & (otherLine.end.getX() > this.end.getX())))
                    & (((otherLine.start.getY() < this.start.getY())
                    & (otherLine.end.getY() > this.start.getY()))
                    | ((otherLine.start.getY() > this.start.getY())
                    & (otherLine.end.getY() < this.start.getY()))));

            // in case the parallel line's end point is bigger then the start.
        } else {
            // check if the lines interacts.
            return ((((otherLine.start.getX() < this.end.getX())
                    & (otherLine.start.getX() > this.start.getX()))
                    | ((otherLine.end.getX() < this.end.getX())
                    & (otherLine.end.getX() > this.start.getX())))
                    & (((otherLine.start.getY() < this.start.getY())
                    & (otherLine.start.getY() > this.end.getY()))
                    | ((otherLine.start.getY() > this.start.getY())
                    & (otherLine.start.getY() < this.end.getY()))));
        }
    }
    /**
     * the function checkIfTheIntersectionXInTheLine find if an X variable is in the line range.
     * @param xOfTheIntersection the X variable how the user want to check if he in the line's range.
     * @return the function true if the X variable is in the line's range, and false if he isn't.
     */
    public boolean checkIfTheIntersectionXInTheLine(double xOfTheIntersection) {
        if (this.start.getX() > this.end.getX()) {
            return ((xOfTheIntersection <= this.start.getX())
                    & (xOfTheIntersection >= this.end.getX()));
        } else {
            return ((xOfTheIntersection <= this.end.getX())
                    & (xOfTheIntersection >= this.start.getX()));
        }
    }
    /**
     * the function checkIfTheIntersectionYInTheLine find if an Y variable is in the line range.
     * @param yOfTheIntersection the Y variable how the user want to check if he in the line's range.
     * @return the function true if the Y variable is in the line's range, and false if he isn't.
     */
    public boolean checkIfTheIntersectionYInTheLine(double yOfTheIntersection) {
        if (this.start.getY() > this.end.getY()) {
            return ((yOfTheIntersection <= this.start.getY())
                    & (yOfTheIntersection >= this.end.getY()));
        } else {
            return ((yOfTheIntersection <= this.end.getY())
                    & (yOfTheIntersection >= this.start.getY()));
        }
    }
    /**
     * the function isIntersecting find out if the current line intersect with other line.
     * @param otherLine is the other line that the user want to check if the current line is interacting with.
     * @return the function return true if the current line and the other line interact,
     * and false if they aren't.
     */
    public boolean isIntersecting(Line otherLine) {
        double xOfTheIntersection;
        // in case one of the lines is parallel to the y line.
        if ((this.lineEquation == null) | (otherLine.lineEquation == null)) {
            // in case both of the lines are parallel to the y line.
            if ((this.lineEquation == null) & (otherLine.lineEquation == null)) {
                return (otherLine.checkIfTheIntersectionXInTheLine(this.start.getX())
                        | (otherLine.checkIfTheIntersectionXInTheLine(this.end.getX())));
            } else {
                if (this.lineEquation == null) {
                    return (this.inCaseParallelToYLine(otherLine));
                }
                return (otherLine.inCaseParallelToYLine(this));
            }
        }
        // in case both line's slope are the same.
        if (this.lineEquation.getSlide() == otherLine.lineEquation.getSlide()) {
            if (this.lineEquation.getIntersectionWithYLine()
                    == otherLine.lineEquation.getIntersectionWithYLine()) {
                return (otherLine.checkIfTheIntersectionXInTheLine(this.start.getX())
                        | otherLine.checkIfTheIntersectionXInTheLine(this.end.getX())
                        | this.checkIfTheIntersectionXInTheLine(otherLine.start.getX())
                        | this.checkIfTheIntersectionXInTheLine(otherLine.end.getX()));
            } else {
                return false;
            }
        }
        // found the point the two lines if interacts.
        Point inersectionPoint = this.lineEquation.findIntersectionOfTwoLinesEquations(otherLine.lineEquation);
        // check if the intersection point is in one of the line's range.
        return (this.checkIfTheIntersectionXInTheLine(inersectionPoint.getX()))
                & (otherLine.checkIfTheIntersectionXInTheLine(inersectionPoint.getX()));
    }
    /**
     * the function intersectionWith find out the current line and other line's interaction point.
     * @param otherLine is the other line that the user want to find is interaction point with the current line.
     * @return the interaction point of the current line and other line.
     */
    public Point intersectionWith(Line otherLine) {
        // in case one of the lines is parallel to the y line.
        if ((this.lineEquation.getParallelToYLine())
                | (otherLine.lineEquation.getParallelToYLine())) {
            // in case both of the lines are parallel to the y line.
            if ((this.lineEquation.getParallelToYLine())
                    & (otherLine.lineEquation.getParallelToYLine())) {
                if (this.end.equals(otherLine.start)) {
                    return this.end;
                }
                if (this.start.equals(otherLine.end)) {
                    return this.start;
                }
                return null;
            } else {
                if (this.lineEquation.getParallelToYLine()) {
                    return this.oneOfTheLinesIsParallelToYLine(otherLine);
                } else {
                    return otherLine.oneOfTheLinesIsParallelToYLine(this);
                }
            }
        }
        // in case both line's slope are the same.
        if (this.lineEquation.getSlide() == otherLine.lineEquation.getSlide()) {
            if (this.end.equals(otherLine.start)) {
                return this.end;
            }
            if (this.start.equals(otherLine.end)) {
                return this.start;
            }
            return null;
        }
        // found the point the two lines if interacts.
        Point intersectionPoint = this.lineEquation.
                findIntersectionOfTwoLinesEquations(otherLine.lineEquation);
        // check if the intersection point is in one of the line's range.
        if ((this.checkIfTheIntersectionXInTheLine(intersectionPoint.getX()))
                & (otherLine.checkIfTheIntersectionXInTheLine(intersectionPoint.getX()))) {
            return intersectionPoint;
        }
        return null;
    }

    /**
     * The oneOfTheLinesIsParallelToYLine method act when the current line
     * parallel to the Y line, and return the other line interaction with
     * the current line.
     * @param otherLine the other line that we want to find his intersection
     *                  with the current line.
     * @return the lines intersection point.
     */
    private Point oneOfTheLinesIsParallelToYLine(Line otherLine) {
        double yOfTheIntersection = (otherLine.lineEquation.getSlide() * this.start.getX())
                + otherLine.lineEquation.getIntersectionWithYLine();
        if ((this.checkIfTheIntersectionYInTheLine(yOfTheIntersection))
                & (otherLine.checkIfTheIntersectionYInTheLine(yOfTheIntersection))
                & (otherLine.checkIfTheIntersectionXInTheLine(this.start.getX()))) {
            return new Point(this.start.getX(), yOfTheIntersection);
        } else {
            return null;
        }
    }
    /**
     * the function equals find if the current line and other line is equal.
     * @param other is the other line that the user to find if he is identical to the current line.
     * @return the function return true if the two lines identical, and false if they aren't.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) & this.end.equals(other.end));
    }
    /**
     * the closestIntersectionToStartOfLine method find the line's closest
     * intersection point with a rectangle.
     * @param rect is the rectangle the lint intersect with.
     * @param hitter the ball how the move according to the line.
     * @return the closest point of intersection between the line and the rectangle.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect, Ball hitter) {
        java.util.List<Point> intersections = rect.intersectionPoints(this, hitter);
        Point theClosestIntersectionPoint = null;
        // find the first point of intersection.
        int i = 0;
        while  (i < intersections.size()) {
            if (intersections.get(i) != null) {
                theClosestIntersectionPoint = intersections.get(i);
                break;
            }
            i++;
        }
        if (theClosestIntersectionPoint != null) {
            for (int j = 1; j < intersections.size(); ++j) {
                if (intersections.get(j) != null) {
                    theClosestIntersectionPoint = findTheClosestPointToTheStartPoint(
                            theClosestIntersectionPoint, intersections.get(j));
                }
            }
        }
        return theClosestIntersectionPoint;
    }
    /**
     * the findTheClosestPointToTheStartPoint find the closest point to
     * the start of the line.
     * @param point1 the first point we want to check.
     * @param point2 the second point we want to check.
     * @return the closest point to the start of the line.
     */
    private Point findTheClosestPointToTheStartPoint(Point point1, Point point2) {
        Line line1 = new Line(this.start, point1);
        Line line2 = new Line(this.start, point2);
        if (line1.length() < line2.length()) {
            return point1;
        }
        return point2;
    }
    /**
     * The drawOn method print the line in the game's board.
     * @param d a pointer to the game's board.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(), (int) this.end.getY());
    }
    /**
     * The timePassed method tell the line object that time has passed.
     */
    public void timePassed() {
    }
}