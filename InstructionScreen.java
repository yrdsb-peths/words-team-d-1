import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionScreen extends World
{
    private World home;
    String firstInstruction = "Test how fast you can type!!";
    String secondInstruction = "Follow the paragraph given and \n type your fastest without making \n any mistakes!";
    String thirdInstruction = "At the end you will see your \n typing speed and your accuracy!";
    private String[] allText = { firstInstruction, secondInstruction, thirdInstruction };
    private int currentIndex = 0;
    private Label instructionLabel = new Label(allText[currentIndex], 40, true);
    private Label prev;
    private Label next;
    private Label backMenuLabel;
    Button nextButton = new Button(this::nextScreen);
    public InstructionScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.home = home;
        addObject(instructionLabel, 300, 150);
        setBackground(new GreenfootImage("background.png"));
        
        addObject(nextButton, 500, 300);
        next = new Label("next", 20);
        addObject(next, 500, 265);
        
        addObject(new Button(this::prevScreen), 100, 300);
        prev = new Label("previous", 20);
        addObject(prev, 100, 265);
        
        addObject(new Button(this::backMenu), 100, 370);
        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);  
        
        //addObject(new Button(this::goGame), 500, 370);
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 500, 370);
        backMenuLabel = new Label("Continue to game", 20);
        addObject(backMenuLabel, 500, 338);       
    }
    
    private void nextScreen()
    {
        if (currentIndex < allText.length - 1) {
            currentIndex++;
            instructionLabel.setValue(allText[currentIndex]);
        }
        
        if (currentIndex == allText.length - 1) {
            removeObject(next); 
            removeObject(nextButton); 
        }
    }
    
    private void prevScreen()
    {
        if(currentIndex == 0)
        {
            Greenfoot.setWorld(home);
            return;
        }
        else
        {
            currentIndex--;
            instructionLabel.setValue(allText[currentIndex]);
        }
        if (currentIndex < allText.length - 1 && !getObjects(Button.class).contains(nextButton)) 
        {
            addObject(nextButton, 500, 300);
            addObject(next, 500, 265);
        }
    }
    
    private void backMenu()
    {
        Greenfoot.setWorld(home);
    }
    
    
}
