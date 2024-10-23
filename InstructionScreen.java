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
        
        
    }
}
