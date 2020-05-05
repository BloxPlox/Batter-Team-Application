package business;

/*
 * Title: Final Project
 * Date: 4-27-20
 * Author: James Nagy
 */

public class Batter {
    
    //private String date;
    private String playerName;
    private int atBats;
    private int runsScored;
    private int baseHits;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int hitByPitch;
    private int runsBattedIn;
    private int sacrificeFly;
    private int walksAllowed;
    private int strikeOut;
    private int putout;
    private int assist;
    private int leftOnBase;
    
    public Batter() {
        this("", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Batter(String playerName, int atBats, int runsScored, 
                  int baseHits, int doubles, int triples, int homeRuns, 
                  int hitByPitch, int runsBattedIn, int sacrificeFly, 
                  int walksAllowed, int strikeOut, int putout, int assist, 
                  int leftOnBase) {
        
        //this.date = date;
        this.playerName = playerName;
        this.atBats = atBats;
        this.runsScored = runsScored;
        this.baseHits = baseHits;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.hitByPitch = hitByPitch;
        this.runsBattedIn = runsBattedIn;
        this.sacrificeFly = sacrificeFly;
        this.walksAllowed = walksAllowed;
        this.strikeOut = strikeOut;
        this.putout = putout;
        this.assist = assist;
        this.leftOnBase = leftOnBase;
    }
    
//    public String getDate() {
//        return date;
//    }
    
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
    
    public int getDoubles() {
        return doubles;
    }
    
    public int getTriples() {
        return triples;
    }
    
    public int getHomeRuns() {
        return homeRuns;
    }
    
    public int getHitByPitch() {
        return hitByPitch;
    }
    
    public int getRunsBattedIn() {
        return runsBattedIn;
    }
    
    public int getSacrificeFly() {
        return sacrificeFly;
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
