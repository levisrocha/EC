import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * class CircularMover - move an actor in a circular path 
 * 
 * @author (tombud999) 
 * @version 0 (2009.06.10)
 * 
 * This CircularMover class is using Poul Henriksen & Michael Kolling's
 *   Vector class ver2.0 & adapted from SmoothMover class ver2.0 from Marbles scenario
 */
public abstract class CircularMover extends Actor
{
    // the center of circular path cPX,cPY is an offset point "below" the actor center position  
    // the radius of circular path is cR : method setcR
    // centripetal vector vCP direction is always +90 degrees from the actor rotation objRot
    // linear velocity vector vV is always tangential to the circular path - direction = objRot
    // start circular movement by adding a linear force to vV : method addForce(Vector force)

    private double exactX; // object position x : method setLocation 
    private double exactY; // object position y : method setLocation
    private int    objRot; // object rotation in degrees (0<=objRot<360), 0 is East : method setRotation
    private boolean cWise; // circular movement direction (true=clockwise ; false=counterclockwise) : method setCDir
    
    private double cR;     // circular path radius from the center to the actor position : method setcR
    private Vector vCP;    // centripetal vector from actor position to center of circular path
    private int    vCPDir; // centripetal vector direction = objRot + 90 degrees
    private double cPX;    // calculated center of circular path x  
    private double cPY;    // calculated center of circular path y 

    private Vector vV;     // linear velocity always tangential to the circular path - direction = objRot

    // Circular movement arc approximately = linear movement vV length
    // dTheta (in radians) = vV length / cR 
    private double dTheta; // incremental circular rotation angle (in radians) proportional to linear velocity vV 
    private double dx,dy;  // calculated dx dy of circular movement
    
    public CircularMover()
    {
        this(new Vector());
    }
    
    /**
    * Create new actor with initial linear velocity vector vV  
    */
    public CircularMover(Vector vV)
    {
        this.vV = vV;
    }
    
    

    /**
    * Set circular movement direction cWise (true=clockwise ; false=counterclockwise)
    */
    public void setCDir(boolean cW) 
    {
        cWise = cW;
    }
    
    /**
    * Move in circular path in current direction (clockwise or counterclockwise)
    */
    public void moveCir() //moveCir(boolean cW) 
    {
        //cWise = cW;
        dTheta = vV.getLength() / cR;  // in radians
        
        if (cWise && objRot+(int)Math.rint(Math.toDegrees(dTheta)) < 360) {
            objRot = objRot + (int)Math.rint(Math.toDegrees(dTheta)); // in degrees
        } else 
        if (cWise && objRot+(int)Math.rint(Math.toDegrees(dTheta)) == 360) { 
            objRot = 0; // in degrees
        } else
        if (!cWise && objRot-(int)Math.rint(Math.toDegrees(dTheta)) >= 0) {
            objRot = objRot - (int)Math.rint(Math.toDegrees(dTheta)); // in degrees
        } else 
        if (!cWise && objRot-(int)Math.rint(Math.toDegrees(dTheta)) < 0) { 
            objRot = 360 + objRot - (int)Math.rint(Math.toDegrees(dTheta)); // in degrees
        } else {
            objRot = (int)Math.rint(Math.toDegrees(dTheta));
        }
        
        setRotation(objRot); // synchronize the actor rotation to circular movement 
        vV.setDirection(objRot); // synchronize vector vV direction
        calcVCP(); // calculate vector vCP (reverse direction) to get the actor's new location
        exactX = cPX + vCP.getX();
        exactY = cPY + vCP.getY();
        super.setLocation((int) exactX, (int) exactY); // move the actor to new location on circular path
        
    }
    

    public void setLocation(double xx, double yy) 
    {
        exactX = xx;
        exactY = yy;
        super.setLocation((int) xx, (int) yy);
    }
    
    public void setLocation(int xx, int yy) 
    {
        exactX = xx;
        exactY = yy;
        super.setLocation(xx, yy);
    }

    public void setRotation(int rr) // synchronize the actor rotation to circular movement
    {
        objRot = rr;
        super.setRotation(rr);
    }

    public void setCR(double cr) // set the circular path radius from the center to the actor position
    {
        cR = cr;
    }

    /**
     * Calculate the center of circular path (cPX,cPY) position
     * call this method once after the actor added to the world
     * the center of circular path cPX,cPY is an offset point "below" the actor center position
     */ 
    public void calcCP()  
    {
        vCPDir = objRot + 90;
        if (vCPDir >= 360) {
            vCPDir = vCPDir - 360;
        }
        vCP = new Vector (vCPDir, cR);
        cPX = exactX + vCP.getX();
        cPY = exactY + vCP.getY();
    }
    
    /**
     * Calculate vector vCP (reverse direction)
     * the centripetal vector vCP direction is always +90 degrees from the actor rotation objRot
     * reverse vCP direction to get the actor new exactX,Y from the known center of circular path cPX,Y
     */
    public void calcVCP() 
    {
        
        vCPDir = objRot + 90 + 180;  // + 180 to reverse vector direction
        if (vCPDir >= 360) {
            vCPDir = vCPDir - 360;
        }
        vCP = new Vector (vCPDir, cR);
    }

    
    
    public double getExactX() 
    {
        return exactX;
    }

    public double getExactY() 
    {
        return exactY;
    }

    /**
     * Increase linear speed with the given vector force
     */
    public void addForce(Vector force) 
    {
        vV.add(force);
    }
    
    /**
     * Accelerate linear speed by the given factor (factor < 1 means decelerate)
     */
    public void accelerate(double factor)
    {
        vV.scale(factor);
        if (vV.getLength() < 0.15) { // stop if speed is very small
            vV.setNeutral();
        }
    }
    
    /**
     * Return the linear speed of this actor
     */
    public double getSpeed()
    {
        return vV.getLength();
    }
    
    /**
     * Stop
     */
    public void stop()
    {
        vV.setNeutral();
    }
    
    /**
     * Return the current linear speed vector
     */
    public Vector getvV() 
    {
        return vV;
    }
}
