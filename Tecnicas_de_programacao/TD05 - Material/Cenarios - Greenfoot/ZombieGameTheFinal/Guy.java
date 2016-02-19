import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guy extends Actor
{
    /**
     * Act - do whatever the Guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int shotDelay = 20;
    private int landMineDelay = 20;
    public int landMineAmount= 2;
    private int moveSpeed = 3;
    private int rotateSpeed=3;
    private int carTime=0;
    private int animationCount=0;
    
   
    
    private int animation=2;
    private int animationCalc;
    public void act() 
    {
        shotDelay++;
        landMineDelay++;
        guyMove();
        guyRotate();
        Shoot();
        placeLandMine();
        boxHit();
        Car();
        carOver();
    }
    
    public void boxHit(){
    if(isTouching(Box.class))
    {
    landMineAmount++;
    Box box = (Box)getWorld().getObjects(Box.class).get(0);
    getWorld().removeObject(box);
}
    
    }
    
    public void guyMove(){
    if(Greenfoot.isKeyDown("up")){
    move(moveSpeed);
    if(!ImageVisitor.equal(getImage(), new GreenfootImage("Car.png"))){
    if(animationCount>=10){
    animationCalc= animation%2+1;
    setImage(""+animationCalc+".png");
    animation = animationCalc;
    animationCount=0;
    }
}

    animationCount++;
    }

    
    if(Greenfoot.isKeyDown("down")){
    move(-moveSpeed);
    if(!ImageVisitor.equal(getImage(), new GreenfootImage("Car.png"))){
    if(animationCount>=10){
    animationCalc= animation%2+1;
    setImage(""+animationCalc+".png");
    animation = animationCalc;
    animationCount=0;
    }
}

    animationCount++;
    }
    }
    
    
    public void guyRotate(){
    if(Greenfoot.isKeyDown("right")){
    turn(rotateSpeed);
    }
    
    if(Greenfoot.isKeyDown("left")){
    turn(-rotateSpeed);
    }
    }
    
    public void Shoot(){
    if(Greenfoot.isKeyDown("space") && shotDelay>=20 && !ImageVisitor.equal(getImage(), new GreenfootImage("Car.png"))){
    Greenfoot.playSound("shot.wav");
    Shot shot = new Shot(getRotation());
    getWorld().addObject(shot, getX(), getY());
    shotDelay=0;
        }
    }
    public boolean isCarInRange()  
{  
    return !getObjectsInRange(50, Car.class).isEmpty();  
} 
    public void Car(){
    if(Greenfoot.isKeyDown("e") && isCarInRange()){
    Car car = (Car)getWorld().getObjects(Car.class).get(0);
    getWorld().removeObject(car);
    setImage("Car.png");
    Greenfoot.playSound("car.wav");
    setRotation(0);
    moveSpeed=6;
    rotateSpeed=3;
    carTime=0;
    }
    }
    
    public void carOver(){
    if(carTime>500 && ImageVisitor.equal(getImage(), new GreenfootImage("Car.png"))){
    CarOutOfGas COOG = new CarOutOfGas(getRotation());
    getWorld().addObject(COOG, getX(), getY());
    setImage("1.png");
    moveSpeed=3;
    rotateSpeed=3;
    }
    carTime++;
    }
    
    public void placeLandMine(){
    if(Greenfoot.isKeyDown("q") && landMineDelay>=20 && landMineAmount>0){
    LandMine landmine = new LandMine();
    getWorld().addObject(landmine, getX(), getY());
    landMineAmount--;
    landMineDelay=0;
        }
    }
    
    
}
