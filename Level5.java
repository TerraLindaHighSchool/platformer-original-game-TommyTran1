import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level5 extends World

{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final boolean DOUBLE_JUMP = true;
    private final Class NEXT_LEVEL = WinSplash.class; 
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level5()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }

    public void act()
    {
        spawn();    
    }

    private void  prepare()
    {
        setPaintOrder(Player.class, Platforms.class, Obstacle.class, Collectables.class,
            Door.class, HUD.class);
        addObject(new Door(), 1007,543);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 70, 600);
        addObject(new Floor(), 600, 800);
        Lava lava = new Lava(GRAVITY);
        addObject(lava,888,317);
        Lava lava2 = new Lava(GRAVITY);
        addObject(lava2,380,316);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,85,658);
        TrapDoor trapDoor = new TrapDoor(GRAVITY);
        addObject(trapDoor,242,310);
        TrapDoor trapDoor2 = new TrapDoor(GRAVITY);
        addObject(trapDoor2,81,151);
        TrapDoor trapDoor3 = new TrapDoor(GRAVITY);
        addObject(trapDoor3,567,581);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,316,507);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,635,139);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,85,310);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,1038,142);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,1001,582);
        TrapDoor trapDoor4 = new TrapDoor(GRAVITY);
        addObject(trapDoor4,750,387);
        Gem gem = new Gem();
        addObject(gem,88,103);
        Gem gem2 = new Gem();
        addObject(gem2,238,242);

    }

    private void spawn() 
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }

        if(Math.random() < 0.005)
        {
            addObject(new Bat(GRAVITY), 25, Greenfoot.getRandomNumber(600) + 150);
        }
    }
}
