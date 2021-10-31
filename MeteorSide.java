import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MeteorDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeteorSide extends Obstacle
{ 
    private float yVelocity;
    private final float GRAVITY;

    public MeteorSide(float gravity)
    {
        GRAVITY = gravity;
    }

    /**
     * Act - do whatever the Trapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(3);
        collision();
    }

    public void addedToWorld(World world)
    {      
    }

    public void collision()
    {
        if(isOnGround())
        {
            getWorld().removeObject(this);
        }
    }

    protected void fall()
    {}

}
