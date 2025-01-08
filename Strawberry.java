import greenfoot.*; 
/**
 * sets the size and speed of fall of the Strawberry topping
 *
 */
public class Strawberry extends Actor
{
    public Strawberry()
    {
        GreenfootImage image = getImage();
        image.scale(27, 45);
        setImage(image);
    }
    
    public void act()
    {
        setLocation(getX(),getY()+5);
        
        Sky world = (Sky)getWorld();
        if(getY() == 800) // checks if nutella has reached the bottom of the screen
        {
            world.updateStars(); // updates Stars by removing one star
        }
    }
}
