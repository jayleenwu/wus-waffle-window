import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * button that players can click which will lead them to a the welcome/home page
 *
 */
public class HomeButton extends Actor
{
    private GreenfootSound clickSound; // clicking sound
    public HomeButton()
    {
        GreenfootImage image = getImage();
        image.scale(80, 80);
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
