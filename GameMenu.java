import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameMenu extends World
{
    private Label gameLabel;
    private Typer typer;
    private Label paragraphLabel;
    private World home;
    
    private SimpleTimer timer;
    private Label timerLabel; 
    private int timerDuration;  // choose 30 seconds or 60 seconds

    public GameMenu(World home, int timerDuration) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("background.png"));
        this.home = home;
        this.timerDuration = timerDuration; 
        
        gameLabel = new Label("Game", 50);
        addObject(gameLabel, 300, 32);
        
        typer = new Typer();
        addObject(typer, 0, 0);
        
        paragraphLabel = new Label(typer.getParagraph(), 32, true);
        addObject(paragraphLabel, 300, 232);  
        
        // intialize the timer and timer label 
        timer = new SimpleTimer();
        timer.mark(); // start timer 
        timerLabel = new Label("Time: " + timerDuration, 20);
        addObject(timerLabel, 50, 50);
    }
    
    public void act (){
        int timeLeft = timerDuration - timer.millisElapsed() / 1000;
        if(timeLeft >= 0)
        {
            timerLabel.setValue("Time: " + timeLeft);
            
        }else 
        {
            //action for when the timer reaches zero 
        }
        
    }
    
    public void act() {
        paragraphLabel.setValue(typer.formatTyped());
    }
    
    private void backMenu()
    {
        Greenfoot.setWorld(home);
    }
}
