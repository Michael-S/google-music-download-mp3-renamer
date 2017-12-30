
import java.io.*;

public class Main {

   public static FileFilter dirFilter = new FileFilter() {
      public boolean accept(File entry) {
         return entry.isDirectory();
      }
   };

   public static FileFilter mp3FileOnlyFilter = new FileFilter() {
      public boolean accept(File entry) {
         return entry.isFile() && entry.getName().toLowerCase().endsWith(".mp3");
      }
   };

   public static void main (String [] args) throws Exception {
      if (args.length != 1) {
         System.out.println("Expected a single directory name as the input. Cannot run.");
         return;
      }
      File topLevelDir = new File(args[0]);
      if (!topLevelDir.exists() || !topLevelDir.isDirectory()) {
         System.out.println("The directory named \"" + args[0] + "\" was not found.");
         return;
      }
      File [] artistdirs = topLevelDir.listFiles(dirFilter);
      for (File artistdir : artistdirs) {
         processSingleDirectory(topLevelDir, artistdir);
      }
   }

   static void processSingleDirectory(File topDir, File artistdir) {
      if (topDir == null) {
         System.out.println("Logic error, no top level directory specified.");
         return;
      }
      if (artistdir == null || !artistdir.isDirectory()) {
         System.out.println("Got unexpected subdirectory (?) " + artistdir + ".");
         return;
      }
      String artistName = artistdir.getName();
      File [] albumDirs = artistdir.listFiles(dirFilter);
      for (File albumDir : albumDirs) {
         File [] songs = albumDir.listFiles(mp3FileOnlyFilter);
         for (File song : songs) {
            String originalName = song.getName();
            String replacementName;
            if (originalName.matches("^\\d+\\..*$")) {
               replacementName = originalName.substring(originalName.indexOf(". ") + 2);
            } else if (originalName.matches("^\\d+ - .*$")) {
               replacementName = originalName.substring(originalName.indexOf("- ") + 2);
            } else if (originalName.matches("^\\d{1,2} .*$")) {
               replacementName = originalName.substring(originalName.indexOf(" ") + 1);
            } else {
               System.out.println("No name pattern match to \"" + originalName + "\".");
               replacementName = originalName;
            }
            String fullReplacement = topDir.getAbsolutePath() + File.separator +
               replacementName.substring(0, replacementName.length() - 4) + " - " + artistName + ".mp3";
            System.out.println("moving \"" + song.getAbsolutePath() + "\"\n        to \"" + fullReplacement + "\".");
            // song.renameTo(new File(fullReplacement));
        }
     }
  }

}
