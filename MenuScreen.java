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
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("monkey.png"));

        welcomeLabel = new Label("Welcome to Monkey Type!", 35);
        addObject(welcomeLabel, 300, 160);
        
        instructionLabel = new Label("View Instructions", 18);
        addObject(instructionLabel, 300, 310);
        addObject(new Button(() -> Greenfoot.setWorld(new InstructionScreen(this))), 300, 345);

        //(new Button(() -> goHighScores()), 300, 275);
        highScoreLabel = new Label("View your best WPM", 18);
        addObject(highScoreLabel, 300, 240);
        addObject(new Button(() -> Greenfoot.setWorld(new HighScoreScreen(this))), 300, 275);

    }
}
