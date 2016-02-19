import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int shotsToKill= Greenfoot.getRandomNumber(4)+1;
    private int removeZombieTime = 200;
    private int animation=2;
    private int animationCalc;
    private int animationCount=0;
    private int givePoint=0;
    public void act() 
    {
        if(!ImageVisitor.equal(getImage(), new GreenfootImage("splat.png"))){
        zombieMove();
        zombieRotate();
        zombieKill();
        zombieGetsKilled();
    }
    else{
    if(givePoint==0){
    Point point = (Point)getWorld().getObjects(Point.class).get(0);
    point.points+=5;
    givePoint++;
    }
    removeZombie();
    }
    }
    
    public void zombieMove(){
    if(animationCount>=16){
    animationCalc= animation%2+1;
    setImage("Zombie"+animationCalc+".png");
    animation = animationCalc;
    animationCount=0;
    }
    animationCount++;
    move(1);
    }
        
    public void zombieRotate(){
        
        Guy guy = (Guy)getWorld().getObjects(Guy.class).get(0);
        turnTowards(guy.getX(),guy.getY());
    
    }
    
    public void zombieKill(){
    if(isTouching(Guy.class)){
    Guy guy = (Guy)getWorld().getObjects(Guy.class).get(0);
    if(ImageVisitor.equal(guy.getImage(), new GreenfootImage("Car.png")))
    {
        Greenfoot.playSound("splatsound.wav");
        setImage("splat.png");
    }
    else if(ImageVisitor.equal(guy.getImage(), new GreenfootImage("1.png"))|| ImageVisitor.equal(guy.getImage(), new GreenfootImage("2.png")))
    {
    Point point = (Point)getWorld().getObjects(Point.class).get(0);
    Greenfoot.setWorld(new Gameover(point.points));
    }
}
}

    
    public void zombieGetsKilled(){
    if(isTouching(Shot.class)){
    shotsToKill--;
    Shot shot = (Shot) getOneIntersectingObject(Shot.class);
    getWorld().removeObject(shot);
    }
    if(shotsToKill==0){
    if(givePoint==0){
    Point point = (Point)getWorld().getObjects(Point.class).get(0);
    point.points+=5;
    givePoint++;
    }
    getWorld().removeObject(this);
    
}
    }
    
    public void removeZombie(){
    
    if(removeZombieTime<=0){
    getWorld().removeObject(this);
    }else{
    removeZombieTime--;
    }
    }
}
