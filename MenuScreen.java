import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{

    /**
     * Constructor for objects of class MenuScreen.
     * 
     */

    Label welcomeLabel;
    Label instructionLabel;
    Label highScoreLabel;
    Label gameLabel;
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("monkey.png"));

        welcomeLabel = new Label("Welcome to Monkey Type!", 40);
        addObject(welcomeLabel, 300, 130);
        
        instructionLabel = new Label("View Instructions", 18);
        addObject(instructionLabel, 300, 310);
        addObject(new Button(() -> Greenfoot.setWorld(new InstructionScreen(this))), 300, 345);

        //(new Button(() -> goHighScores()), 300, 275);
        highScoreLabel = new Label("View your best CPM", 18);
        addObject(highScoreLabel, 300, 240);
        addObject(new Button(() -> Greenfoot.setWorld(new HighScoreScreen(this))), 300, 275);
        
        gameLabel = new Label("Click here to begin", 18);
        addObject(gameLabel, 300, 170);
        //addObject(new Button(() -> Greenfoot.setWorld(new GameMenu(this))), 300, 200);
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 300, 200);
    }
    
    
}
