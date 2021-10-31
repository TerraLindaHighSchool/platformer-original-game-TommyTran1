import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lava here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lava extends Obstacle
{
    private int frame;
    private int lavaIndex;
    private float yVelocity;
    private final float GRAVITY;
    private final GreenfootImage[] LAVA_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    

    public Lava(float gravity)
    {
        GRAVITY = gravity;
        STANDING_IMAGE = getImage();
        LAVA_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("lava1.png"),
            new GreenfootImage("lava2.png"),
            new GreenfootImage("lava3.png"),
            new GreenfootImage("lava4.png"),
            new GreenfootImage("lava5.png"),
            new GreenfootImage("lava6.png"),
            new GreenfootImage("lava7.png"),
            new GreenfootImage("lava8.png"),
            new GreenfootImage("lava9.png"),
            new GreenfootImage("lava10.png"),
            new GreenfootImage("lava11.png"),
            new GreenfootImage("lava12.png"),
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
    }
    public void animator()
    {
        if(frame % (8) == 0)
        {
            if(lavaIndex < LAVA_ANIMATION.length)
            {
                setImage(LAVA_ANIMATION[lavaIndex]);
                lavaIndex++;
            }
            else
            {
                lavaIndex = 0;
            }
        }
        frame++;
    }

    protected void fall()
    {}

}
