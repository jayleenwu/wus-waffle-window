import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the base the catches all the falling toppings
 */
public class Waffle extends Actor
{
    private int height;
    private final int SPEED = 6;
    private boolean isTouchingUpper = false;
    private GreenfootSound ewSound;
    
    public Waffle ()
    {
        GreenfootImage image = getImage();
        image.scale(200, 50);
        setImage(image);
        
        ewSound = new GreenfootSound("ew.wav");
    }
    
    public void addedToWorld (World w){
        height = getY();
    }
    
    public void act() // moves according the left/right key pressed by the player
    {
        if (Greenfoot.isKeyDown("left")){
            setLocation (getX() - SPEED, 750);
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation (getX() + SPEED, 750);
        }
        checkUpper();
    }
    
    // checks to see if there is any topping layer stacked on top
    // if there is, then the layer becomes inactive and cannot check if it is touching falling toppings
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
    
    // stacks toppings if it is the highest layer
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
