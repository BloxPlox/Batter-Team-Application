package db;

/*
 * Title: Final Project
 * Date: 4-27-20
 * Author: James Nagy
 */

import business.Batter;
import gui.BatterGUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class BatterFile {
    
    private ArrayList<Batter> batter = null;
    private Path batterPath = null;
    //private String document = "batter.txt";
    private String fileName = null;

    public BatterFile(String gameDate) {
        
        fileName = "batter_stats_(" + gameDate + ").txt";
        
        batterPath = Paths.get(fileName);
        try {
            // if the file doesn't exist, it is created
            if (Files.notExists(batterPath)) {
                System.out.println("Text file '" + batterPath + "' doesn't exist.");
                System.out.println("Creating file: " + 
                        batterPath.toAbsolutePath() + "\n");
                Files.createFile(batterPath);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        batter = this.getAll();
    }
    
    public BatterFile() {
        
        String gameDate = BatterGUI.getGameDate();
        fileName = "batter_stats_(" + gameDate + ").txt";
        
        batterPath = Paths.get(fileName);
        try {
            // if the file doesn't exist, it is created
            if (Files.notExists(batterPath)) {
                System.out.println("Text file '" + batterPath + "' doesn't exist.");
                System.out.println("Creating file: " + 
                        batterPath.toAbsolutePath() + "\n");
                Files.createFile(batterPath);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        batter = this.getAll();
    }

    public ArrayList<Batter> getAll() {
        // if the batter file has already been read, don't read it again
        if (batter != null) {
            return batter;
        }        
        batter = new ArrayList<>();
        if (Files.exists(batterPath)) {
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(fileName))) {

                // read batter from file into array list
                String line = in.readLine();
                while (line != null) {
                    
                    String[] fields = line.split("~");
                    
                    String playerName = fields[0];                   
                    int atBats = Integer.parseInt(fields[1]);
                    int runsScored = Integer.parseInt(fields[2]);
                    int baseHits = Integer.parseInt(fields[3]);
                    int doubles = Integer.parseInt(fields[4]);
                    int triples = Integer.parseInt(fields[5]);
                    int homeRuns = Integer.parseInt(fields[6]);
                    int hitByPitch = Integer.parseInt(fields[7]);
                    int runsBattedIn = Integer.parseInt(fields[8]);
                    int sacrificeFly = Integer.parseInt(fields[9]);
                    int walksAllowed = Integer.parseInt(fields[10]);
                    int strikeOut = Integer.parseInt(fields[11]);
                    int putout = Integer.parseInt(fields[12]);
                    int assist = Integer.parseInt(fields[13]);
                    int leftOnBase = Integer.parseInt(fields[14]);

                    Batter b = new Batter(playerName, atBats, runsScored, 
                                      baseHits, doubles, triples, homeRuns, 
                                      hitByPitch, runsBattedIn, sacrificeFly, 
                                      walksAllowed, strikeOut, putout, assist, 
                                      leftOnBase);
                    batter.add(b);
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            System.out.println(batterPath.toAbsolutePath() + " doesn't exist.");
            return null;            
        }
        return batter;
    }
    
    private boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(fileName)), true)) {

            // write all batter in the array list
            // to the file
            for (Batter b : batter) {
                //out.print(b.getDate() + "~");
                out.print(b.getPlayerName() + "~");
                out.print(b.getAtBats() + "~");
                out.print(b.getRunsScored() + "~");
                out.print(b.getBaseHits() + "~");
                out.print(b.getDoubles() + "~");
                out.print(b.getTriples() + "~");
                out.print(b.getHomeRuns() + "~");
                out.print(b.getHitByPitch() + "~");
                out.print(b.getRunsBattedIn() + "~");
                out.print(b.getSacrificeFly() + "~");
                out.print(b.getWalksAllowed() + "~");
                out.print(b.getStrikeOut() + "~");
                out.print(b.getPutout() + "~");
                out.print(b.getAssist() + "~");
                out.print(b.getLeftOnBase() + "\n");
                
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean add(Batter b) {
        batter.add(b);
        return this.saveAll();
    }
    
//    public boolean delete(Batter b) {
//        batter.remove(b);
//        return this.saveAll();
//    }
}
