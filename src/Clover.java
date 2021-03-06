/**
 * Behavior implementation for Clover.
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
import java.lang.Math;

public class Clover extends PowerItems {

    public Clover(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
    }

    protected double curveX(double f) {
        return f;
    }

    protected double curveY(double f) {
        return Math.sin(4 * f);
    }

    protected void checkHitAvatar() {
        final Avatar avatar = (Avatar) getOneIntersectingObject(Avatar.class);
        if (avatar != null) {
            BadgeCenter.getInstance().hitClover();
            avatar.sayWoot();
            avatar.lagControls();
            getWorld().removeObject(this);
        }
    }
}