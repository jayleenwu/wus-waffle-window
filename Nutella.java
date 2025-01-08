import greenfoot.*;  
/**
 * sets the size and speed of fall of the Nutella topping
 *
 */
public class Nutella extends Actor
{
    public Nutella()
    {
        GreenfootImage image = getImage();
        image.scale(33, 37);
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
