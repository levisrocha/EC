import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LandMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LandMine extends Actor
{
    /**
     * Act - do whatever the LandMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int explode = 0;
    private int explodeTimer = 50;
    private int animationCount = 0;
    private int animationCalc;
    private int animation = 2;
    public void act() 
    {
        if(explode==0){
        checkForZombies();
        landMineAnimation();
    }else{
    explode();
    }
    
        
    }
    public void landMineAnimation(){
    if(animationCount>=30 && !ImageVisitor.equal(getImage(), new GreenfootImage("Explosion.png"))){
    animationCalc = (animation%2)+1;
    setImage("landmine"+animationCalc+".png");
    animation = animationCalc;
    animationCount=0;
    }
    animationCount++;
    }
    
    public void checkForZombies(){
    if(isTouching(Zombie.class)){
    setImage("Explosion.png");
    Greenfoot.playSound("explosion.wav");
    List<Zombie> zombie = getObjectsInRange(140, Zombie.class);

    for(int i=0;i<zombie.size();i++){
    zombie.get(i).setImage("splat.png");
    }
     
  
    explode=1;
    }
    }
    
    public void explode(){
    explodeTimer--;
    
    if(explodeTimer<=0)
    getWorld().removeObject(this);
    }
}
