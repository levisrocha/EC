import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class amountMines here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class amountMines extends Actor
{
    
    public void act() 
    {
        Guy guy = (Guy)getWorld().getObjects(Guy.class).get(0);
        GreenfootImage img = new GreenfootImage(500,500);
        img.setColor(Color.BLACK);
        float fontSize = 25.0f; 
        Font font = img.getFont().deriveFont(fontSize);
        img.setFont(font); 
        img.drawString("Landmines: "+guy.landMineAmount, 50,50);
        setImage(img);
    }    
}
