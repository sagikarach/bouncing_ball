// Sagi Karach 206863888.
package theGame.interfaces;
/**
 * the HitNotifier interface is a type of notifier, that notify
 * a listener to activate him.
 */
public interface HitNotifier {
    /**
     * the addHitListener method adding the notifier a listener
     * that he needs to notify.
     * @param hl a new listener to notify.
     */
    void addHitListener(HitListener hl);
    /**
     * the removeHitListener method deleting a listener that the
     * notifier needed to notify.
     * @param hl the listener that need to delete.
     */
    void removeHitListener(HitListener hl);
}
