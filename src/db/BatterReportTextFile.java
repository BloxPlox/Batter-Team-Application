/*
Batter Application Final Project
Author: Nathan Minnick
Date: 5/2/2020
File: BatterReportTextFile.java
*/

package db;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import business.BatterReport;
import gui.BatterGUI;

//creates BatterReportTextFile for storing values
public final class BatterReportTextFile {
    private List<BatterReport> batters = null;
    private Path battersPath = null;
    private File battersFile = null;
    private final String FIELD_SEP = "\t";

    public BatterReportTextFile() {
        
        String gameDate = BatterGUI.getReportGameDate();
        String fileName = "batter_report_(" + gameDate + ").txt";
        
        //gets the file path
        // James Nagy - Renamed the file so it's not the same as the batters.txt
        battersPath = Paths.get(fileName);
        //battersPath = Paths.get("batterReport.txt");
        try {
            //if the file path does not exist, it will tell the user that it is creating the path
            if (Files.notExists(battersPath)) {
                System.out.println("********************");
                System.out.println("Data file not found.");
                System.out.println("********************");
                System.out.println("Creating file: " + battersPath.toAbsolutePath() + "\n");
                Files.createFile(battersPath);
            }
        } 
        catch(IOException e) {
            System.out.println(e);
        }
        battersFile = battersPath.toFile();
        batters = new ArrayList<>();
    }

//    @Override
//    public List<BatterReport> getAll() {
//        //lists the batters
//        if (batters != null) {
//            return batters;
//        }
//
//        //if there is batters saved, it will list them
//        batters = new ArrayList<>();
//        if (Files.exists(battersPath)) {
//            try (BufferedReader in = new BufferedReader(new FileReader(battersFile))) 
//            {
//                String line = in.readLine();
//                while (line != null) {
//                    String[] fields = line.split(FIELD_SEP);
//                    int batID = Integer.valueOf(fields[0]);
//                    String batName = fields[1];
//                    int batAvg = Integer.valueOf(fields[2]);
//                    int totalBases = Integer.valueOf(fields[3]);
//                    double slugPer = Double.valueOf(fields[4]);
//                    double basePer = Double.valueOf(fields[5]);
//                    
//                    BatterReport b = new BatterReport(batID, batName, batAvg, totalBases, slugPer, basePer);
//                    batters.add(b);
//                }
//            } catch (IOException e) {
//                System.out.println(e);
//                return null;
//            }
//        } else {
//            System.out.println(
//                    battersPath.toAbsolutePath() + " doesn't exist.");
//            return null;            
//        }
//        return batters;
//    }

//    @Override
    public BatterReport get(int batID) {
        //gets all batters
        for (BatterReport b : batters) {
            if (b.getBatID() == batID) {
                return b;
            }
        }
        return null;
    }

    //saves all batter info to the batter file
    private boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(battersFile)), true))  
        {           
            for (BatterReport b : batters) {
                out.print(b.getBatID() + " " + b.getBatName() + FIELD_SEP + "\n"
                + FIELD_SEP + "(AB): " + b.getAtBats() + " | "
                + "(R): " + b.getRunsScored() + " | "
                + "(H/1B): " + b.getBaseHits() + " | "
                + "(2B): " + b.getDoubles() + " | " 
                + "(3B): " + b.getTriples() + " | "
                + "(HR): " + b.getHomeRuns() + " | "
                + "(HBP): " + b.getHitByPitch() + " | "
                + "(RBI): " + b.getRunsBattedIn() + " | "
                + "(SF): " + b.getSacrificeFly() + " | "
                + "(BB): " + b.getWalksAllowed() + " | "
                + "(SO): " + b.getStrikeOut() + " | "
                + "(PO): " + b.getPutout() + " | "
                + "(A): " + b.getAssist() + " | "
                + "(LOB): " + b.getLeftOnBase() + "\n"
                + FIELD_SEP + "(BA)" + b.getBatAvg() + " | " 
                + "(TB)" + b.getTotalBases() + " | " 
                + "(SLG)" + b.getSlugPer() + " | "
                + "(OBP)" + b.getBasePer() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
    
    //@Override
    public boolean add(BatterReport b) {
        batters.add(b);
        return this.saveAll();
    }
//
//    @Override
//    public boolean delete(BatterReport b) {
//        batters.remove(b);
//        return this.saveAll();
//    }
//
//    @Override
//    public boolean update(BatterReport newBatter) {
//        BatterReport oldBatter = this.get(newBatter.getBatID());
//        int i = batters.indexOf(oldBatter);
//        batters.remove(i);
//
//        batters.add(i, newBatter);
//
//        return this.saveAll();
//    }
}