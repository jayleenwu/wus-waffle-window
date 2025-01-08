import greenfoot.*;
/**
 * sets the size and speed of fall of the Cream topping
 *
 */
public class Cream extends Actor
{
    public Cream()
    {
        GreenfootImage image = getImage();
        image.scale(32, 35);
        setImage(image);
    }
    
    public void act()
    {
        setLocation(getX(),getY()+5);
        
        Sky world = (Sky)getWorld();
        if(getY() == 800) // checks if cream has reached the bottom of the screen
        {
            world.updateStars(); // updates Stars by removing one star
        }
    }
}
