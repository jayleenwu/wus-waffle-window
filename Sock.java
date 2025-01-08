import greenfoot.*;
/**
 * sets the size and speed of fall of the Sock topping (bad topping so do not catch)
 *
 */
public class Sock extends Actor
{
    public Sock()
    {
        GreenfootImage image = getImage();
        image.scale(45, 55);
        setImage(image);
    }
    
    public void act()
    {
        setLocation(getX(),getY()+5); // updates Stars by removing one star
    }
}
