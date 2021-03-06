import greenfoot.*;

/**
 * Enimies. The sheer evil of the smiley-faced villians is enought to crack the
 * bones of our skull-faced hero so you must avoid their touch at all cost.
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class Enemy extends Actor {
    private int timeToChange = 1;
    private int speed = 1;
    private boolean isHappy = false;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setLocation(getX(), getY() + speed);
        if (!isHappy)
            changeDisposition();
        checkRemove();
    }

    /**
     * Checks is the enemy behinde the scene and remove it
     */
    public void checkRemove() {
        World world = getWorld();
        if (getY() > world.getHeight() + 30) {
            world.removeObject(this);
        }
    }

    /**
     * Set speed for the enemy
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void beHappy() {
        isHappy = true;
        setImage("smiley2.png");
    }

    public void changeDisposition() {
        final int ypos = getY();
        final int worldHeight = getWorld().getHeight();
        final int marker1 = (int) (worldHeight * 0.5);
        final int marker2 = (int) (worldHeight * 0.75);
        final int marker3 = (int) (worldHeight * 0.90);
        if (timeToChange == 1 && ypos > marker1) {
            setImage("smiley4.png");
            timeToChange = timeToChange + 1;
        } else if (timeToChange == 2 && ypos > marker2) {
            setImage("smiley3.png");
            timeToChange = timeToChange + 1;
        } else if (timeToChange == 3 && ypos > marker3) {
            setImage("smiley5.png");
            timeToChange = timeToChange + 1;
        }
    }
}
