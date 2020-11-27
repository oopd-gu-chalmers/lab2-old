/** Represents the function of being able to move.
 * Has one method for moving forwards, and two methods for turning left and respectively right.
 *
 */

public interface Movable {
    void move();
    void turnLeft(int angle);
    void turnRight(int angle);
}
