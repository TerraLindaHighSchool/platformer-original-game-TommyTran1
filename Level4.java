import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level4 extends World

{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final boolean DOUBLE_JUMP = true;
    private final Class NEXT_LEVEL = Level5.class; 
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level4()
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
        addObject(new Door(), 28,147);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 70, 760);
        addObject(new Floor(), 600, 800);

        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,59,202);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,435,670);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,927,556);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,753,387);
        TrapDoor trapDoor = new TrapDoor(GRAVITY);
        addObject(trapDoor,1096,389);
        TrapDoor trapDoor2 = new TrapDoor(GRAVITY);
        addObject(trapDoor2,260,394);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,569,106);
        Bomb bomb = new Bomb(GRAVITY);
        addObject(bomb,901,288);
        Bomb bomb2 = new Bomb(GRAVITY);
        addObject(bomb2,884,702);
        Bomb bomb3 = new Bomb(GRAVITY);
        addObject(bomb3,253,289);
        Dust dust = new Dust(GRAVITY);
        addObject(dust,684,648);
        Dust dust2 = new Dust(GRAVITY);
        addObject(dust2,899,142);
    }

    private void spawn() 
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }

        if(Math.random() < 0.005)
        {
            addObject(new Bat(GRAVITY), 25, Greenfoot.getRandomNumber(700) + 100);
        }
        
        if(Math.random() < 0.004)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
