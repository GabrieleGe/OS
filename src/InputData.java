
import javax.swing.*;

import java.io.*;
import java.lang.String.*;
import java.util.*;
import java.awt.*;

/**
 * Created by sattas on 3/28/14.
 */
public class InputData {

    GUI t = GUI.getInstance();
    public static int size = 0;
    public static ArrayList timeList = new ArrayList();
    public static final int[] memarray = new int[]{
            255,511,767,1023,1279,1535,1791,2047,2303,2559,2815,3071
    };


    public void readFile() throws IOException {
        try{

            FileInputStream fstream = new FileInputStream("dataIn.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            int memi = -1;
            int strLineMemory = 59;

            while ((strLine = br.readLine()) != null)   {

                t.data[strLineMemory++][1] = String.valueOf(strLine);
                memi++;

                size++;
                while((strLine = br.readLine()) != null && !strLine.startsWith("*")){

                    String[] arr = strLine.split(" ");
                    String command = arr[0];
                    String operand = arr[1];

                    toMemory(command, operand, memarray[memi]);
                    memarray[memi] = memarray[memi] +  2;
                    System.out.printf("%s %s ", command, operand);
                }

            }

            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        MOSMain mos = new MOSMain();
        mos.planner();

        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(830, 800);
        t.setVisible(true);
        t.setTitle("Printer");
        sortTime();
    }


    public void toMemory(String command, String operand,int place ){

        if (GUI.data[place][1].equals("0") ){
            GUI.data[place][1] = command;
            GUI.data[place+1][1] = operand;
            t.textfieldIC.setText("80");
            t.textfieldTI.setText("10");}


        t.textfieldMODE.setText("V");
        //pradiniai duomenys

        t.data[0][1] = "6"; //sokti, jei iskilo PI inerrupt
        t.data[1][1] = "18"; //sokti, jei iskilo SI inerrupt
        t.data[2][1] = "28"; //sokti, jei iskilo TI inerrupt
        t.data[3][1] = "38"; //sokti, jei iskilo IOI inerrupt

        //jei iskilo PI interupt:
        t.data[6][1] = "MVR1";
        t.data[7][1] = "48";
        t.data[8][1] = "LR1";
        t.data[9][1] = "17";
        t.data[10][1] = "MVR2";
        t.data[11][1] = "23";
        t.data[12][1] = "AD1";
        t.data[13][1] = "17";
        t.data[14][1] = "exit";

        //jei iskilo SI interupt:
        t.data[18][1] = "MVR1";
        t.data[19][1] = "478";
        t.data[20][1] = "LR1";
        t.data[21][1] = "27";
        t.data[22][1] = "MVR2";
        t.data[23][1] = "95";
        t.data[24][1] = "AD1";
        t.data[25][1] = "27";
        t.data[26][1] = "exit";

        //jei iskilo TI interupt:
        t.data[28][1] = "MVR1";
        t.data[29][1] = "72";
        t.data[30][1] = "LR1";
        t.data[31][1] = "37";
        t.data[32][1] = "MVR2";
        t.data[33][1] = "24";
        t.data[34][1] = "AD1";
        t.data[35][1] = "37";
        t.data[36][1] = "exit";

        //jei iskilo IOI interupt:
        t.data[38][1] = "MVR1";
        t.data[39][1] = "486";
        t.data[40][1] = "LR1";
        t.data[41][1] = "49";
        t.data[42][1] = "MVR2";
        t.data[43][1] = "64";
        t.data[44][1] = "AD1";
        t.data[45][1] = "49";
        t.data[46][1] = "exit";

    }

    public void sortTime(){
        int i = 59;
        //int [] temp = new int[InputData.size];

        while(Integer.valueOf(t.data[i][1]) != 0){
            timeList.add(Integer.valueOf(t.data[i][1]));
            i++;
        }
        i = 59;

        Collections.sort(timeList);


        //return(temp);

        //System.out.println(getMinValue(temp));
        //for (int a=0;a<InputData.size;a++){
        //	data[i][1] = String.valueOf(temp[a]);
        //	i++;
        //}
    }
}