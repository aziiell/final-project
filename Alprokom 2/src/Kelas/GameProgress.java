package Kelas;

public class GameProgress {
    private static GameProgress instance;
    private int totalScore;
    private int remainingLives;
    private boolean[] completedLevels;

    private GameProgress() {
        this.totalScore = 0;
        this.remainingLives = 3;
        this.completedLevels = new boolean[5]; 
    }
    
    public int getRemainingLives() {
        return remainingLives;
    }
    public void setRemainingLives(int lives) {
        this.remainingLives = lives;
    }
    
    public static synchronized GameProgress getInstance() {
        if (instance == null) {
            instance = new GameProgress();
        }
        return instance;
    }

    public void completeLevel(int levelIndex, int scoreEarned) {
        if (levelIndex >= 0 && levelIndex < completedLevels.length) {
            completedLevels[levelIndex] = true;
            totalScore += scoreEarned;
            
            if (levelIndex + 1 < completedLevels.length) {
            completedLevels[levelIndex + 1] = false; 
            }
        }
    }

    public boolean isLevelCompleted(int levelIndex) {
        if (levelIndex >= 0 && levelIndex < completedLevels.length) {
            return completedLevels[levelIndex];
        }
        return false;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void resetProgress() {
        this.totalScore = 0;
        this.completedLevels = new boolean[5];
    }

    public boolean[] getCompletedLevels() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}