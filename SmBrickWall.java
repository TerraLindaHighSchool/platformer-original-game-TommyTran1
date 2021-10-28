import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmBrickWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmBrickWall extends Platforms
{
    /**
     * Act - do whatever the SmBrickWall wants to do. This method is called whenever
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
            setImage("marsBrick.png");
        }
        
        if (Level5.class.isInstance(getWorld()))
        {
            setImage("depthBrick.png");
        }
    }
}
