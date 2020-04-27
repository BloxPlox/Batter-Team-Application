/*
 * Title: Final Project
 * Date: 4-27-20
 * Author: James Nagy
 */

public class Batter {
    
    private String date;
    private String playerName;
    private int atBats;
    private int runsScored;
    private int baseHits;
    private int runsBattedIn;
    private int walksAllowed;
    private int strikeOut;
    private int putout;
    private int assist;
    private int leftOnBase;
    
    public Batter() {
        this("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Batter(String date, String playerName, int atBats, int runsScored, 
                  int baseHits, int runsBattedIn, int walksAllowed, 
                  int strikeOut, int putout, int assist, int leftOnBase) {
        
        this.date = date;
        this.playerName = playerName;
        this.atBats = atBats;
        this.runsScored = runsScored;
        this.baseHits = baseHits;
        this.runsBattedIn = runsBattedIn;
        this.walksAllowed = walksAllowed;
        this.strikeOut = strikeOut;
        this.putout = putout;
        this.assist = assist;
        this.leftOnBase = leftOnBase;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public int getAtBats() {
        return atBats;
    }
    
    public int getRunsScored() {
        return runsScored;
    }
    
    public int getBaseHits() {
        return baseHits;
    }
    
    public int getRunsBattedIn() {
        return runsBattedIn;
    }
    
    public int getWalksAllowed() {
        return walksAllowed;
    }
    
    public int getStrikeOut() {
        return strikeOut;
    }
    
    public int getPutout() {
        return putout;
    }
    
    public int getAssist() {
        return assist;
    }
    
    public int getLeftOnBase() {
        return leftOnBase;
    }
}
