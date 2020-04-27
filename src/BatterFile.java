
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
    private String document = "batter.txt";

    public BatterFile() {
        batterPath = Paths.get(document);
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
                                     new FileReader(document))) {

                // read batter from file into array list
                String line = in.readLine();
                while (line != null) {
                    
                    String[] fields = line.split("~");
                    String date = fields[0];
                    String playerName = fields[1];
                    int atBats = Integer.parseInt(fields[2]);
                    int runsScored = Integer.parseInt(fields[2]);
                    int baseHits = Integer.parseInt(fields[2]);
                    int runsBattedIn = Integer.parseInt(fields[2]);
                    int walksAllowed = Integer.parseInt(fields[2]);
                    int strikeOut = Integer.parseInt(fields[2]);
                    int putout = Integer.parseInt(fields[2]);
                    int assist = Integer.parseInt(fields[2]);
                    int leftOnBase = Integer.parseInt(fields[2]);

                    Batter b = new Batter(date, playerName, atBats, runsScored, 
                                      baseHits, runsBattedIn, walksAllowed, 
                                      strikeOut, putout, assist, leftOnBase);
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
                               new FileWriter(document)), true)) {

            // write all batter in the array list
            // to the file
            for (Batter b : batter) {
                out.print(b.getDate() + "~");
                out.print(b.getPlayerName() + "~");
                out.print(b.getAtBats() + "~");
                out.print(b.getRunsScored() + "~");
                out.print(b.getBaseHits() + "~");
                out.print(b.getRunsBattedIn() + "~");
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
