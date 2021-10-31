import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level3 extends World

{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final boolean DOUBLE_JUMP = true;
    private final Class NEXT_LEVEL = Level4.class; 
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
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
        addObject(new Door(), 728,19);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 70, 760);
        addObject(new Floor(), 600, 800);

        Spire spire = new Spire();
        addObject(spire,860,635);
        Spire spire2 = new Spire();
        addObject(spire2,538,355);
        TrapDoor trapDoor = new TrapDoor(3);
        addObject(trapDoor,464,538);
        TrapDoor trapDoor2 = new TrapDoor(3);
        addObject(trapDoor2,584,538);
        TrapDoor trapDoor3 = new TrapDoor(3);
        addObject(trapDoor3,611,537);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,119,568);
        Dust dust = new Dust(3);
        addObject(dust,725,588);
        Dust dust2 = new Dust(3);
        addObject(dust2,374,257);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,61,328);
        Gem gem = new Gem();
        addObject(gem,69,244);
        Gem gem2 = new Gem();
        addObject(gem2,536,584);
        Bomb bomb = new Bomb(3);
        addObject(bomb,421,665);
        Dust dust3 = new Dust(3);
        addObject(dust3,1062,586);
        HealthUp healthUp = new HealthUp();
        addObject(healthUp,1111,754);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,1120,501);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,718,87);
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
