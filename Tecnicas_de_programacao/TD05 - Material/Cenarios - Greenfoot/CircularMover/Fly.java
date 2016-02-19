import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * class Fly
 * 
 * @author (tombud999) 
 * @version 0 (2009.06.10)
 * 
 * This CircularMover scenario is using Poul Henriksen & Michael Kolling's
 *   Vector class ver2.0 from Marbles scenario
 */
public class Fly extends CircularMover
{
    private int x,y,r;  // this Fly initial center point x y and rotation r when created/edited
    private int iRot;   // Initial rotation angle when created 
    private Vector vVV;  // this Fly linear velocity vector
    private boolean cWise; // circular movement direction (true=clockwise ; false=counterclockwise)

    private static final double CIR_RAD = 60; // Circular path radius from center to path (Fly center)
    private static final double DECEL = 0.998; // Fly decelleration factor (< 1.00)
    private static final double SCALE = 1.0; // Force scale factor

    private boolean moving; // Fly is moving in circular path


    /**
    * Constructor for objects of class Fly.
    * Create new Fly with initial object rotation initRot    
    */
    public Fly(int initRot, boolean cW)
    {
        iRot = initRot;
        setCR(CIR_RAD);
        
        cWise = cW;
    }
    
    protected void addedToWorld(World MyWorld)
    {
        setRotation(iRot);
        r = iRot;
        
        //apply initial linear force vForce to make the Fly start moving
        Vector vForce = new Vector(r,8.0); //vector with direction r and magnitude 8.0
        addForce(vForce); 
        setMoving(true); 
        
        flyAttrib(); // update & save this Fly x,y,r 
    }


//========================================================================
    public void act() 
    {
        if (moving) {
            moveCir();

            accelerate(DECEL);      // decelerate
            if (getSpeed() < 0.1) { 
                setMoving(false);
            }
        } 

    }    
//========================================================================

    public void flyAttrib() // update & save this Fly x,y,r  
    {
        x = this.getX(); 
        y = this.getY(); 
        r = this.getRotation();
        calcCP(); // calculate center of circular path (cPX,cPY) position
        setCDir(cWise); // set circular movement direction
    }
    

    //------------------
    public boolean isMoving()
    {
        return moving;
    }

    //------------------
    public void setMoving(boolean mov)
    {
        moving = mov;
    }    

     
    //------------------
    public void removeLFly()
    {
        getWorld().removeObject(this);
    }
 
    
}
