import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level2 extends World

{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level3.class; 
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
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
        addObject(new Door(), 1177,221);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 70, 760);
        addObject(new Floor(), 600, 800);
        TrapDoor trapDoor = new TrapDoor(GRAVITY);
        addObject(trapDoor,1144,611);
        HealthUp healthUp = new HealthUp();
        addObject(healthUp,1153,557);
        TrapDoor trapDoor2 = new TrapDoor(GRAVITY);
        addObject(trapDoor2,71,632);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,72,454);
        Powerup powerup = new Powerup();
        addObject(powerup,68,590);
        removeObject(powerup);
        Gem gem = new Gem();
        addObject(gem,68,588);
        HealthUp healthUp2 = new HealthUp();
        addObject(healthUp2,76,405);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,715,77);
        TrapDoor trapDoor3 = new TrapDoor(GRAVITY);
        addObject(trapDoor3,1139,165);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,1020,163);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,929,163);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,589,305);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,606,530);
        TrapDoor trapDoor4 = new TrapDoor(GRAVITY);
        addObject(trapDoor4,920,447);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,377,601);
        Bomb bomb2 = new Bomb(GRAVITY);
        addObject(bomb2,939,697);
        Bomb bomb3 = new Bomb(GRAVITY);
        addObject(bomb3,1182,722);
        Bomb bomb4 = new Bomb(GRAVITY);
        addObject(bomb4,295,748);
        Feather feather = new Feather();
        addObject(feather,95,97);
        Bomb bomb5 = new Bomb(GRAVITY);
        addObject(bomb5,664,23);
        TrapDoor trapDoor5 = new TrapDoor(GRAVITY);
        addObject(trapDoor5,415,224);;
        SmBrickWall smBrickWall9 = new SmBrickWall();
        addObject(smBrickWall9,377,423);
        HealthUp healthUp3 = new HealthUp();
        addObject(healthUp3,779,700);
    }

    private void spawn() 
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), 0);
        }

        if(Math.random() < 0.005)
        {
            addObject(new MeteorDown(GRAVITY), Greenfoot.getRandomNumber(1200), 0);
        }
        
        if(Math.random() < 0.005)
        {
            addObject(new MeteorSide(GRAVITY), 0, Greenfoot.getRandomNumber(800));
        }
    }
}
