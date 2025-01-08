import greenfoot.*;
/**
 * sets the size and speed of fall of the Banana topping
 *
 */
public class Banana extends Actor
{
    public Banana()
    {
        GreenfootImage image = getImage();
        image.scale(40, 37);
        setImage(image);
    }
    
    public void act()
    {
        setLocation(getX(),getY()+5);
        
        Sky world = (Sky)getWorld();
        if(getY() == 800) // checks if banana has reached the bottom of the screen
        {
            world.updateStars(); // updates Stars by removing one star
        }
    }
}
