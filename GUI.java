import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GUI extends JFrame {
    private static GUI instance = null;
    public static String data[][] = new String[4096][2];
    public static boolean endProc = false;
    public static boolean newProc = true;
    public static boolean endMos = false;
    public boolean start = true;
    public static int procPlace = 0;
    public static boolean virtualMachineProc = false;
    public static boolean printer = false;

    public static JButton StepByStepButton;
    public static JButton MOSStepByStepButton;
    JLabel R1;

    public JTextField textfieldR1;
    JLabel R2;
    public JTextField textfieldR2;
    JLabel IC;
    public JTextField  textfieldIC;
    JLabel C;
    public JTextField textfieldC;
    JLabel PLR;
    public JTextField textfieldPLR;
    JLabel PI;
    public JTextField textfieldPI;
    JLabel pranesPrLoader;
    public JTextField textfieldPranesPrLoader;
    JLabel MOSPab;
    public JTextField textfieldMOSPab;
    JLabel uzduotIsoAtmntyje;
    public JTextField textfielduzduotIsoAtmntyje;
    JLabel uzduotVartAtmntyje;
    public JTextField textfielduzduotVartAtmntyje;
    JLabel pertraukimas;
    public JTextField textfieldpertraukimas;
    JLabel pranesApiePertrauk;
    public JTextField textfieldPranesApiePertrauk;
    JLabel eiluteAtmintyje;
    public JTextField textfieldEiluteAtmintyje;
    JLabel spausdintuvas;
    public JTextField textfieldSpausdintuvas;
    JLabel SI;
    public JTextField textfieldSI;
    JLabel IOI;
    public JTextField textfieldIOI;
    JLabel TI;
    public JTextField textfieldTI;
    JLabel MODE;
    public JTextField textfieldMODE;
    JLabel CH;
    public JTextField textfieldCH;
    JTable memory;
    public JTextArea output;

    JLabel StartStop;
    public JTextField textfieldStartStop;
    JLabel Loader;
    public JTextField textfieldLoader;
    JLabel MainProc;
    public JTextField textfieldMainProc;
    JLabel JobGovernor;
    public JTextField textfieldJobGovernor;
    JLabel VirtualMachine;
    public JTextField textfieldVirtualMachine;
    JLabel Interrupt;
    public JTextField textfieldInterrupt;
    JLabel SendToPrinter;
    public JTextField textfieldSendToPrinter;



    private GUI() {
        setLayout(new FlowLayout());

//--------------registrai
        R1 = new JLabel("R1");
        add(R1);

        textfieldR1 = new JTextField("0", 4);
        add(textfieldR1);

        R2 = new JLabel("R2");
        add(R2);

        textfieldR2 = new JTextField("0", 4);
        add(textfieldR2);

        IC = new JLabel("IC");
        add(IC);

        textfieldIC = new JTextField("0", 2);
        add(textfieldIC);

        C = new JLabel("C");
        add(C);

        textfieldC = new JTextField("0", 1);
        add(textfieldC);

        PLR = new JLabel("PLR");
        add(PLR);

        textfieldPLR = new JTextField("0", 4);
        add(textfieldPLR);


        PI = new JLabel("PI");
        add(PI);

        textfieldPI = new JTextField("0", 2);
        add(textfieldPI);

        SI = new JLabel("SI");
        add(SI);

        textfieldSI = new JTextField("0", 2);
        add(textfieldSI);

        IOI = new JLabel("IOI");
        add(IOI);

        textfieldIOI = new JTextField("0", 2);
        add(textfieldIOI);

        TI = new JLabel("TI");
        add(TI);

        textfieldTI = new JTextField("0", 4);
        add(textfieldTI);

        MODE = new JLabel("MODE");
        add(MODE);

        textfieldMODE = new JTextField("0", 1);
        add(textfieldMODE);

        CH = new JLabel("CH1");
        add(CH);

        textfieldCH = new JTextField("0", 1);
        add(textfieldCH);


        // resursai

        pranesPrLoader = new JLabel("PranesimasProcosuiLoader");
        add(pranesPrLoader);

        textfieldPranesPrLoader = new JTextField("NotCreated", 10);
        add(textfieldPranesPrLoader);

        MOSPab = new JLabel("MOSPabaiga");
        add(MOSPab);

        textfieldMOSPab = new JTextField("NotCreated", 10);
        add(textfieldMOSPab);

        uzduotIsoAtmntyje = new JLabel("UzduotisIsorinejeAtmintyje");
        add(uzduotIsoAtmntyje);

        textfielduzduotIsoAtmntyje = new JTextField("NotCreated", 10);
        add(textfielduzduotIsoAtmntyje);

        uzduotVartAtmntyje = new JLabel("UzduotisVartotojoAtmintyje");
        add(uzduotVartAtmntyje);

        textfielduzduotVartAtmntyje = new JTextField("NotCreated", 10);
        add(textfielduzduotVartAtmntyje);

        pertraukimas = new JLabel("Pertraukimas");
        add(pertraukimas);

        textfieldpertraukimas = new JTextField("NotCreated", 10);
        add(textfieldpertraukimas);

        pranesApiePertrauk = new JLabel("PranesimasApiePertraukima");
        add(pranesApiePertrauk);

        textfieldPranesApiePertrauk = new JTextField("NotCreated", 10);
        add(textfieldPranesApiePertrauk);

        eiluteAtmintyje = new JLabel("EiluteAtmintyje");
        add(eiluteAtmintyje);

        textfieldEiluteAtmintyje = new JTextField("NotCreated", 10);
        add(textfieldEiluteAtmintyje);

        spausdintuvas = new JLabel("Spausdintuvas");
        add(spausdintuvas);

        textfieldSpausdintuvas = new JTextField("NotCreated", 10);
        add(textfieldSpausdintuvas);


//---------------memory
        String[] columnNames = {"number", "in" };



        for(int i=0; i <= 4095; i++) {
            data[i][0] = String.valueOf(i);
            data[i][1] = "0";
        }

        memory = new JTable(data, columnNames);
        memory.setPreferredScrollableViewportSize(new Dimension(130, 300));
        memory.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(memory);
        add(scrollPane);


        //----------procesai

        StartStop = new JLabel("StartStop");
        add(StartStop);

        textfieldStartStop = new JTextField("WaitingForProcessor", 13);
        add(textfieldStartStop);

        Loader = new JLabel("Loader");
        add(Loader);

        textfieldLoader = new JTextField("WaitingForProcessor", 13);
        add(textfieldLoader);


        MainProc = new JLabel("MainProc");
        add(MainProc);

        textfieldMainProc = new JTextField("WaitingForProcessor", 13);
        add(textfieldMainProc);


        JobGovernor = new JLabel("JobGovernor");
        add(JobGovernor);

        textfieldJobGovernor = new JTextField("WaitingForProcessor", 13);
        add(textfieldJobGovernor);

        VirtualMachine = new JLabel("VirtalMachine");
        add(VirtualMachine);

        textfieldVirtualMachine = new JTextField("WaitingForProcessor", 13);
        add(textfieldVirtualMachine);

        Interrupt = new JLabel("Interrupt");
        add(Interrupt);

        textfieldInterrupt = new JTextField("WaitingForProcessor", 13);
        add(textfieldInterrupt);

        {SendToPrinter = new JLabel("SendToPrinter");
            add(SendToPrinter);

            textfieldSendToPrinter = new JTextField("WaitingForProcessor", 13);
            add(textfieldSendToPrinter);}

        //--------------mygtukai


        MOSStepByStepButton = new JButton("MOS Step By Step");
        add(MOSStepByStepButton);

        PushMOSStepByStep pushMOSStepByStep  = new PushMOSStepByStep ();
        MOSStepByStepButton.addActionListener(pushMOSStepByStep);

    }


    public void Timer() {

        int TI = Integer.valueOf(textfieldTI.getText());
        if (TI != 0) {
            TI--;
            textfieldTI.setText(String.valueOf(TI));
        } else {
            textfieldTI.setText("0");
        }

    }

    public static GUI getInstance() {
        if (GUI.instance == null) {
            GUI.instance = new GUI();
        }
        return GUI.instance;
    }


    public class PushMOSStepByStep implements ActionListener {
        public void actionPerformed(ActionEvent pushStart) {
            Process p= new Process();
            MOSMain m = new MOSMain();
            if(start){
                p.StartStop();
                start = false;
            } else if((textfieldVirtualMachine.getText().equals("Working"))||(textfieldInterrupt.getText().equals("Working"))) {
                if (newProc){
                    if (InputData.timeList.isEmpty()){
                        endMos = true;
                    }else {
                        procPlace = getPlace(InputData.timeList);

                        newProc = false;
                        textfieldIC.setText(String.valueOf(procPlace));

                        InputData.timeList.remove(0);
                    }
                }
                if (!endProc || !endMos){

                    int IC = Integer.valueOf(textfieldIC.getText());

                    new Check (data[IC][1], data[IC+1][1],procPlace);
                    IC = IC + 2;
                    textfieldIC.setText(String.valueOf(IC));

                    if ("S".equals(textfieldMODE.getText())){
                        if (data[IC][1]=="exit"){
                            setRegister();
                            textfieldMODE.setText("V");
                            p.Interrupt();
                        }
                    }else if ("V".equals(textfieldMODE.getText())){
                        Timer();
                        p.VirtualMachine();
                        if (textfieldPI.getText().equals("1")){
                            p.Interrupt();
                            textfieldMODE.setText("S");
                            textfieldTI.setText("10");
                            saveRegister();
                            textfieldPLR.setText("0");
                            textfieldTI.setText("0");
                            textfieldIC.setText(data[0][1]);

                        }else if (!textfieldSI.getText().equals("0")) {
                            p.Interrupt();
                            textfieldMODE.setText("S");
                            textfieldTI.setText("10");
                            saveRegister();
                            textfieldPLR.setText("0");
                            textfieldTI.setText("0");
                            textfieldIC.setText(data[1][1]);

                        }else if (textfieldTI.getText().equals("0")){
                            p.Interrupt();
                            textfieldMODE.setText("S");
                            textfieldTI.setText("10");
                            saveRegister();
                            textfieldPLR.setText("0");
                            textfieldTI.setText("0");
                            textfieldIC.setText(data[2][1]);


                        } else if (!textfieldIOI.getText().equals("0")){
                            p.Interrupt();
                            textfieldMODE.setText("S");
                            textfieldTI.setText("10");
                            saveRegister();
                            textfieldPLR.setText("0");
                            textfieldTI.setText("0");
                            textfieldIC.setText(data[3][1]);
                        }else if (printer == true){
                            p.SendToPrinter();
                            printer = false;
                            try {
                                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("result.txt", true)));
                                out.println("R1: " + Integer.valueOf(textfieldR1.getText()) + "R2: " + Integer.valueOf(textfieldR2.getText()));
                                out.close();
                            } catch (IOException e) {
                                //exception handling left as an exercise for the reader
                            }

                        }
                    }
                }
            }else m.planner2();

            if (endMos){
                textfieldVirtualMachine.setText("WaitingForProcessor");
                p.StartStop();
                p.clearResources();
                System.out.println("MOS sitemos pabaiga!");
            }


        }
    }

    private void saveRegister() {
        data[50][1] = textfieldR1.getText();
        data[51][1] = textfieldR2.getText();
        data[52][1] = textfieldIC.getText();
        data[53][1] = textfieldC.getText();
        data[54][1] = textfieldPLR.getText();
        data[55][1] = textfieldTI.getText();
    }

    public void setRegister(){
        textfieldR1.setText(data[50][1]);
        textfieldR2.setText(data[51][1]);
        textfieldIC.setText(data[52][1]);
        textfieldC.setText(data[53][1]);
        textfieldPLR.setText(data[54][1]);
        textfieldTI.setText(data[55][1]);
    }

    public int getPlace (ArrayList<Integer> temp){
        int x = temp.get(0);
        int place = 0;
        for (int i=59;i<(59+InputData.size);i++){
            if (Integer.valueOf(data[i][1]) == x){
                place = i;
            }
            if (place == 59){place = 255;}
            else if (place == 60){place = 511;}
            else if (place == 61){place = 767;}
            else if (place == 62){place = 1023;}
            else if (place == 63){place = 1279;}
            else if (place == 64){place = 1535;}
            else if (place == 65){place = 1791;}
            else if (place == 66){place = 2047;}
            else if (place == 67){place = 2303;}
            else if (place == 68){place = 2559;}
            else if (place == 69){place = 2815;}
            else if (place == 70){place = 3071;}
        }
        return place;
    }
}