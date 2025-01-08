import greenfoot.*;
/**
 * updated layer of the Banana topping which checks to see if it can catch other toppings
 *
 */
public class Bananas extends Actor
{
    private int height; // stores and updates the height from when added to the world and when stacked
    private final int SPEED = 6;
    private boolean isTouchingUpper = false;
    private GreenfootSound ewSound;
    
    public Bananas() // general image settings of the banana layer
    {
        GreenfootImage image = getImage();
        image.scale(145, 22);
        setImage(image);
        
        ewSound = new GreenfootSound("ew.wav");
    }
    
    public void addedToWorld (World w){
        height = getY();
    }
    
    // follows the left and right keys at the same speed as all other topping layers
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
            removeTouching(Strawberry.class); // first removes the falling topping
            world.stackStrawberry(); // then, replaces it by adding a layer of the topping, also updates height information
            world.increaseStrawberry(); // adds the price value ($0.99) to total earnings
        }
        
        if(isTouching(Cream.class)) // similar to strawberry but for a cream topping
        {
            removeTouching(Cream.class);
            world.stackCream();
            world.increaseCream(); // value ($0.51)
        }
        
        if(isTouching(Nutella.class)) // similar
        {
            removeTouching(Nutella.class);
            world.stackNutella();
            world.increaseNutella(); // value ($0.75)
        }
        
        if(isTouching(Banana.class)) // similar
        {
            removeTouching(Banana.class);
            world.stackBanana();
            world.increaseBanana(); // value ($0.99)
        }
        
        if(isTouching(Sock.class)) // if player catches a stinky sock, the game automatically ends
        {
            ewSound.play();
            world.gameOver();
        }
    }
}
