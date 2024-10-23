import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionScreen extends World
{
    private World home;
    String firstInstruction = "Instruction 1";
    String secondInstruction = "Instruction 2";
    String thirdInstruction = "Instruction 3";
    private String[] allText = { firstInstruction, secondInstruction, thirdInstruction };
    private int currentIndex = 0;
    private Label instructionLabel = new Label(allText[currentIndex], 50);
    
    public InstructionScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.home = home;
        addObject(instructionLabel, 300, 150);
        
        //addObject(new Button(this::nextScreen), 500, 300);
        goNext = new Label("next", 20);
        addObject(goNext, 500, 265);
        
        //addObject(new Button(this::prevScreen), 100, 300);
        goBack = new Label("back", 20);
        addObject(goBack, 100, 265);
        
        //addObject(new Button(this::backMenu), 100, 370);
        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);        
    }
    
    private void nextScreen()
    {
        if (currentIndex < allText.length - 1) {
            currentIndex++;
            instructionLabel.setValue(allText[currentIndex]);
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
    }
}
