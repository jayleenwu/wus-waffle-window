import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * welcome page and home page that displays the name of the game in large letters
 * allows the user to click the help button for instructions and the play button to begin playing the game 
 * music also begins playing here, will loop if finished
 * 
 */
public class HomeScreen extends World
{
    public GreenfootSound lobbyMusic;
    public HomeScreen()
    {    
        super(1200, 800, 1, false);
        addObject (new PlayButton (), 551, 589);
        addObject (new HelpButton (), 649, 589);
        lobbyMusic = new GreenfootSound("spagonia day.mp3");
    }
    
    public void started()
    {
        lobbyMusic.playLoop(); // stars and loops music
    }
    
    public void stopped()
    {
        lobbyMusic.stop();
    }
}
