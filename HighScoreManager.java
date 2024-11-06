public class HighScoreManager {
    private static int bestWPM = 0;
    private static int bestRawWPM = 0; 
    private static double bestAccuracy = 0.0;

    public static void updateHighScores(int wpm, int rawWpm, double accuracy) 
    {
        if (wpm > bestWPM) 
        {
            bestWPM = wpm;
        }
        if (rawWpm > bestRawWPM) 
        {
            bestRawWPM = rawWpm;
        }
        if (accuracy > bestAccuracy) 
        {
            bestAccuracy = accuracy;
        }
    }

    public static int getBestWPM() 
    {
        return bestWPM;
    }

    public static int getBestRawWPM() 
    {
        return bestRawWPM;
    }

    public static double getBestAccuracy() 
    {
        return bestAccuracy;
    }
}
