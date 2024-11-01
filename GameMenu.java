import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameMenu extends World
{
    private Label gameLabel;
    private Typer typer;
    private Label paragraphLabel;
    private World home;

    public GameMenu(World home) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("background.png"));
        this.home = home;
        gameLabel = new Label("Game", 50);
        addObject(gameLabel, 300, 32);
        
        typer = new Typer();
        addObject(typer, 0, 0);
        
        paragraphLabel = new Label(typer.getParagraph(), 32, true);
        addObject(paragraphLabel, 300, 232);   
    }
    
    private void backMenu()
    {
        Greenfoot.setWorld(home);
    }
}
