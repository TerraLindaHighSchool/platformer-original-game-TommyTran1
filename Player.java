import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Health[] health;
    private Powerup[] powerup;
    private int healthCount;
    private int speed;
    private int walkIndex;
    private int frame;
    private float yVelocity;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private int numJumps;
    private final int MAX_JUMPS = 2;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    private final float JUMP_FORCE;
    private final float GRAVITY;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    private final boolean DOUBLE_JUMP = true;

    public Player (int speed, float jumpForce, float gravity, int maxHealth,int maxPowerup,
    Class nextLevel, GreenfootSound music)
    {
        this.speed = speed;
        JUMP_FORCE = jumpForce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        MUSIC = music;
        healthCount = 3;
        health = new Health[healthCount];

        STANDING_IMAGE = getImage();
        WALK_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("walk0.png"),
            new GreenfootImage("walk1.png"),
            new GreenfootImage("walk2.png"),
            new GreenfootImage("walk3.png"),
            new GreenfootImage("walk4.png"),
            new GreenfootImage("walk5.png"),
        };
    }

    boolean doubleJump = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
        jump();
        fall();
        onCollision();
        gameOver();
    }

    public void addedToWorld(World world)
    {   
        {  
            if (Level3.class.isInstance(getWorld()) || Level4.class.isInstance(getWorld()) || Level5.class.isInstance(getWorld()))
            {
                doubleJump = true;
            }
            for(int i = 0; i < health.length; i++)
            {
                health[i] = new Health();
                world.addObject(health[i], 30 + 42 * i, 36);
            }
        }
    }

    public void walk() 
    {
        if(isWalking) {
            animator();
        }
        else 
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }

        if(Greenfoot.isKeyDown("right"))
        {
            if(!MUSIC.isPlaying())
            {
                MUSIC.playLoop();
            }
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = false;
            isWalking = true;
            move(speed);

        }

        if(Greenfoot.isKeyDown("left"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = true;
            isWalking = true;
            move(-speed);
        }

        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")))
        {
            isWalking = false;
        }

    }

    public void jump()
    {
        if(isOnGround() ) 
        {
            numJumps = 0;
        }
        if(Greenfoot.isKeyDown("space") && isOnGround())
        {
            isJumping = true;
            yVelocity = JUMP_FORCE;
            Greenfoot.playSound("jump.wav");
            if(numJumps < 2)
            {
                numJumps += 1;
            }
        }

        if((Greenfoot.isKeyDown("space") && (doubleJump == true)) && (numJumps < 2))
        {
            isJumping = true;
            yVelocity += (JUMP_FORCE/4);
            Greenfoot.playSound("jump.wav");
            if(numJumps < 2)
            {
                numJumps += 1;
            }
        }

        if(isJumping && yVelocity > 0.0)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;
        }
    }

    public void fall()
    {
        if(!isOnGround() && !isJumping)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }

    }

    public void animator()
    {
        if(frame % (15 - 2 * speed) == 0)
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }
    int cooldown = 0;
    public void onCollision() 
    {
        if(cooldown > 0) 
        {
            cooldown -= 1;
        }

        if(isTouching(Door.class))
        {
            World world = null;
            try 
            {
                world = (World) NEXT_LEVEL.newInstance();
            }   
            catch (InstantiationException e) 
            {
                System.out.println("Class cannot be instantiated");
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access class constructor");
            } 
            Greenfoot.playSound("door_open.wav");
            MUSIC.stop();
            Greenfoot.setWorld(world);
        }

        if(isTouching(Collectables.class))
        {
            if(isTouching(Feather.class))
            {
                removeTouching(Feather.class);
                doubleJump = true;
            }
            if(isTouching(HealthUp.class))
            {

            }
            removeTouching(Collectables.class);
            Greenfoot.playSound("collectable.wav");

        }

        if(isTouching(Floor.class) && Level5.class.isInstance(getWorld()))
        {
            getWorld().removeObject(health[healthCount - 1]);
            healthCount--;
        }

        if(isTouching(Obstacle.class))
        {
            if(!(isTouching(TrapDoor.class)))
            {
                if(isTouching(Bomb.class))
                {
                    Greenfoot.playSound("explosionSmall.wav");
                }
                if(isTouching(TrapDoor.class))
                {
                }
                removeTouching(Obstacle.class);
                getWorld().removeObject(health[healthCount - 1]);
                healthCount--;
            }

        }

        if(isTouching(TrapDoor.class))
        {
            if (cooldown == 0)
            {
                cooldown = 60; 
                Greenfoot.playSound("creak.mp3");  
            }
        }

        if(isTouching(Platforms.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }

    }

    public void mirrorImages()
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
            WALK_ANIMATION[i].mirrorHorizontally();
        }
    }

    public void gameOver() 
    {
        if(healthCount == 0)
        {
            Greenfoot.setWorld(new Level1());
        }
    }

    public boolean isOnGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 
                2, Platforms.class);
        return ground != null;
    }
}
