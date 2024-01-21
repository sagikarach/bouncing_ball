// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
import theGame.ElementsInTheGame.shape.Point;
/**
 * The LineEquation class responsible for the line
 * equation object.
 */
public class LineEquation {
    private double slide, intersectionWithYLine;
    private boolean parallelToYLine;
    /**
     * The LineEquation is a constructor, how create a line
     * equation object according to tow points in the line.
     * @param point1 a point on the line.
     * @param point2 a point on the line.
     */
    public LineEquation(Point point1, Point point2) {
        if (point1.getX() != point2.getX()) {
            this.parallelToYLine = false;
            this.slide = this.findSlide(point1, point2);
            this.intersectionWithYLine = this
                    .findIntersectionWithYLine(point1);
        } else {
            // In case the line is parallel to the Y line.
            this.parallelToYLine = true;
        }
    }
    /**
     * The findSlide method find the line's slide, according
     * to two points on the line.
     * @param point1 a point on the line
     * @param point2 a point on the line
     * @return the line's slide.
     */
    private double findSlide(Point point1, Point point2) {
        return (point1.getY() - point2.getY())
                / (point1.getX() - point2.getX());
    }
    /**
     * The findIntersectionWithYLine method find the line's
     * intersection with the Y line, according to two points
     * on the line.
     * @param point a point on the line
     * @return the line's intersection with the Y line.
     */
    private double findIntersectionWithYLine(Point point) {
        return point.getY() - (this.slide * point.getX());
    }
    /**
     * The getSlide method return the line's slide.
     * @return the line's slide.
     */
    public double getSlide() {
        return this.slide;
    }
    /**
     * The getIntersectionWithYLine method return the line's
     * intersection with the Y line.
     * @return the line's intersection with the Y line.
     */
    public double getIntersectionWithYLine() {
        return this.intersectionWithYLine;
    }
    /**
     * The getParallelToYLine method return true if the line
     * is parallel to the Y line.
     * @return true if the line is parallel to the Y line.
     */
    public boolean getParallelToYLine() {
        return parallelToYLine;
    }
    /**
     * The findIntersectionOfTwoLinesEquations method find the
     * intersection of the current line with other line.
     * @param otherLineEquation the line equation of the other
     *                          line.
     * @return the intersection point of the two lines.
     */
    public Point findIntersectionOfTwoLinesEquations(
            LineEquation otherLineEquation) {
        // found the point the two lines if interacts.
        double xOfTheIntersection = (otherLineEquation.intersectionWithYLine
                - this.intersectionWithYLine)
                / (this.slide - otherLineEquation.slide);
        double yOfTheIntersection = (xOfTheIntersection * this.slide)
                + this.intersectionWithYLine;
        return new Point(xOfTheIntersection, yOfTheIntersection);
    }
}
