import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
/**
 * Write a description of class clickEnter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clickEnter extends Actor
{
    /**
     * Act - do whatever the clickEnter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(500,500);
        img.setColor(Color.RED);
        float fontSize = 25.0f; 
        Font font = img.getFont().deriveFont(fontSize);
        img.setFont(font); 
        img.drawString("Press enter to retry",50,50);
        setImage(img);
    }    
}
