import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameover extends World
{

    /**
     * Constructor for objects of class Gameover.
     * 
     */
    
    public void act(){
    restart();
    }
    public Gameover(int m_point)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1);
        Point point = new Point(m_point);
        addObject(point,545,740);
        
        clickEnter clickenter = new clickEnter();
        addObject(clickenter,545,440);
    }
    public void restart(){
    if(Greenfoot.isKeyDown("enter"))
    Greenfoot.setWorld(new zombieWorld());
}
}
