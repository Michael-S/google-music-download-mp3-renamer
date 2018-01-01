# google-music-download-mp3-renamer

**Note:** I host all of my git repositories using [gogs.io](https://gogs.io) on the [Sandstorm.io](https://sandstorm.io) open source hosting. I only set up Github as a second remote because everyone checks here first.

When downloading music from the Google Music Manager app, it's divided into directories with the top level directory as the artist, second level directory as the album, and the file as the track number in the album and the song name. To make matters more complicated, Google does not include the ID3 tags for the MP3 files.

I want all of the music files to be in one directory in the format:
track-name - artist-name.mp3

So instead of
/home/me/Music/Weird Al Yankovic/Mandatory Fun/5 Word Crimes.mp3
I want
/home/me/Music/Word Crimes - Weird Al Yankovic.mp3
(or on Microsoft Windows, C:\Users\me\Music\Word Crimes - Weird Al Yankovic.mp3)

Many older MP3 players play tracks in alphabetical order by name, so leaving the track number in place causes unpredictable playlist ordering.

To compile this, you need a Java Development Kit (Java JDK) on your machine.  You can download it from:
http://www.oracle.com/technetwork/java/javase/downloads/index.html
or
https://www.azul.com/downloads/zulu/
or if you run Linux you can usually get it by typing "sudo apt install openjdk-8-jdk" or "sudo dnf install openjdk8" or similar.
This code does not use any newer Java features, so an older JDK is fine.

Once your JDK is installed properly, open a terminal prompt to the directory of this project and type:
`javac Main.java`
and then
`java Main (path to your files)`
So if your files are on Microsoft Windows in C:\Users\bob\Music  then
`java Main C:\Users\bob\Music`
If your files are on Linux in /home/bob/Music then
`java Main /home/bob/Music`

Weird Al Yankovic and his music, Google, Oracle, Azul Systems, Microsoft Windows, and Linux are names and products owned by their respective owners and I have no affiliation or special rights to use them.

