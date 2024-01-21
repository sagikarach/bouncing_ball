// Sagi Karach 206863888.
package theGame.ElementsInTheGame.DataKeepers;
/**
 * The Counter class create an object how can count,
 * by using an increase method and a decrease method.
 */
public class Counter {
    private int counter;
    /**
     * The Counter method is a builder, that create a
     * counter object.
     * @param counter an integer number that from him the
     *                counter start to count.
     */
    public Counter(int counter) {
        this.counter = counter;
    }
    /**
     * The increase method adds a number from the counter.
     * @param number an integer number that we want to add
     *               to the counter.
     */
    public void increase(int number) {
        this.counter += number;
    }
    /**
     * The decrease method removes a number from the counter.
     * @param number an integer number that we want to remove
     *               to the counter.
     */
    public void decrease(int number) {
        this.counter -= number;
    }
    /**
     * The getValue method return the count of the counter.
     * @return an integer number how is the count of the counter.
     */
    public int getValue() {
        return this.counter;
    }
}
