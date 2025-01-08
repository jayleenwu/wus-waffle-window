import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * button that players can click which will lead them to the game screen where the game will begin
 *
 */
public class PlayButton extends Actor
{
    private GreenfootSound clickSound; // clicking sound
    public PlayButton()
    {
        GreenfootImage image = getImage();
        image.scale(80, 80);
        setImage(image);
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new Sky());
            clickSound.play();
        }
    }
}
