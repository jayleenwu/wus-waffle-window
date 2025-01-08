import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * displays a specific number of stars based on the number of stars the player still has
 */
public class Stars extends Actor
{
    private int value;
    
    public Stars(int value)
    {
        setImage("5stars.png"); // player starts with 5 stars and loses 1 each time a topping falls out of the screen
        GreenfootImage image = getImage();
        image.scale(263, 40);
        
        this.value = value;
        update();
    }
    
    public void setValue(int value)
    {
        this.value = value;
        update();
    }
    
    private void update()
    {
        if(value == 4)
        {
            setImage(new GreenfootImage("4stars.png"));
            GreenfootImage image = getImage();
            image.scale(263, 40);
        }
        
        else if(value == 3)
        {
            setImage(new GreenfootImage("3stars.png"));
            GreenfootImage image = getImage();
            image.scale(263, 40);
        }
        
        else if(value == 2)
        {
            setImage(new GreenfootImage("2stars.png"));
            GreenfootImage image = getImage();
            image.scale(263, 40);
        }
        
        else if(value == 1)
        {
            setImage(new GreenfootImage("1star.png"));
            GreenfootImage image = getImage();
            image.scale(263, 40);
        }
        
        else if(value == 0)
        {
            setImage(new GreenfootImage("0stars.png"));
            GreenfootImage image = getImage();
            image.scale(263, 40);
        }
    }
}
