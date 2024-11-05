import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimerScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimerScreen extends World
{

    /**
     * Constructor for objects of class TimerScreen.
     * 
     */
    
    private Label timerLabel;
    private World home;
    
    public TimerScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.home = home;
        setBackground(new GreenfootImage("background.png"));
        
        timerLabel = new Label("Choose your time duration!", 30);
        addObject(timerLabel, 300, 100);
        
        Label thirtySecondLabel = new Label("30 Seconds", 24);
        addObject(thirtySecondLabel, 200, 200);
        addObject(new Button(() -> Greenfoot.setWorld(new GameMenu(home, 30))), 200, 250);
        
        Label sixtySecondLabel = new Label("60 Seconds", 24);
        addObject(sixtySecondLabel, 400, 200);
        addObject(new Button(() -> Greenfoot.setWorld(new GameMenu(home, 60))), 400, 250);
    }
}
