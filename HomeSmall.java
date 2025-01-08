import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * a smaller button displayed on the corner of the game screen that players can click which will lead them back to the home page
 *
 */
public class HomeSmall extends Actor
{
    private GreenfootSound clickSound; // clicking sound
    public HomeSmall()
    {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new HomeScreen());
            clickSound.play();
        }
    }
}
