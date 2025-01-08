import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * button that players can click which will lead them to a page of instructions
 *
 */
public class HelpButton extends Actor
{
    private GreenfootSound clickSound; // clicking sound
    public HelpButton()
    {
        GreenfootImage image = getImage();
        image.scale(80, 80);
        setImage(image);
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new HelpScreen()); // leads player to the instruction page if button is clicked
            clickSound.play(); // plays the clicking sound
        }
    }
}
