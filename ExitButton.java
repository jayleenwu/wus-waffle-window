import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * button that players can click which will lead them to the final screen of the game that thanks them for playing
 *
 */
public class ExitButton extends Actor
{
    private GreenfootSound clickSound;
    HomeScreen music;
    
    public ExitButton()
    {
        GreenfootImage image = getImage();
        image.scale(80, 80);
        setImage(image);
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) 
        {
            clickSound.play();
            Greenfoot.setWorld(new FinalScreen());
            Greenfoot.stop();
        }
    }
}
