import java.util.Scanner;
import java.io.*;
public class sound {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("play.csv"));
		//open pleay.csv file

		boolean append = true;
		FileWriter write = new FileWriter("player.pde", append);
		PrintWriter file = new PrintWriter(write);
		//create processing file and file writer



		//print all nessesary header code to player.pde
		file.println("import ddf.minim.*;");
		file.println("import ddf.minim.signals.*;");
		file.println("import java.util.*;");
		file.println("import java.io.FileNotFoundException;");
		file.println("import ddf.minim.ugens.*;");
		file.println("");
		file.println("Minim       minim;");
		file.println("AudioOutput out;");
		file.println("");
		file.println("Oscil       wave1;");
		file.println("Oscil       wave2;");
		file.println("Oscil       wave3;");
		file.println("Oscil       wave4;");
		file.println("Oscil       wave5;");
		file.println("Oscil       wave6;");
		file.println("Oscil       wave7;");
		file.println("Oscil       wave8;");
		file.println("Oscil       wave9;");
		file.println("Oscil       wave10;");
		file.println("Oscil       wave11;");
		file.println("Oscil       wave12;");
		file.println("Oscil       wave13;");
		file.println("Oscil       wave14;");
		file.println("");
		file.println("void setup()");
		file.println("{");
		file.println("minim = new Minim(this);");
		file.println("fill(0);");
		file.println("textSize(48);");
		file.println("background(255);");
		file.println("out = minim.getLineOut();");
		file.println("wave1 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave2 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave3 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave4 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave5 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave6 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave7 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave8 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave9 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave10 = new Oscil(0, 1f, Waves.SINE );");
		file.println("wave1.patch(out);");
		file.println("wave2.patch(out);");
		file.println("wave3.patch(out);");
		file.println("wave4.patch(out);");
		file.println("wave5.patch(out);");
		file.println("wave6.patch(out);");
		file.println("wave7.patch(out);");
		file.println("wave8.patch(out);");
		file.println("wave9.patch(out);");
		file.println("wave10.patch(out);");
		file.println("wave1.setWaveform( Waves.QUARTERPULSE );");
		//NOTE setWaveform will set the waveform for all wave objects(voices)
		//other wave options
			//SINE TRIANGLE SQUARE





		//initialize boolean voice variabes to know if a voice is in use
		boolean voice1 = false,voice2 = false,voice3 = false,voice4 = false,voice5 = false;
		boolean voice6 = false,voice7 = false,voice8 = false,voice9 = false,voice10 = false;
		//initialize integer voice variaves to store current note of voice
		int v1=-1,v2=-1,v3=-1,v4=-1,v5=-1,v6=-1,v7=-1,v8=-1,v9=-1,v10=-1;


		//initialize variabes dealing with the passing of time
		int time = 0;
		int prevT = 0;
		int key = 0;
		int quarterT = 0;
		int tempo = 0;
		int bpm =0;
		int clockpermin = 0;
		int clockpersec = 0;
		int clockpermillisec = 0;


		while(scan.hasNextLine()){
		//go through each line of play.csv


			String line = scan.nextLine();
			line = line.substring(3);
			//remove the track number of each line
				//provided that track number is 1 digit will error otherwise

			String[] data = line.split(", ");

			if(line.contains("Header")){
				//get quarter note time from header line
				quarterT= Integer.parseInt(data[4]);
			}

			if(line.contains("Tempo")){
				//cacluate tempo from "Tempo" line and Header information
				tempo= Integer.parseInt(data[2]);
				bpm = 60000000/tempo;
				clockpermin = bpm * quarterT;
				clockpersec = clockpermin/60;
				clockpermillisec = clockpersec/1000;
			}

			if(line.contains("Note_o")){
			//if current line deals with a note on or off then...

				time = Integer.parseInt(data[0]);
				//set current time value



				if(time!=prevT){
					//delay the appropriate miliseconds if time has passed
					file.printf("delay(%d);\n",(int)((time-prevT)*60000)/clockpermin);
				}

				//keep previousTime variabe up to speed
				prevT = time;

				if(line.contains("on")){
				//if a note is to be turned on then
				//select 1st unused voice and print the appropriate amplitude(volume) and frequency(pitch)
					//and update voice variabes
					if(!voice1)
					{
						file.printf("wave%d.setAmplitude(%f);\n",1,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",1,note(Integer.parseInt(data[3])));
						voice1=true;
						v1 = Integer.parseInt(data[3]);
					}else if (!voice2)
					{
						file.printf("wave%d.setAmplitude(%f);\n",2,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",2,note(Integer.parseInt(data[3])));
						voice2=true;
						v2 = Integer.parseInt(data[3]);
					}else if (!voice3)
					{
						file.printf("wave%d.setAmplitude(%f);\n",3,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",3,note(Integer.parseInt(data[3])));
						voice3=true;
						v3 = Integer.parseInt(data[3]);
					}else if (!voice4)
					{
						file.printf("wave%d.setAmplitude(%f);\n",4,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",4,note(Integer.parseInt(data[3])));
						voice4=true;
						v4 = Integer.parseInt(data[3]);
					}else if (!voice5)
					{
						file.printf("wave%d.setAmplitude(%f);\n",5,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",5,note(Integer.parseInt(data[3])));
						voice5=true;
						v5 = Integer.parseInt(data[3]);
					}else if (!voice6)
					{
						file.printf("wave%d.setAmplitude(%f);\n",6,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",6,note(Integer.parseInt(data[3])));
						voice6=true;
						v6 = Integer.parseInt(data[3]);
					}else if (!voice7)
					{
						file.printf("wave%d.setAmplitude(%f);\n",7,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",7,note(Integer.parseInt(data[3])));
						voice7=true;
						v7 = Integer.parseInt(data[3]);
					}else if (!voice8)
					{
						file.printf("wave%d.setAmplitude(%f);\n",8,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",8,note(Integer.parseInt(data[3])));
						voice8=true;
						v8 = Integer.parseInt(data[3]);
					}else if (!voice9)
					{
						file.printf("wave%d.setAmplitude(%f);\n",9,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",9,note(Integer.parseInt(data[3])));
						voice9=true;
						v9 = Integer.parseInt(data[3]);
					}else if (!voice10)
					{
						file.printf("wave%d.setAmplitude(%f);\n",10,(float)((float)Integer.parseInt(data[3])-(float)1)/((float)127-(float)1));
						file.printf("wave%d.setFrequency(%f);\n",10,note(Integer.parseInt(data[3])));
						voice10=true;
						v10 = Integer.parseInt(data[3]);
					}
				}else{
				//in this case a note must be turned off
				//check if the current note matches a voice and if so then set the amplitude(volume) to 0
					//and mark voice and "unused"
					if(Integer.parseInt(data[3])==v1)
					{
						file.printf("wave%d.setAmplitude(0);\n",1);
						voice1=false;
					}else if (Integer.parseInt(data[3])==v2)
					{
						file.printf("wave%d.setAmplitude(0);\n",2);
						voice2=false;
					}else if (Integer.parseInt(data[3])==v3)
					{
						file.printf("wave%d.setAmplitude(0);\n",3);
						voice3=false;
					}else if (Integer.parseInt(data[3])==v4)
					{
						file.printf("wave%d.setAmplitude(0);\n",4);
						voice4=false;
					}else if (Integer.parseInt(data[3])==v5)
					{
						file.printf("wave%d.setAmplitude(0);\n",5);
						voice5=false;
					}else if (Integer.parseInt(data[3])==v6)
					{
						file.printf("wave%d.setAmplitude(0);\n",6);
						voice6=false;
					}else if (Integer.parseInt(data[3])==v7)
					{
						file.printf("wave%d.setAmplitude(0);\n",7);
						voice7=false;
					}else if (Integer.parseInt(data[3])==v8)
					{
						file.printf("wave%d.setAmplitude(0);\n",8);
						voice8=false;
					}else if (Integer.parseInt(data[3])==v9)
					{
						file.printf("wave%d.setAmplitude(0);\n",9);
						voice9=false;
					}else if (Integer.parseInt(data[3])==v10)
					{
						file.printf("wave%d.setAmplitude(0);\n",10);
						voice10=false;
					}
				}
			}
		}

		//ending the player.pde file
		file.println("exit();");
		file.println("}");
		//closeing the player.pde file and play.csv file
		file.close();
		scan.close();
	}







	public static float note(int data){
		//convert from midi note number to note frequency
		float out = 0;
		switch(data){
		case 0:
			out = (float) 8.175799;
			break;
		case 1:
			out = (float) 8.661957;
			break;
		case 2:
			out = (float) 9.177024;
			break;
		case 3:
			out = (float) 9.722718;
			break;
		case 4:
			out = (float) 10.300861;
			break;
		case 5:
			out = (float) 10.913383;
			break;
		case 6:
			out = (float) 11.562325;
			break;
		case 7:
			out = (float) 12.249857;
			break;
		case 8:
			out = (float) 12.978271;
			break;
		case 9:
			out = (float) 13.750000;
			break;
		case 10:
			out = (float) 14.567617;
			break;
		case 11:
			out = (float) 15.433853;
			break;
		case 12:
			out = (float) 16.351599;
			break;
		case 13:
			out = (float) 17.323914;
			break;
		case 14:
			out = (float) 18.354048;
			break;
		case 15:
			out = (float) 19.445436;
			break;
		case 16:
			out = (float) 20.601723;
			break;
		case 17:
			out = (float) 21.826765;
			break;
		case 18:
			out = (float) 23.124651;
			break;
		case 19:
			out = (float) 24.499714;
			break;
		case 20:
			out = (float) 25.956543;
			break;
		case 21:
			out = (float) 27.500000;
			break;
		case 22:
			out = (float) 29.135235;
			break;
		case 23:
			out = (float) 30.867706;
			break;
		case 24:
			out = (float) 32.703197;
			break;
		case 25:
			out = (float) 34.647827;
			break;
		case 26:
			out = (float) 36.708096;
			break;
		case 27:
			out = (float) 38.890873;
			break;
		case 28:
			out = (float) 41.203445;
			break;
		case 29:
			out = (float) 43.653530;
			break;
		case 30:
			out = (float) 46.249302;
			break;
		case 31:
			out = (float) 48.999428;
			break;
		case 32:
			out = (float) 51.913086;
			break;
		case 33:
			out = (float) 55.000000;
			break;
		case 34:
			out = (float) 58.270470;
			break;
		case 35:
			out = (float) 61.735413;
			break;
		case 36:
			out = (float) 65.406395;
			break;
		case 37:
			out = (float) 69.295654;
			break;
		case 38:
			out = (float) 73.416191;
			break;
		case 39:
			out = (float) 77.781746;
			break;
		case 40:
			out = (float) 82.406891;
			break;
		case 41:
			out = (float) 87.307060;
			break;
		case 42:
			out = (float) 92.498604;
			break;
		case 43:
			out = (float) 97.998856;
			break;
		case 44:
			out = (float) 103.826172;
			break;
		case 45:
			out = (float) 110.000000;
			break;
		case 46:
			out = (float) 116.540939;
			break;
		case 47:
			out = (float) 123.470825;
			break;
		case 48:
			out = (float) 130.812790;
			break;
		case 49:
			out = (float) 138.591309;
			break;
		case 50:
			out = (float) 146.832382;
			break;
		case 51:
			out = (float) 155.563492;
			break;
		case 52:
			out = (float) 164.813782;
			break;
		case 53:
			out = (float) 174.614120;
			break;
		case 54:
			out = (float) 184.997208;
			break;
		case 55:
			out = (float) 195.997711;
			break;
		case 56:
			out = (float) 207.652344;
			break;
		case 57:
			out = (float) 220.000000;
			break;
		case 58:
			out = (float) 233.081879;
			break;
		case 59:
			out = (float) 246.941650;
			break;
		case 60:
			out = (float) 261.625580;
			break;
		case 61:
			out = (float) 277.182617;
			break;
		case 62:
			out = (float) 293.664764;
			break;
		case 63:
			out = (float) 311.126984;
			break;
		case 64:
			out = (float) 329.627563;
			break;
		case 65:
			out = (float) 349.228241;
			break;
		case 66:
			out = (float) 369.994415;
			break;
		case 67:
			out = (float) 391.995422;
			break;
		case 68:
			out = (float) 415.304688;
			break;
		case 69:
			out = (float) 440.000000;
			break;
		case 70:
			out = (float) 466.163757;
			break;
		case 71:
			out = (float) 493.883301;
			break;
		case 72:
			out = (float) 523.251160;
			break;
		case 73:
			out = (float) 554.365234;
			break;
		case 74:
			out = (float) 587.329529;
			break;
		case 75:
			out = (float) 622.253967;
			break;
		case 76:
			out = (float) 659.255127;
			break;
		case 77:
			out = (float) 698.456482;
			break;
		case 78:
			out = (float) 739.988831;
			break;
		case 79:
			out = (float) 783.990845;
			break;
		case 80:
			out = (float) 830.609375;
			break;
		case 81:
			out = (float) 880.000000;
			break;
		case 82:
			out = (float) 932.327515;
			break;
		case 83:
			out = (float) 987.766602;
			break;
		case 84:
			out = (float) 1046.502319;
			break;
		case 85:
			out = (float) 1108.730469;
			break;
		case 86:
			out = (float) 1174.659058;
			break;
		case 87:
			out = (float) 1244.507935;
			break;
		case 88:
			out = (float) 1318.510254;
			break;
		case 89:
			out = (float) 1396.912964;
			break;
		case 90:
			out = (float) 1479.977661;
			break;
		case 91:
			out = (float) 1567.981689;
			break;
		case 92:
			out = (float) 1661.218750;
			break;
		case 93:
			out = (float) 1760.000000;
			break;
		case 94:
			out = (float) 1864.655029;
			break;
		case 95:
			out = (float) 1975.533203;
			break;
		case 96:
			out = (float) 2093.004639;
			break;
		case 97:
			out = (float) 2217.460938;
			break;
		case 98:
			out = (float) 2349.318115;
			break;
		case 99:
			out = (float) 2489.015869;
			break;
		case 100:
			out = (float) 2637.020508;
			break;
		case 101:
			out = (float) 2793.825928;
			break;
		case 102:
			out = (float) 2959.955322;
			break;
		case 103:
			out = (float) 3135.963379;
			break;
		case 104:
			out = (float) 3322.437500;
			break;
		case 105:
			out = (float) 3520.000000;
			break;
		case 106:
			out = (float) 3729.310059;
			break;
		case 107:
			out = (float) 3951.066406;
			break;
		case 108:
			out = (float) 4186.009277;
			break;
		case 109:
			out = (float) 4434.921875;
			break;
		case 110:
			out = (float) 4698.636230;
			break;
		case 111:
			out = (float) 4978.031738;
			break;
		case 112:
			out = (float) 5274.041016;
			break;
		case 113:
			out = (float) 5587.651855;
			break;
		case 114:
			out = (float) 5919.910645;
			break;
		case 115:
			out = (float) 6271.926758;
			break;
		case 116:
			out = (float) 6644.875000;
			break;
		case 117:
			out = (float) 7040.000000;
			break;
		case 118:
			out = (float) 7458.620117;
			break;
		case 119:
			out = (float) 7902.132813;
			break;
		case 120:
			out = (float) 8372.018555;
			break;
		case 121:
			out = (float) 8869.843750;
			break;
		case 122:
			out = (float) 9397.272461;
			break;
		case 123:
			out = (float) 9956.063477;
			break;
		case 124:
			out = (float) 10548.082031;
			break;
		case 125:
			out = (float) 11175.303711;
			break;
		case 126:
			out = (float) 11839.821289;
			break;
		case 127:
			out = (float) 12543.853516;
			break;
		}
		return out;
	}
}
