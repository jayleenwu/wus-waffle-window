import greenfoot.*;  
/**
 * Welcome to Wu's Waffle Window!
 * Goal of the Game: Build a tasty waffle by stacking as many appropriate toppings (strawberries, bananas, Nutella, whipped cream)
 * that fall from the sky onto a waffle
 * Do not catch a stinky sock!
 * 
 * You begin with a 5 star rating, and it will decrease by 1 each time you miss a topping.
 * If you miss 5 toppings or catch a stinky sock, the game will end.
 * 
 * To play, simply use your left and right arrow keys to move the waffle under the falling toppings.
 * 
 * Good luck and have fun!
 * 
 * 
 * Graphic Credits: Jayleen Wu
 * Audio Credits:
 * -- Spagonia - Day: https://www.youtube.com/watch?v=OWZ0cgwsWGI
 * -- Uh Oh Sound Effect: https://www.youtube.com/watch?v=4ZtMe9ggT9I
 * -- Money Sound Effect: https://www.youtube.com/watch?v=7xj6YAG2FI8
 * -- Ew Sound Effect: https://www.youtube.com/watch?v=8zAr3zU7jQQ
 * -- Click Sound Effect: https://www.youtube.com/watch?v=kgf11U-GFPo
 *
 */
public class Sky extends World
{
    private int height; // keeps track of the height of the stacked waffle
    private static double score; // keeps track of earnings
    private int number; // keeps track of stars
    Label scoreLabel;
    Stars updateValue;
    
    private int cooldown; // to prevent spawns that are way too fast 
    private int maxCooldown;
    
    private GreenfootSound moneySound; // sound effect for when the user catches a good topping
    private GreenfootSound uhOhSound; // sound effect for when the user misses a topping
    
    public Sky() // adds the objects into the game at specific locations
    {    
        super(1200, 800, 1, false);
        addObject (new Waffle (), 600, 750);
        height = 712;
        
        scoreLabel = new Label(0, 45); // earnings label at the top 
        scoreLabel.setFillColor(Color.PINK);
        addObject(scoreLabel, 596, 25);
        
        updateValue = new Stars(5); // amount of stars at top right
        addObject(updateValue, 1037, 45);
        
        maxCooldown = 20;
        cooldown = 30;
        
        number = 5;
        
        score = 0;
        
        addObject(new PauseButton(), 102, 45); // buttons at top left
        addObject(new HomeSmall(), 54, 45);
        
        moneySound = new GreenfootSound("money.wav"); // sound files
        uhOhSound = new GreenfootSound("uhoh.wav");
    }
    
    public void act () {
        spawn();
    }
    
    public void spawn() { // picks a random number to have a random spawn, but there is a cooldown to prevent uncontrollable fast spawns
        int random1 = Greenfoot.getRandomNumber(30); // strawberry
        int random2 = Greenfoot.getRandomNumber(30); // cream
        int random3 = Greenfoot.getRandomNumber(30); // nutella
        int random4 = Greenfoot.getRandomNumber(30); // banana
        int random5 = Greenfoot.getRandomNumber(10); // sock, faster spawn rate
        
        if(random1 == 0) { // spawns a straberry when random number is 0, otherwise it will regenerate and not spawn anything
            int randX1 = Greenfoot.getRandomNumber(1000) + 100; // range is 100 - 1100 and finds a random x coordinate for the spawn
            if (cooldown > 0){
                cooldown--;
            } else if (cooldown == 0){
                addObject(new Strawberry(), randX1, 0);
                cooldown = maxCooldown;
            }
        }
        
        if(random2 == 0) {
            int randX2 = Greenfoot.getRandomNumber(1000) + 100;
            if (cooldown > 0){
                cooldown--;
            } else if (cooldown == 0){
                addObject(new Cream(), randX2, 0);
                cooldown = maxCooldown;
            }
        }
        
        if(random3 == 0) {
            int randX3 = Greenfoot.getRandomNumber(1000) + 100;
            if (cooldown > 0){
                cooldown--;
            } else if (cooldown == 0){
                addObject(new Nutella(), randX3, 0);
                cooldown = maxCooldown;
            }
        }
        
        if(random4 == 0) {
            int randX4 = Greenfoot.getRandomNumber(1000) + 100;
            if (cooldown > 0){
                cooldown--;
            } else if (cooldown == 0){
                addObject(new Banana(), randX4, 0);
                cooldown = maxCooldown;
            }
        }
        
        if(random5 == 0) {
            int randX5 = Greenfoot.getRandomNumber(1000) + 100;
            if (cooldown > 0){
                cooldown--;
            } else if (cooldown == 0){
                addObject(new Sock(), randX5, 0);
                cooldown = maxCooldown;
            }
        }
    }
    
    public void stackStrawberry()
    {
        Actor actor = (Actor)getObjects(Waffle.class).get(0); // get reference to waffle object
        int waffleX = actor.getX(); // get x of gamer object
        addObject(new Strawberries(), waffleX, height); // adds strawberry based on current height of the waffle stack
        height = height - 18; // updates the new height if straberry row is stacked
    }
    
    public void stackCream() // similar to stackStrawberry()
    {
        Actor actor = (Actor)getObjects(Waffle.class).get(0);
        int waffleX = actor.getX();
        addObject(new Cream1(), waffleX, height);
        height = height - 18;
    }
    
    public void stackNutella() // similar to stackStrawberry()
    {
        Actor actor = (Actor)getObjects(Waffle.class).get(0);
        int waffleX = actor.getX();
        addObject(new Chocolate(), waffleX, height + 6);
        height = height - 12;
    }
    
    public void stackBanana() // similar to stackStrawberry()
    {
        Actor actor = (Actor)getObjects(Waffle.class).get(0);
        int waffleX = actor.getX();
        addObject(new Bananas(), waffleX, height + 6);
        height = height - 12;
    }
    
    public void increaseStrawberry() // increases the earnings by a specific amount based on the type of toping
    {
        score += 0.99;
        scoreLabel.setValue(score);
        moneySound.play();
    }
    
    public void increaseCream()
    {
        score += 0.51;
        scoreLabel.setValue(score);
        moneySound.play();
    }
    
    public void increaseNutella()
    {
        score += 0.75;
        scoreLabel.setValue(score);
        moneySound.play();
    }
    
    public void increaseBanana()
    {
        score += 0.99;
        scoreLabel.setValue(score);
        moneySound.play();
    }
    
    public static double getScore() // gets score so it can be displayed in the end screen
    {
        return score;
    }
    
    public void updateStars() // stars are updated 
    {
        number --;
        updateValue.setValue(number);
        uhOhSound.play();
        if(number == 0) // game is over if player misses 5 stars 
        {
            gameOver();
        }
    }
    
    public void gameOver() {
        EndScreen world = new EndScreen(); // leads user to the end screen for options
        Greenfoot.setWorld(world);
    }
}
