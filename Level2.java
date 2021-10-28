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
    private final Class NEXT_LEVEL = WinSplash.class; 
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
        addObject(player, 70, 700);
        addObject(new Floor(), 600, 800);
        TrapDoor trapDoor = new TrapDoor(3);
        addObject(trapDoor,1140,436);
        HealthUp healthUp = new HealthUp();
        addObject(healthUp,1149,397);
        TrapDoor trapDoor2 = new TrapDoor(3);
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
        TrapDoor trapDoor3 = new TrapDoor(3);
        addObject(trapDoor3,1139,165);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,1020,163);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,929,163);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,741,318);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,741,533);
        TrapDoor trapDoor4 = new TrapDoor(3);
        addObject(trapDoor4,920,447);
        smBrickWall7.setLocation(606,530);
        smBrickWall6.setLocation(589,305);
        trapDoor.setLocation(1144,611);
        healthUp.setLocation(1153,557);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,377,601);
        Bomb bomb = new Bomb(3);
        addObject(bomb,381,539);
        Bomb bomb2 = new Bomb(3);
        addObject(bomb2,939,697);
        Bomb bomb3 = new Bomb(3);
        addObject(bomb3,1182,722);
        Bomb bomb4 = new Bomb(3);
        addObject(bomb4,295,748);
        Feather feather = new Feather();
        addObject(feather,95,97);
        Bomb bomb5 = new Bomb(3);
        addObject(bomb5,664,23);
        TrapDoor trapDoor5 = new TrapDoor(3);
        addObject(trapDoor5,415,224);;
    }

    private void spawn() 
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }

        if(Math.random() < 0.001)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
