import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * help page that has simple, easy to understand instructions for the game
 * tells the player that left/right arrow keys are used to move the waffle
 * maximum of 5 toppings can drop past the screen, if any more then the player will lose
 * the player will also lose if they catch a sock
 * 
 * player is allowed to click play or revisit the home page
 * 
 */
public class HelpScreen extends World
{
    public HelpScreen()
    {    
        super(1200, 800, 1, false);
        addObject (new PlayButton (), 551, 589);
        addObject (new HomeButton (), 649, 589);
    }
}
