import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarOutOfGas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarOutOfGas extends Actor
{
    /**
     * Act - do whatever the CarOutOfGas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int timer=300;
    public CarOutOfGas(int rotation){
    setRotation(rotation);
    }
    public void act() 
    {
        COOGTimer();
    }    
    
    public void COOGTimer(){
    if(timer<=0)
    getWorld().removeObject(this);
    
    timer--;
    }
}
