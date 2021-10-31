import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MeteorSide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeteorDown extends Obstacle
{   private float yVelocity;
    private final float GRAVITY;

    public MeteorDown(float gravity)
    {
        GRAVITY = gravity;
    }

    /**
     * Act - do whatever the Trapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fall();
    }

    public void addedToWorld(World World)
    {
        turn(270);
    }

    protected void fall()
    {
        if(!isOnGround())
        {
            if(yVelocity < 3)
            {
                yVelocity += GRAVITY;
            }
            setLocation(getX(), getY() + (int) yVelocity);
        }
        
                if(isOnGround())
        {
            getWorld().removeObject(this);
        }
    }

}
