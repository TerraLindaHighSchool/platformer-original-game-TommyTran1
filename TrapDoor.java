import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrapDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrapDoor extends Obstacle
{ private float yVelocity;
    private final float GRAVITY;

    public TrapDoor(float gravity)
    {
        GRAVITY = gravity;
    }

    /**
     * Act - do whatever the Trapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {}

    protected void fall()
    {}

}