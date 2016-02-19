import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombieWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zombieWorld extends World
{

    /**
     * Constructor for objects of class zombieWorld.
     * 
     */
    private int carSpawnNumber=0;
    private int carSpawnPlace;
    private int boxSpawnNumber=0;
    private int zombieSpawnNumber=0;
    private int zombieSpawnNumberFrequency=200;
    private int zombieSpawnNumberFrequency2=0;
    private int zombieSpawnPlace;
    
    public void act(){  
    carSpawn();
    zombieSpawn();
    boxSpawn();
    //gameOver();
    }
    
    public zombieWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1);
        setPaintOrder(Guy.class,Car.class,CarOutOfGas.class,Zombie.class,LandMine.class); 

        Guy guy = new Guy();
        addObject(guy, 455, 363);
        
        Zombie zombie1 = new Zombie();
        addObject(zombie1, 807, 619);
        Zombie zombie3 = new Zombie();
        addObject(zombie3, 95, 641);
        Zombie zombie4 = new Zombie();
        addObject(zombie4, 602, 47);
        Zombie zombie5 = new Zombie();
        addObject(zombie5, 838, 52);
        
        Point point = new Point(0);
        addObject(point, 200, 220);
        amountMines amountmines = new amountMines();
        addObject(amountmines, 1000, 220);
    }
    public void boxSpawn(){
    if(boxSpawnNumber>=1500){
    if(Greenfoot.getRandomNumber(10)==1){
    removeObjects(getObjects(Box.class));
    Box box = new Box();
    addObject(box,Greenfoot.getRandomNumber(800)+50,Greenfoot.getRandomNumber(600)+50);
    boxSpawnNumber=0;

}
    }
    boxSpawnNumber++;
    }
    public void carSpawn(){
    Guy guy = (Guy)getObjects(Guy.class).get(0);
    if(!ImageVisitor.equal(guy.getImage(), new GreenfootImage("Car.png"))){
    if(carSpawnNumber>=2000){
    if(Greenfoot.getRandomNumber(10)==1){
    removeObjects(getObjects(Car.class));
    Car car = new Car();
    carSpawnPlace=Greenfoot.getRandomNumber(2)+1;
    if(carSpawnPlace==1)
    addObject(car,712,162);

    if(carSpawnPlace==2)
    addObject(car,311,391);
    
    carSpawnNumber=0;

}
}}
carSpawnNumber++;
    }
    
    public void zombieSpawn(){
    if(zombieSpawnNumberFrequency >=50 && zombieSpawnNumberFrequency2>=100)
    {zombieSpawnNumberFrequency-=4;
      zombieSpawnNumberFrequency2=0;
    }
    if(zombieSpawnNumber>=zombieSpawnNumberFrequency){
    if(Greenfoot.getRandomNumber(10)==1){
    if(Greenfoot.getRandomNumber(8)==0)
    Greenfoot.playSound("Zombie.wav");
    
    Zombie zombie = new Zombie();
    zombieSpawnPlace=Greenfoot.getRandomNumber(4)+1;
    if(zombieSpawnPlace==1)
    addObject(zombie,0,0);

    if(zombieSpawnPlace==2)
    addObject(zombie,900,0);
    
    if(zombieSpawnPlace==3)
    addObject(zombie,0,700);

    if(zombieSpawnPlace==4)
    addObject(zombie,900,700);
    
    zombieSpawnNumber=0;
    
    

}
}
zombieSpawnNumberFrequency2++;
zombieSpawnNumber++;
    }
    private void clean()
    {
        removeObjects(getObjects(null));
    }
    public void gameOver()
    {
        clean();
        setBackground("Game over.png123.png");  
        //addObject(new animationMover("gameoverAnim.png"),210,300);
        //addObject(new MainMenu(),210,470);
        //Greenfoot.playSound("gameover.wav");
    }
    

}
