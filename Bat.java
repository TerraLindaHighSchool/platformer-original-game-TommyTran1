import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Obstacle
{
  private int frame;
    private int batIndex;
    private float yVelocity;
    private final float GRAVITY;
    private final GreenfootImage[] BAT_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    

    public Bat(float gravity)
    {
        GRAVITY = gravity;
        STANDING_IMAGE = getImage();
        BAT_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("bat1.png"),
            new GreenfootImage("bat2.png"),
            new GreenfootImage("bat3.png"),
            new GreenfootImage("bat4.png"),
            new GreenfootImage("bat5.png"),
            new GreenfootImage("bat6.png"),
            new GreenfootImage("bat7.png"),
            new GreenfootImage("bat8.png"),

        };
    }

    /**
     * Act - do whatever the Trapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        activation();
    }

    public void activation()
    {
        animator();
        collision();
        move(3);
    }
    
        public void collision()
    {
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void animator()
    {
        if(frame % (8) == 0)
        {
            if(batIndex < BAT_ANIMATION.length)
            {
                setImage(BAT_ANIMATION[batIndex]);
                batIndex++;
            }
            else
            {
                batIndex = 0;
            }
        }
        frame++;
    }

    protected void fall()
    {}

}

