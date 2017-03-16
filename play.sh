#!/bin/bash
rm -f play.csv

for i in "$@"
do
	cp $i play.csv
	rm -f player.pde
	javac sound.java
	java sound
	echo playing $i
	processing-java --sketch=/home/jg/Documents/player/ --run
	sleep 5
	rm -f player.pde
	rm -f sound.class
	rm -f play.csv
done


exit
