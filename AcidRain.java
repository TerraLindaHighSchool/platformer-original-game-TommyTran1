import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AcidRain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AcidRain extends Obstacle
{
    private float yVelocity;
    private final float GRAVITY;

    public AcidRain(float gravity)
    {
        GRAVITY = gravity;
    }

    /**
     * Act - do whatever the AcidRain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fall();
    }

    protected void fall()
    {
        if(!isOnGround())
        {
            yVelocity += GRAVITY;
            setLocation(getX(), getY() + (int) yVelocity);
            removeOutOfBounds(this);
        }
        if(isOnGround())
        {
            getWorld().removeObject(this);
        }
    }
}

