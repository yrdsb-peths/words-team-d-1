public class HighScoreManager {
    private static int bestCPM = 0;
    private static int bestRawCPM = 0; 
    private static double bestAccuracy = 0.0;

    public static void updateHighScores(int cpm, int rawCpm, double accuracy) 
    {
        if (cpm > bestCPM) 
        {
            bestCPM = cpm;
        }
        if (rawCpm > bestRawCPM) 
        {
            bestRawCPM = rawCpm;
        }
        if (accuracy > bestAccuracy) 
        {
            bestAccuracy = accuracy;
        }
    }

    public static int getBestCPM() 
    {
        return bestCPM;
    }

    public static int getBestRawCPM() 
    {
        return bestRawCPM;
    }

    public static double getBestAccuracy() 
    {
        return bestAccuracy;
    }
}
