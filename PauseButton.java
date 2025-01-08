import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * button that players can click which will pause the game temporarily until they click enter to resume
 *
 */
public class PauseButton extends Actor
{
    private GreenfootSound clickSound; // clicking sound
    public PauseButton()
    {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) 
        {
            Sky sky = (Sky)getWorld();
            Greenfoot.setWorld(new PauseScreen(sky));
            clickSound.play();
        }
    }
}
