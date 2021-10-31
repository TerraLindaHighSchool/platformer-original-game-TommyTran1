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
    {
        level();
    }
    
    public void level()
    {
        if (Level2.class.isInstance(getWorld()))
        {
            setImage("depthBrick.png");
        }
        
                if (Level3.class.isInstance(getWorld()) || Level4.class.isInstance
        (getWorld()))
        {
            setImage("marsBrick.png");
        }
        
        if (Level5.class.isInstance(getWorld()))
        {
            setImage("depthBrick.png");
        }
    }

    protected void fall()
    {}

}
