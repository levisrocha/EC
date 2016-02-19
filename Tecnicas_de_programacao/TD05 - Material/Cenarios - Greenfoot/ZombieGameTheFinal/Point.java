import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point extends Actor
{
    public int points;
    
    
    public Point (int m_points){
    points = m_points;
    }
    public void act() 
    {
        World world = getWorld();
        if(world instanceof zombieWorld)
        {
        
        GreenfootImage img = new GreenfootImage(500,500);
        img.setColor(Color.BLACK);
        float fontSize = 25.0f; 
        Font font = img.getFont().deriveFont(fontSize);
        img.setFont(font); 
        img.drawString("Score: "+points, 50,50);
        setImage(img);}
        else if(world instanceof Gameover){
        GreenfootImage img = new GreenfootImage(500,500);
        img.setColor(Color.RED);
        float fontSize = 50.0f; 
        Font font = img.getFont().deriveFont(fontSize);
        img.setFont(font); 
        img.drawString("Score: "+points, 60,50);
        setImage(img);
        }
    }    
}
