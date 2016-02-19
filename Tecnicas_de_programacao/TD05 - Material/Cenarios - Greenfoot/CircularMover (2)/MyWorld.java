import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Font;
import java.awt.Color;

/**
 * class MyWorld
 * 
 * @author (tombud999) 
 * @version 0 (2009.07.03)
 * 
 * This CircularMover scenario is using Poul Henriksen & Michael Kolling's
 *   Vector class ver2.0 from Marbles scenario
 */
public class MyWorld  extends World
{
    private boolean cWise; // circular movement direction (true=clockwise ; false=counterclockwise)
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(540, 540, 1); 
        setBackground("cell.jpg");
        addObject(new Fly(0,true),180,120);
        addObject(new Fly(45,false),360,360);

        
    }
    
//===============================================================================

    public void act() 
    {
        int rand = Greenfoot.getRandomNumber(360);
        int rand2 = Greenfoot.getRandomNumber(2);
        if (rand2==0) {cWise=false;}       
        else {cWise=true;}
        //create new object by mouse click
        if((Greenfoot.mouseClicked(null)) && !Greenfoot.mouseDragEnded(null) ) {   
            MouseInfo mi = Greenfoot.getMouseInfo();
            int x2 = mi.getX();
            int y2 = mi.getY();
            List listObj = getObjectsAt(x2,y2,null);
            int countObj = listObj.size();
            if(mi.getButton() == 1 & countObj == 0) { 
                    addObject(new Fly(rand,cWise),x2,y2);
            }
        }
        
        if(Greenfoot.isKeyDown("X")) { // Clear the World
            List allFly = getObjects(Fly.class); // List of all Flys
            for(Object oAllFly : allFly) { // loop the List 
                Fly fly = (Fly) oAllFly; // get one Object oAllFly into fly
                fly.removeLFly();
            }    
        }
        
    } //act()  
    
    
}
