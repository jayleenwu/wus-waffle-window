import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * page that players can get to if they click the pause button during game play
 * can get back to the game if they click enter
 * 
 */
public class PauseScreen extends World
{
    private Sky sky;
    public PauseScreen(Sky sky)
    {    
        super(1200, 800, 1);
        this.sky = sky;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
            {
                Greenfoot.setWorld(sky);
            }
    }
}
