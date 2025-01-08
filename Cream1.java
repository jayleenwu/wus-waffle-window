import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * updated layer of the Cream topping which checks to see if it can catch other toppings
 * similar to Bananas - check for more detailed comments
 *
 */
public class Cream1 extends Actor
{
    private int height;
    private final int SPEED = 6;
    private boolean isTouchingUpper = false;
    private GreenfootSound ewSound;
    
    public Cream1()
    {
        GreenfootImage image = getImage();
        image.scale(145, 30);
        setImage(image);
        
        ewSound = new GreenfootSound("ew.wav");
    }
    
    public void addedToWorld (World w){
        height = getY();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left")){
            setLocation (getX() - SPEED, height);
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation (getX() + SPEED, height);
        }
        checkUpper();

    }
    
    public void checkUpper() {
        Chocolate c = (Chocolate)getOneObjectAtOffset(0, -getImage().getHeight()/2, Chocolate.class);
        Cream1 c1 = (Cream1)getOneObjectAtOffset(0, -getImage().getHeight()/2, Cream1.class);
        Strawberries s = (Strawberries)getOneObjectAtOffset(0, -getImage().getHeight()/2, Strawberries.class);
        Bananas b = (Bananas)getOneObjectAtOffset(0, -getImage().getHeight()/2, Bananas.class);
        
        if(c != null || c1 != null || s != null || b != null)
        {
            isTouchingUpper = true;
        }
        else
        {
            stack();
        }
    }
    
    public void stack()
    {
        Sky world = (Sky)getWorld();
        
        if(isTouching(Strawberry.class))
        {
            removeTouching(Strawberry.class);
            world.stackStrawberry();
            world.increaseStrawberry();
        }
        
        if(isTouching(Cream.class))
        {
            removeTouching(Cream.class);
            world.stackCream();
            world.increaseCream();
        }
        
        if(isTouching(Nutella.class))
        {
            removeTouching(Nutella.class);
            world.stackNutella();
            world.increaseNutella();
        }
        
        if(isTouching(Banana.class))
        {
            removeTouching(Banana.class);
            world.stackBanana();
            world.increaseBanana();
        }
        
        if(isTouching(Sock.class))
        {
            ewSound.play();
            world.gameOver();
        }
    }
}
