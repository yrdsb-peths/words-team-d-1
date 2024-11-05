import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResultScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultScreen extends World
{
    private Label backMenuLabel;
    private Label playAgain;
 
    public ResultScreen(int timeInSec, int totatChars, int totalTypos, int paragraphLength)
    {    
        super(600, 400, 1);
        setBackground(new GreenfootImage("background.png"));
        
        Stats stats = new Stats(timeInSec, totatChars, totalTypos, paragraphLength);
        addObject(stats, 0, 0);
        
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 500, 370);
        playAgain = new Label("Play again", 20);
        addObject(playAgain, 500, 338);
        
        addObject(new Button(() -> Greenfoot.setWorld(new MenuScreen())), 100, 370);

        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);
    }
}
