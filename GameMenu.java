import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameMenu extends World
{
    private Label gameLabel;
    private World home;
    public GameMenu(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.home = home;
        gameLabel = new Label("Game", 50);
        addObject(gameLabel, 300, 100);
        
        
    }
}
