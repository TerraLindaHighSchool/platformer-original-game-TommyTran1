import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Level1 extends World

{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class; 
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
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
        addObject(new Door(), 1175, 45);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 70, 760);
        addObject(new Floor(), 600, 800);
        BrickWall brickWall = new BrickWall();
        addObject(brickWall,960,104);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,1008,200);
        addObject(new TrapDoor(GRAVITY),661,554);
        addObject(smBrickWall,781,554);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,901,554);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,1021,554);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,241,418);
        addObject(new Bomb(GRAVITY),403,368);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,632,719);
        addObject(new TrapDoor(GRAVITY),371,617);
        addObject(new TrapDoor(GRAVITY),1139,399);
        Gem gem = new Gem();
        addObject(gem,1141,358);
        Gem gem2 = new Gem();
        addObject(gem2,1083,358);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,1141,103);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,1020,102);
        addObject(new Rock (GRAVITY),701,514);
        addObject(new Bomb(GRAVITY),112,370);
        addObject(new TrapDoor(GRAVITY),243,266);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,491,189);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,611,189);
        SmBrickWall smBrickWall9 = new SmBrickWall();
        addObject(smBrickWall9,899,101);
        addObject(new Bomb(GRAVITY),938,259);
        Gem gem3 = new Gem();
        addObject(gem3,88,170);
        Gem gem4 = new Gem();
        addObject(gem4,1080,651);
        addObject(new Bomb(GRAVITY),957,758);
        addObject(new TrapDoor(GRAVITY),1141,704);
        addObject(new Bomb(GRAVITY),944,517);
        SmBrickWall smBrickWall10 = new SmBrickWall();
        addObject(smBrickWall10,738,305);
        addObject(new Bomb(GRAVITY),370,671);

        SmBrickWall smBrickWall11 = new SmBrickWall();
        addObject(smBrickWall11,494,550);
        SmBrickWall smBrickWall12 = new SmBrickWall();
        addObject(smBrickWall12,83,223);
    }

    private void spawn() 
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }

        if(Math.random() < 0.0025)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
