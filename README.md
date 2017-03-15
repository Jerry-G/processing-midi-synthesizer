# processing-midi-synthesizer
The goal of this project is to play midi files with simple waves made posible by the minim extention available in processing. Processing is itself an extention of java and can be found at https://processing.org/download/?processing (cross platform).




# Turning midi to csv
Inorder to feed the midi file to this program it must be in .csv file format. The midicsv program does exactly that and can be found at http://www.fourmilab.ch/webtools/midicsv/#Download (cross platform).



# Minim
The minim extention can be downloaded from within the processing program by hovering over the "Sketch" tab in the toolbar, then clicking on "Import Library.." and "Add Library".
![](http://i.imgur.com/Z2YEq1d.png)


Once done a new window will appear. Type "minim" in the search bar, click on the package then on the install button in the lower right hand corner.
![](http://i.imgur.com/Eo1hBej.png)



# Usage
First you must compile and run sound.java
```
javac sound.java
java sound
```
This will produce "player.pde" file. To run that you must open processing then open the pde and hit the play button found in the top left-hand corner. Alternatively in you could run the file processing's own "processing-java" file whitch looks like...
  Linux
```
processing-java --sketch=./"your directory here"/player/ --run
```
  Windows
```
processing-java.exe --sketch=.\"your directory here"\player\ --run
```

Note that this assumes that processing-java is in /usr/local/bin or windows $PATH equivalent. Also note that this requires that the player.pde file be in a directory named "player" because processing requires that.

