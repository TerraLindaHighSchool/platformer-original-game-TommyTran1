import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dust extends Obstacle
{

    private int frame;
    private int windIndex;
    private float yVelocity;
    private final float GRAVITY;
    private final GreenfootImage[] WIND_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;

    public Dust(float gravity)
    {
        GRAVITY = gravity;
        STANDING_IMAGE = getImage();
        WIND_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("wind1.png"),
            new GreenfootImage("wind2.png"),
            new GreenfootImage("wind3.png"),
            new GreenfootImage("wind4.png"),
            new GreenfootImage("wind5.png"),
            new GreenfootImage("wind6.png"),
            new GreenfootImage("wind7.png"),
            new GreenfootImage("wind8.png"),
            new GreenfootImage("wind9.png"),

        };
    }

    /**
     * Act - do whatever the Dust wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        activation();
    }

    public void activation()
    {
        animator();
    }

    public void animator()
    {
        if(frame % (9) == 0)
        {
            if(windIndex < WIND_ANIMATION.length)
            {
                setImage(WIND_ANIMATION[windIndex]);
                windIndex++;
            }
            else
            {
                windIndex = 0;
            }
        }
        frame++;
    }

    protected void fall()
    {
    }
}
