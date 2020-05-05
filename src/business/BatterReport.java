/*
Batter Application Final Project
Author: Nathan Minnick
Date: 4/25/2020
File: Batter.java
*/

package business;

public class BatterReport {
    
    //initializing variables   
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
    private int batID;
    private String batName;
    private double batAvg;
    private double totalBases;
    private double slugPer;
    private double basePer;

    //initializes Batter class
    public BatterReport() {
        this("", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0.0, 0, 0.0, 0.0);
    }

    //adds values to be saved from the Batter class
    public BatterReport(String playerName, int atBats, int runsScored, 
                  int baseHits, int doubles, int triples, int homeRuns, 
                  int hitByPitch, int runsBattedIn, int sacrificeFly, 
                  int walksAllowed, int strikeOut, int putout, int assist, 
                  int leftOnBase, int batID, String batName, double batAvg, 
                  double totalBases, double slugPer, double basePer) {
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
        this.batID = batID;
        this.batName = batName;
        this.batAvg = batAvg;
        this.totalBases = totalBases;
        this.slugPer = slugPer;
        this.basePer = basePer;
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

    //sets batter id
    public void setBatID(int batID) {
        this.batID = batID;
    }
    
    //gets batter id
    public int getBatID() {
        return batID;
    }
    
    //sets batter name
    public void setBatName(String batName) {
        this.batName = batName;
    }

    //gets batter name
    public String getBatName() {
        return batName;
    }
    
    //sets batter average
    public void setBatAvg(double batAvg) {
        this.batAvg = batAvg;
    }

    //gets batter average
    public double getBatAvg() {
        return batAvg;
    }

    //sets total bases
    public void setTotalBases(double totalBases) {
        this.totalBases = totalBases;
    }

    //gets total bases
    public double getTotalBases() {
        return totalBases;
    }
    
    //sets slug percentage
    public void setSlugPer(double slugPer) {
        this.slugPer = slugPer;
    }

    //ges slug percentage
    public double getSlugPer() {
        return slugPer;
    }
    
    //sets base percentage
    public void setBasePer(double basePer) {
        this.basePer = basePer;
    }
    
    //gets base percentage
    public double getBasePer() {
        return basePer;
    }
    
    //sets the slug percentage to be formatted as a percent
//    public String getSlugPerFormatted() {
//        NumberFormat percent = NumberFormat.getPercentInstance();
//        return percent.format(slugPer);
//    }
    
    //sets the base percentage to be formatted as a percent
//    public String getBasePerFormatted() {
//        NumberFormat percent = NumberFormat.getPercentInstance();
//        return percent.format(basePer);
//    }
}