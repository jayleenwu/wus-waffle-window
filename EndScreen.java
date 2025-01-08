import greenfoot.*;
/**
 * screen that is displayed if the player has lost all their stars (5) or caught a stinky sock
 * offers the option to go back to the home page, play again, or totally stop playing
 * displays their final score (total earnings)
 *
 */
public class EndScreen extends World
{
    Label scoreLabel;
    
    public EndScreen()
    {    
        super(1200, 800, 1, false);
        addObject (new HomeButton (), 501, 589); // home button to go to home page
        addObject (new PlayButton (), 600, 589); // play button to play again
        addObject (new ExitButton (), 699, 589); // exit button to stop playing
        
        scoreLabel = new Label(0, 45);
        scoreLabel.setFillColor(Color.WHITE);
        addObject(scoreLabel, 596, 457);
        
        double score = Sky.getScore();
        
        scoreLabel.setValue(score); // displays the final score
    }
}
